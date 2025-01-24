package com.parts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import com.customer.Customer;

public class PartManager {
    private HashMap<String, Part> partsInventory;
    private final String FILE_NAME = "parts.txt";
    public PartManager() {
        partsInventory = new HashMap<>();
        loadParts();
    }

    public void addPart(Part part) {
        partsInventory.put(part.getPartId(), part);
        saveParts();
    }
    

    public void editPartPrice(String partId, double newPrice) {
        Part part = partsInventory.get(partId);
        if (part != null) {
            part.setPrice(newPrice);
        } else {
            System.out.println("Part not found.");
        }
        saveParts();
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
    private void saveParts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(partsInventory);
        } catch (IOException e) {
            System.out.println("Error saving parts data: " + e.getMessage());
        }
    }
    private void loadParts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            partsInventory = (HashMap<String, Part>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("part file not found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading partInventory data: " + e.getMessage());
        }
    }
}
