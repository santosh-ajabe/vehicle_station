package com.stationui;
import javax.swing.*;

public class ServiceStationFrame extends JFrame {
    
	private static final long serialVersionUID = 1L;

	public ServiceStationFrame() {
   
        setTitle("Vehicle Service Station - Java Programming @ SunBeam Infotech");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(null);

        
        initComponents();
    }

    private void initComponents() {
        // Date Label and Field
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(20, 20, 50, 20);
        add(dateLabel);

        JTextField dateField = new JTextField("25-09-2015");
        dateField.setBounds(70, 20, 120, 20);
        add(dateField);

        // Accounts Button
        JButton accountsButton = new JButton("Accounts");
        accountsButton.setBounds(200, 20, 100, 20);
        add(accountsButton);

        // Active Service Requests List
        JLabel activeRequestsLabel = new JLabel("Active Service Req.");
        activeRequestsLabel.setBounds(200, 60, 200, 150);
        add(activeRequestsLabel);

        JList<String> activeRequestsList = new JList<>(new String[]{});
        activeRequestsList.setBounds(200, 80, 200, 150);
        add(activeRequestsList);

        // Finish Request Button
        JButton finishRequestButton = new JButton("Finish Request");
        finishRequestButton.setBounds(200, 300, 150, 30);
        add(finishRequestButton);

        // Details and Amount Table
        
        JTable detailsTable = new JTable(new Object[][]{}, new String[]{"Details", "Amount"});
        JScrollPane tableScrollPane = new JScrollPane(detailsTable);
        tableScrollPane.setBounds(20, 60, 150, 20);
        add(tableScrollPane);

        // Total Business Label
        JLabel totalBusinessLabel = new JLabel("Total Business: Rs. 0.0");
        totalBusinessLabel.setBounds(20, 240, 200, 20);
        add(totalBusinessLabel);

        // Print Bill and Save All Buttons
        JButton printBillButton = new JButton("Print Bill");
        printBillButton.setBounds(20, 270, 100, 30);
        add(printBillButton);

        JButton saveAllButton = new JButton("Save All");
        saveAllButton.setBounds(150, 270, 100, 30);
        add(saveAllButton);

        // Customer and Service Section
        JLabel customerLabel = new JLabel("sakshi");
        customerLabel.setBounds(450, 60, 100, 20);
        add(customerLabel);

        JLabel serviceIDLabel = new JLabel("615");
        serviceIDLabel.setBounds(450, 80, 100, 20);
        add(serviceIDLabel);

        JList<String> serviceList = new JList<>(new String[]{
                "[M] regular - 200.0",
                "[M] headlights - 40.0",
                "[O] engine_oil - 300.0"
        });
        JScrollPane serviceScrollPane = new JScrollPane(serviceList);
        serviceScrollPane.setBounds(450, 110, 200, 100);
        add(serviceScrollPane);

        // New Service and New Part Buttons
        JButton newServiceButton = new JButton("New Service");
        newServiceButton.setBounds(450, 220, 120, 30);
        add(newServiceButton);

        JButton newPartButton = new JButton("New Part");
        newPartButton.setBounds(580, 220, 100, 30);
        add(newPartButton);
    }
}
