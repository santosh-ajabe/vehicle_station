package com.parts;

import java.util.*;

public class PartManager {
    private HashMap<String, Part> partsInventory;

    public PartManager() {
        partsInventory = new HashMap<>();
    }

    public void addPart(Part part) {
        partsInventory.put(part.getPartId(), part);
    }
    

    public void editPartPrice(String partId, double newPrice) {
        Part part = partsInventory.get(partId);
        if (part != null) {
            part.setPrice(newPrice);
        } else {
            System.out.println("Part not found.");
        }
    }

    public boolean deletePart(String partId) {
        if (partsInventory.containsKey(partId)) {
            partsInventory.remove(partId);
            return true;
        }
        System.out.println("Part not found.");
        return false;
    }

    public Part getPart(String partId) {
        return partsInventory.get(partId);
    }

    public void displayAllParts() {
        if (partsInventory.isEmpty()) {
            System.out.println("No parts available.");
        } else {
            partsInventory.values().forEach(System.out::println);
        }
    }
}
