package com.bms.service;

import java.util.Scanner;

import com.bms.dao.BranchDAO;
import com.bms.driver.BankDriver;

public class BranchServices {
	 public void BranchMenu() {
	    	BranchDAO bd =new BranchDAO();
	    
	    	System.out.println("WELCOME TO BRANCH SERVICES");
	    	System.out.println("OPTION 1: Create New Branch");
	    	System.out.println("OPTION 2: View All Branch");
	    	System.out.println("OPTION 3: Update Branch details");
	    	System.out.println("OPTION 4: Delete");
	    	System.out.println("OPTION 5: Back To Main Menu");
	    	
	    	
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("ENTER OPTION NO: ");
	    	int option=sc.nextInt();
	    	
	    	switch(option) {
	    	    case 1:bd.insertBranch();
			break;
			
		    case 2:bd.viewBranch();
		    	break;
		    	
		    case 3:bd.updateBranch();
		    	break;
		    	
		    case 4:bd.deleteBranch();
		    	break;
		    	
		    case 5:BankDriver m = new BankDriver();
			m.adminMenu();
		    	break;
	    	}
	    	
	    }

}
