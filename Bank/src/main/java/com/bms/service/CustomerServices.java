package com.bms.service;

import java.util.Scanner;

import com.bms.dao.CustomerDAO;
import com.bms.driver.BankDriver;

public class CustomerServices {
	 public void CustomerMenu() {
	    	CustomerDAO c=new CustomerDAO();
	    
	    	System.out.println("WELCOME TO CUSTOMER SERVICES");
	    	System.out.println("OPTION 1: Create New Customer");
	    	System.out.println("OPTION 2: View All Customer");
	    	System.out.println("OPTION 3: Update Customer details");
	    	System.out.println("OPTION 4: Delete");
	    	System.out.println("OPTION 5: Back To Main Menu");
	    	
	    	
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("ENTER OPTION NO: ");
	    	int option=sc.nextInt();
	    	
	    	switch(option) {
	    	    case 1:c.insertCustomer();
			break;
			
		    case 2:c.viewCustomer();
		    	break;
		    	
		    case 3:c.updateCustomer();
		    	break;
		    	
		    case 4:c.deleteCustomer();
		    	break;
		    	
		    case 5:BankDriver bd = new BankDriver();
			bd.adminMenu();
		    	break;
	    	}
	    	
	    }
}
