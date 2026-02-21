package com.bms.dao;

import java.util.List;
import java.util.Scanner;

import com.bms.entity.Account;
import com.bms.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AccountDAO {
	Account a = new Account();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void insertAccount() {
    
        et.begin();
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Account: ");
        int count=sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter details for Account " + i);

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            
            System.out.print("Account Number: ");
            String accno = sc.next();
            sc.nextLine();

            System.out.print("IFSC code: ");
            long ifsc = sc.nextLong();
            sc.nextLine();

            Account a = new Account();
            a.setAmount(amount);
            a.setNumber(accno);
            a.setIfsc(ifsc);


            em.persist(a);
        }
      
        et.commit();

        em.close();

        System.out.println("Data inserted successfully");
    }
    public void viewAccount() {
    	Account a = new Account();
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bank");
    	EntityManager em=emf.createEntityManager();
    	Query query=em.createQuery("select a FROM Account a");
    	List<Account>l=query.getResultList();
    	for(Account a1:l) { 
    		System.out.println(a1.getId());
    		System.out.println(a1.getAmount());
    		System.out.println(a1.getNumber());
    		System.out.println(a1.getIfsc());
    	}
    }
    public void updateAccount() {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("bank");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Id : ");
        int id = sc.nextInt();
        sc.nextLine();

        Account a1 = em.find(Account.class, id);

        if (a1 != null) {

            et.begin();

            System.out.print("New Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
 
                a1.setAmount(amount);
               
                em.merge(a1);
                et.commit();

                System.out.println("Account updated successfully");

            } else {
                System.out.println("Account not found");
            }

            em.close();
            emf.close();

        }
   
    public void deleteAccount() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();

        Account a = em.find(Account.class, id);

        if (a != null) {

            et.begin();
            em.remove(a);
            et.commit();

            System.out.println("Customer deleted successfully ");

        } else {
            System.out.println("Customer not found ");
        }
    }
}
