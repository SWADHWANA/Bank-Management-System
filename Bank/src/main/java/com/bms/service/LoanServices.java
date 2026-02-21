package com.bms.service;

import java.util.Scanner;

import com.bms.dao.LoanDAO;
import com.bms.driver.BankDriver;

public class LoanServices {
	public void LoanMenu() {
    	LoanDAO ls =new LoanDAO();
    
    	System.out.println("WELCOME TO Loan SERVICES");
    	System.out.println("OPTION 1: Create New Loan");
    	System.out.println("OPTION 2: View All Loan");
    	System.out.println("OPTION 3: Update Loan details");
    	System.out.println("OPTION 4: Delete");
    	System.out.println("OPTION 5: Back To Main Menu");
    	
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("ENTER OPTION NO: ");
    	int option=sc.nextInt();
    	
    	switch(option) {
    	    case 1:ls.insertLoan();
		break;
		
	    case 2:ls.viewLoan();
	    	break;
	    	
	    case 3:ls.updateLoan();
	    	break;
	    	
	    case 4:ls.deleteLoan();
	    	break;
	    	
	    case 5:BankDriver m = new BankDriver();
		m.adminMenu();
	    	break;
    	}
    }

}
