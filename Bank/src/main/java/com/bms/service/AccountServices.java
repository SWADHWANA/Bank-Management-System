package com.bms.service;

import java.util.Scanner;

import com.bms.dao.AccountDAO;
import com.bms.driver.BankDriver;

public class AccountServices {
	 public void AccountMenu() {
		 AccountDAO c=new AccountDAO();
	    
	    	System.out.println("WELCOME TO ACCOUNT SERVICES");
	    	System.out.println("OPTION 1: Create New Account");
	    	System.out.println("OPTION 2: View All Account");
	    	System.out.println("OPTION 3: Update An Account");
	    	System.out.println("OPTION 4: Delete");
	    	System.out.println("OPTION 5: Back To Main Menu");
	    	
	    	
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("ENTER OPTION NO: ");
	    	int option=sc.nextInt();
	    	
	    	switch(option) {
	    	    case 1:c.insertAccount();
			break;
			
		    case 2:c.viewAccount();
		    	break;
		    	
		    case 3:c.updateAccount();
		    	break;
		    	
		    case 4:c.deleteAccount();
		    	break;
		    	
		    case 5:BankDriver bd = new BankDriver();
			bd.adminMenu();
		    	break;
	    	}
	    	
	    }
}
