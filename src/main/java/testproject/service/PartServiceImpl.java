package testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testproject.dao.PartDao;
import testproject.model.Part;

import javax.transaction.Transactional;
import java.util.List;

@Service("partService")
public class PartServiceImpl implements PartService {

    @Autowired
    PartDao partDao;

    public void setPartDao(PartDao partDao) {
        this.partDao = partDao;
    }


    @Transactional
    public void addPart(Part part) {
        partDao.addPart(part);

    }
    @Transactional
    public void updatePart(Part part) {
        partDao.updatePart(part);
    }
    @Transactional
    public void removePart(int id) {
        partDao.removePart(id);
    }
    @Transactional
    public Part getPartById(int id) {
        return partDao.getPartById(id);
    }
    @Transactional
    public List<Part> getList(int page, String param, String search) {
        return partDao.getList(page, param, search);
    }

    @Transactional
    public int getPartsAmount(String param, String search) {
        return partDao.getPartsAmount(param, search);
    }

    @Transactional
    public int getComplect() {
        return partDao.getComplect();
    }
}
