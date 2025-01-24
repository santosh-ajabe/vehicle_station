package com.customer;

import java.io.*;
import java.util.*;

public class ManageCustomer {
    private HashSet<Customer> customers;
    private final String FILE_NAME = "customers.txt";

    public ManageCustomer() {
        customers = new HashSet<>();
        loadCustomers();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveCustomers();
    }

    public void deleteCustomer(String mobileNumber) {
        customers.removeIf(customer -> customer.getMobileNumber().equals(mobileNumber));
        saveCustomers();
    }

    public Customer getCustomer(String mobileNumber) {
        for (Customer customer : customers) {
            if (customer.getMobileNumber().equals(mobileNumber)) {
                return customer;
            }
        }
        return null;
    }

    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            customers.forEach(System.out::println);
        }
    }

    public void saveCustomers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Error saving customer data " + e.getMessage());
        }
    }

    public void loadCustomers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            customers = (HashSet<Customer>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Customer file not found");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading customer data " + e.getMessage());
        }
    }
}
