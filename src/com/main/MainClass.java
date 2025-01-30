package com.main;

import com.biling.Bill;
import com.biling.ReturnBill;
import com.customer.*;
import com.menu.Menu;
import com.parts.*;
import com.services.*;
import com.vehicle.*;

import java.io.Serializable;
import java.util.*;
import com.biling.*;

public class MainClass implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ManageCustomer manageCustomer = new ManageCustomer();
		ManageVehicle manageVehicle = new ManageVehicle();
		ManageServices manageServices = new ManageServices();
		PartManager partManager = new PartManager();
		Bill bill = new Bill();
		ReturnBill returnBill = new ReturnBill();
		Customer customer=new Customer();

		// ManageService manageService = new ManageService();
		Maintenance maintenance = new Maintenance();

		Menu menu = new Menu();

		while (true) {
			menu.displayMainMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				System.out.println("Exiting the system...");
				return;
			case 1:
				handleCustomerMenu(scanner, manageCustomer);
				break;
			case 2:
				handleVehicleMenu(scanner, manageVehicle, manageCustomer, customer);
				break;
			case 3:
				handleServiceRequestMenu(scanner, manageServices, manageCustomer, manageVehicle, partManager);
				break;
			case 4:
				handlePartsMenu(scanner, partManager);

				break;
			case 5:
				System.out.println("Displaying today's business (Placeholder)");
				ServiceSubMenuLogic s = new ServiceSubMenuLogic();
				s.viewTodaysBusiness();

				break;
			case 6:
				System.out.println("Enter date (Placeholder):");
				ServiceSubMenuLogic s1 = new ServiceSubMenuLogic();
				s1.viewBusinessByDate(null);
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}
		}
	}

	private static void handleCustomerMenu(Scanner scanner, ManageCustomer manageCustomer) {
		Menu menu = new Menu();

		while (true) {
			menu.displayCustomerMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				return;
			case 1:
				addCustomer(scanner, manageCustomer);
				break;
			case 2:
				manageCustomer.displayAllCustomers();
				break;
			case 3:
				displayCustomerDetails(scanner, manageCustomer);
				break;
			case 4:
				editCustomer(scanner, manageCustomer);
				break;
			case 5:
				deleteCustomer(scanner, manageCustomer);
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void addCustomer(Scanner scanner, ManageCustomer manageCustomer) {
		System.out.print("Enter customer name: ");
		String name = scanner.nextLine();
		System.out.print("Enter customer address: ");
		String address = scanner.nextLine();
		System.out.print("Enter customer mobile number: ");
		String mobileNumber = scanner.nextLine();

		Customer customer = new Customer(name, address, mobileNumber);
		manageCustomer.addCustomer(customer);
		System.out.println("Customer added successfully!");
	}

	private static void displayCustomerDetails(Scanner scanner, ManageCustomer manageCustomer) {
		System.out.print("Enter customer mobile number: ");
		String mobileNumber = scanner.nextLine();
		Customer customer = manageCustomer.getCustomer(mobileNumber);
		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("Customer not found.");
		}
	}

	private static void editCustomer(Scanner scanner, ManageCustomer manageCustomer) {
		System.out.print("Enter customer mobile number to edit: ");
		String mobileNumber = scanner.nextLine();
		Customer customer = manageCustomer.getCustomer(mobileNumber);
		if (customer != null) {
			System.out.print("Enter new name: ");
			customer.setName(scanner.nextLine());
			System.out.print("Enter new address: ");
			customer.setAddress(scanner.nextLine());
			System.out.print("Enter new mobile number: ");
			customer.setMobileNumber(scanner.nextLine());
			System.out.println("Customer details updated.");
		} else {
			System.out.println("Customer not found.");
		}
	}

	private static void deleteCustomer(Scanner scanner, ManageCustomer manageCustomer) {
		System.out.print("Enter customer mobile number to delete: ");
		String mobileNumber = scanner.nextLine();
		manageCustomer.deleteCustomer(mobileNumber);
		System.out.println("Customer deleted.");
	}

	private static void handleVehicleMenu(Scanner scanner, ManageVehicle manageVehicle, ManageCustomer manageCustomer, Customer customer) {
		Menu menu = new Menu();

		while (true) {
			menu.displayVehicleMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 0:
				return;
			case 1:
				addVehicle(scanner, manageVehicle, manageCustomer);
				break;
			case 2:
				displayAllVehicles(manageCustomer);
				break;
			case 3:
				displayCustomerVehicles(scanner, manageVehicle, manageCustomer);
				break;
			case 4:
				editVehicle(scanner, manageVehicle,  manageCustomer,customer);
				break;
			case 5:
				deleteVehicle(scanner, manageVehicle);
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void addVehicle(Scanner scanner, ManageVehicle manageVehicle, ManageCustomer manageCustomer) {
		System.out.print("Enter customer mobile number for vehicle: ");
		String mobileNumber = scanner.nextLine();
		Customer customer = manageCustomer.getCustomer(mobileNumber);
		if (customer != null) {
			System.out.print("Enter vehicle registration number: ");
			String vehicleNumber = scanner.nextLine();
			System.out.print("Enter vehicle company name: ");
			String vehicleType = scanner.nextLine();
			Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType, mobileNumber);
			manageVehicle.addVehicle(vehicle);
			customer.addVehicle(vehicle);
			manageCustomer.saveCustomers();
			System.out.println("Vehicle added successfully.");
		} else {
			System.out.println("Customer not found.");
		}
	}

     public static void displayAllVehicles(ManageCustomer manageCustomer) {
    	 manageCustomer.loadCustomers();
    	 HashSet<Customer> customers=manageCustomer.getCustomers();
    	 for(Customer customer: customers) {
             
            	 customer.getVehicles().values().forEach(System.out::println);
    	 }
    	 
    	 
    }
	
	private static void displayCustomerVehicles(Scanner scanner, ManageVehicle manageVehicle,
			ManageCustomer manageCustomer) {
		manageCustomer.loadCustomers();
		System.out.print("Enter customer mobile number to view vehicles: ");
		String mobileNumber = scanner.nextLine();
		Customer customer = manageCustomer.getCustomer(mobileNumber);
		if (customer != null) {
			customer.getVehicles().values().forEach(System.out::println);
		} else {
			System.out.println("Customer not found.");
		}
	}

	private static void editVehicle(Scanner scanner, ManageVehicle manageVehicle, ManageCustomer manageCustomer,Customer customer) {
		System.out.print("Enter vehicle registration number to edit: ");
		String vehicleNumber = scanner.nextLine();
		 manageCustomer.loadCustomers();
		 Vehicle vehicle=customer.getVehicles().get(vehicleNumber);
		 if (customer != null) {
			 System.out.print("Enter vehicle registration number: ");
				vehicle.setVehicleNumber(scanner.nextLine());
				System.out.print("Enter vehicle company name: ");
				vehicle.setType(scanner.nextLine());
				manageCustomer.saveCustomers();
				System.out.println("Vehicle edited successfully.");
			} else {
				System.out.println("vehicle not found.");
			}
    	 
    	 
	}

	private static void deleteVehicle(Scanner scanner, ManageVehicle manageVehicle) {
		System.out.print("Enter vehicle registration number to delete: ");
		String vehicleNumber = scanner.nextLine();
		manageVehicle.deleteVehicle(vehicleNumber);
		System.out.println("Vehicle deleted.");
	}

	private static void handleServiceRequestMenu(Scanner scanner, ManageServices manageServices,
			ManageCustomer manageCustomer, ManageVehicle manageVehicle, PartManager partManager) {
		Menu menu = new Menu();

		while (true) {
			menu.displayServiceRequestMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 0:
				return;
			case 1:
				//selectCustomerVehicle(scanner, manageCustomer, manageVehicle);
				break;
			case 2:

				ServiceSubMenuLogic sb = new ServiceSubMenuLogic();

				sb.handleServiceRequestMenu(scanner, manageServices, manageCustomer, manageVehicle, partManager);
			//	processRequest(scanner, manageServices, manageCustomer, manageVehicle, partManager);

				break;
			case 3:
				prepareAndDisplayBill();
				
				break;
			case 4:
				getBillPaymentFromCustomer();
				ReturnBill b1 = new ReturnBill();
				b1.viewBusinessByDate(scanner);
				b1.viewReturnBillDetails(b1);
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

//	private static void selectCustomerVehicle(Scanner scanner, ManageCustomer manageCustomer,
//			ManageVehicle manageVehicle) {
//		System.out.print("Enter customer mobile number to select vehicle: ");
//		String mobileNumber = scanner.nextLine();
//		Customer customer = manageCustomer.getCustomer(mobileNumber);
//		if (customer != null) {
//			customer.getVehicles().values().forEach(System.out::println);
//		} else {
//			System.out.println("Customer not found.");
//		}
//	}

	private static void processRequest(Scanner scanner, ManageServices manageServices, ManageCustomer manageCustomer,
	ManageVehicle manageVehicle, PartManager partManager) {

		System.out.println("Processing service request...");
		Menu menu = new Menu();
		menu.displayProcessRequestMenu();
	System.out.println(menu);
		

	 }

	@Override
	public String toString() {
		return "MainClass [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	private static void prepareAndDisplayBill() {

		System.out.println("Generating Bill...");
//        ReturnBill b = new ReturnBill ();
//        Scanner sc = new Scanner(System.in);
//        
//        b.createBill(null, null, null, null);
//       // b.viewAllBills();
//       // b.viewReturnBillDetails(null);
//        System.out.println(b);

	}

	private static void getBillPaymentFromCustomer() {

		System.out.println("Processing bill payment");
	}

	private static void handlePartsMenu(Scanner scanner, PartManager partManager) {
		Menu menu = new Menu();

		while (true) {
			menu.displayPartsMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				return;
			case 1:
				addPart(scanner, partManager);
				break;
			case 2:
				partManager.displayAllParts();
				break;
			case 3:
				editPartPrice(scanner, partManager);
				break;
			case 4:
				deletePart(scanner, partManager);
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void addPart(Scanner scanner, PartManager partManager) {
		System.out.print("Enter part name: ");
		String name = scanner.nextLine();
		System.out.print("Enter part price: ");
		double price = scanner.nextDouble();
		partManager.addPart(new Part(name,name, price));
		System.out.println("Part added.");
	}

	private static void editPartPrice(Scanner scanner, PartManager partManager) {
		System.out.print("Enter part name to edit: ");
		String name = scanner.nextLine();
		Part part = partManager.getPart(name);
		if (part != null) {
			System.out.print("Enter new price for " + name + ": ");
			double price = scanner.nextDouble();
			part.setPrice(price);
			System.out.println("Price updated.");
		} else {
			System.out.println("Part not found.");
		}
	}

	private static void deletePart(Scanner scanner, PartManager partManager) {
		System.out.print("Enter part name to delete: ");
		String name = scanner.nextLine();
		partManager.deletePart(name);
		System.out.println("Part deleted.");
	}


	

	public static Date getToday() {
	    return new Date(); 
	}

}

