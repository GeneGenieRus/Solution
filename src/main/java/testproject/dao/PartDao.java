package testproject.dao;

import testproject.model.Part;

import java.util.List;

public interface PartDao {
    public void addPart(Part part);
    public void updatePart(Part part);
    public void removePart(int id);
    public Part getPartById(int id);
    public List<Part> getList(int page, String param, String search);
    int getPartsAmount(String param, String search);
    int getComplect();
}
