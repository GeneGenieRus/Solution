package testproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testproject.model.Part;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PartDaoImpl implements PartDao{


    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addPart(Part part) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(part);
    }

    public void updatePart(Part part) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(part);
    }

    public void removePart(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Part part = (Part) session.load(Part.class, new Integer(id));

        if (part != null)
            session.delete(part);
    }

    public Part getPartById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Part part = (Part) session.get(Part.class, new Integer(id));
        return part;
    }

    public List<Part> getList(int page, String param, String search) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Part> parts = new ArrayList<>();
        String querySearch = "from Part P where P.name like '" + search + "%'";
        switch (param) {
            case "all":
                parts = session.createQuery(querySearch).setFirstResult(10 * (page - 1)).setMaxResults(10).list();
                break;
            case "true":
                parts = session.createQuery(querySearch + " and P.need=true").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
                break;
            case "false":
                parts = session.createQuery(querySearch + " and P.need=false ").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
                break;
        }
        return parts;
    }


    public int getPartsAmount(String param, String search){
        Session session = this.sessionFactory.getCurrentSession();
        String query = "";
        switch (param) {
            case "all":
                query = "select count(*) from Part P  where P.name like '" + search + "%'";
                break;
            case "true":
                query = "select count(*) from Part P where P.need=true and P.name like '" + search + "%'";
                break;
            case "false":
                query = "select count(*) from Part P where P.need=false and P.name like '" + search + "%'";
                break;
        }
        return session.createQuery(query, Number.class).getSingleResult().intValue();
            }

    @Override
    public int getComplect() {
        List<Part> list = sessionFactory.getCurrentSession().createQuery(" from  Part P where P.need=true order by P.amount asc").list();

        if (list.size() > 0)
            return  list.get(0).getAmount();
        else
            return 0;
    }
}
