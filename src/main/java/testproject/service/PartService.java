package testproject.service;

import testproject.model.Part;


import java.util.List;

public interface PartService {
    void addPart(Part part);
    void updatePart(Part part);
    void removePart(int id);
    Part getPartById(int id);
    List<Part> getList(int page, String param, String search);
    int getPartsAmount(String param, String search);
    int getComplect();
}
