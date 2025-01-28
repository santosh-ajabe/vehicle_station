package com.stationui;
import javax.swing.*;

public class ServiceStationFrame extends JFrame {
    
	private static final long serialVersionUID = 1L;

	public ServiceStationFrame() {
        // Set frame properties
		setTitle("Vehicle Service Station");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 400);
        setLayout(null);

        // Add components
        initComponents();
    }

    private void initComponents() {
        // Date Label and Field
   
        JTextField dateField = new JTextField("25-09-2015");
        dateField.setBounds(20, 20, 90, 25);
        add(dateField);

        // Accounts Button
        JButton accountsButton = new JButton("Accounts");
        accountsButton.setBounds(125, 20,85, 25);
        add(accountsButton);

        

        // Details and Amount Table
        
        JTable detailsTable = new JTable(new Object[][]{}, new String[]{"Details", "Amount"});
        JScrollPane tableScrollPane = new JScrollPane(detailsTable);
        tableScrollPane.setBounds(20, 60,195, 20);
        add(tableScrollPane);

        // Total Business Label
        JLabel totalBusinessLabel = new JLabel("Total Business: Rs. 0.0");
        totalBusinessLabel.setBounds(20, 260, 200, 20);
        add(totalBusinessLabel);

        // Print Bill and Save All Buttons
        JButton printBillButton = new JButton("Print Bill");
        printBillButton.setBounds(20, 300, 90, 25);
        add(printBillButton);

        JButton saveAllButton = new JButton("Save All");
        saveAllButton.setBounds(120, 300, 90, 25);
        add(saveAllButton);
        
        
     // Active Service Requests List
        JLabel activeRequestsLabel = new JLabel("Active Service Reqest");
        activeRequestsLabel.setBounds(225,20, 200,20);
        add(activeRequestsLabel);
       
        JList<String> activeRequestsList = new JList<>(new String[]{});
        //activeRequestsList.setBounds(225,50, 150, 200);
        add(activeRequestsList);
        
        JScrollPane serviceReqScrollPane = new JScrollPane(activeRequestsList);
        serviceReqScrollPane.setBounds(225,50, 150, 200);
        add(serviceReqScrollPane);
        
        

        // Finish Request Button
        JButton finishRequestButton = new JButton("Finish Request");
        finishRequestButton.setBounds(225,260,150, 25);
        add(finishRequestButton);
        
        //new request
        JButton newServiceRequestButton = new JButton("New Service Req");
        newServiceRequestButton.setBounds(225,300,150, 25);
        add(newServiceRequestButton);

        // Customer and Service Section
        JLabel customerLabel = new JLabel("sakshi");
        customerLabel.setBounds(400, 40, 100, 20);
        add(customerLabel);

        JLabel serviceIDLabel = new JLabel("615");
        serviceIDLabel.setBounds(400,60, 100, 20);
        add(serviceIDLabel);

        JList<String> serviceList = new JList<>(new String[]{
                "[M] regular - 200.0",
                "[M] headlights - 40.0",
                "[O] engine_oil - 300.0"
        });
        JScrollPane serviceScrollPane = new JScrollPane(serviceList);
        serviceScrollPane.setBounds(400, 80, 140, 200);
        add(serviceScrollPane);
        
        JScrollPane partScrollPane = new JScrollPane();
        partScrollPane.setBounds(560, 80, 140, 200);
        add(partScrollPane);
        
        // New Service and New Part Buttons
        JButton newServiceButton = new JButton("New Service");
        newServiceButton.setBounds(400, 300, 140, 25);
        add(newServiceButton);

        JButton newPartButton = new JButton("New Part");
        newPartButton.setBounds(560, 300, 140, 25);
        add(newPartButton);
    }
}
