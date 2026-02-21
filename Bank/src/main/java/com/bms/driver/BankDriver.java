package com.bms.driver;
import java.util.Scanner;

import com.bms.service.AccountServices;
import com.bms.service.BankServices;
import com.bms.service.BranchServices;
import com.bms.service.CustomerServices;
import com.bms.service.LoanServices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BankDriver {

	public static void main(String[] args) {
		BankDriver bd = new BankDriver();
		bd.adminMenu();
		
		
	}
	
	public void adminMenu() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		AccountServices as = new AccountServices();
		BankServices bn = new BankServices();
		BranchServices bs = new BranchServices();
		CustomerServices cs = new CustomerServices();
		LoanServices ls = new LoanServices();
		
		System.out.println("-----BankManagementSystem-----");
		System.out.println("OPTION 1: MANAGE BANK");
		System.out.println("OPTION 2: MANAGE BRANCH");
		System.out.println("OPTION 3: MANAGE CUSTOMER");
		System.out.println("OPTION 4: MANAGE ACCOUNTS");
		System.out.println("OPTION 5: MANAGE LOAN");
		System.out.println("OPTION 6: EXIT");
		System.out.print("ENTER OPTION NO: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:bn.BankMenu();
			break;
		case 2:bs.BranchMenu();
				break;
		case 3:cs.CustomerMenu();
			break;
		case 4:as.AccountMenu();
			break;
		case 5:ls.LoanMenu();
			break;
		case 6:
			System.out.println("Thank You");
			break;
		default:
			break;
		}
		
	}
}
