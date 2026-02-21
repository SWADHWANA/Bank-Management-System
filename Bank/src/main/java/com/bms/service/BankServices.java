package com.bms.service;

import java.util.Scanner;

import com.bms.dao.BankDAO;
import com.bms.driver.BankDriver;

public class BankServices {
	public void BankMenu() {
    	BankDAO b =new BankDAO();
    
    	System.out.println("WELCOME TO Bank SERVICES");
    	System.out.println("OPTION 1: Create New Bank");
    	System.out.println("OPTION 2: View All Bank");
    	System.out.println("OPTION 3: Update Bank details");
    	System.out.println("OPTION 4: Delete");
    	System.out.println("OPTION 5: Back To Main Menu");
    	
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("ENTER OPTION NO: ");
    	int option=sc.nextInt();
    	
    	switch(option) {
    	    case 1:b.insertBank();
		break;
		
	    case 2:b.viewBank();
	    	break;
	    	
	    case 3:b.updateBank();
	    	break;
	    	
	    case 4:b.deleteBank();
	    	break;
	    	
	    case 5:BankDriver m = new BankDriver();
		m.adminMenu();
	    	break;
    	}
    }


}
