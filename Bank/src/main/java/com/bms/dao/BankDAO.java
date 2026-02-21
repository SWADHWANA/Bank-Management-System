package com.bms.dao;

import java.util.List;
import java.util.Scanner;

import com.bms.entity.Bank;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BankDAO {
	Bank b = new Bank();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void insertBank() {
    
        et.begin();
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Bank: ");
        int count=sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter details for Bank " + i);

            System.out.print("Bank Name: ");
            String name = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            Bank Bank = new Bank();
            Bank.setBankname(name);
            Bank.setBank_add(address);
            
            em.persist(Bank);
        }
      
        et.commit();

        em.close();

        System.out.println("Data inserted successfully");
    }
    public void viewBank() {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bank");
    	EntityManager em=emf.createEntityManager();
    	Query query=em.createQuery("select b FROM Bank b");
    	List<Bank>l=query.getResultList();
    	for(Bank b1:l) {
    		System.out.println(b1.getBank_id());
    		System.out.println(b1.getBankname());
    		System.out.println(b1.getBank_add());
//    		System.out.println(b1.getBranch());
    	}
    }
    public void updateBank() {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("bank");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Id : ");
        int id = sc.nextInt();
        sc.nextLine();

        Bank bs = em.find(Bank.class, id);

        if (bs != null) {

            et.begin();

            System.out.println("New Name : ");
            String name = sc.nextLine();
				
            System.out.println("New Address : ");
            String add = sc.next();

            bs.setBankname(name);
            bs.setBank_add(add);
            
            em.merge(bs);
            et.commit();

            System.out.println("Bank updated successfully");

        } else {
            System.out.println("Bank not found");
        }

        em.close();
        emf.close();
    }
    public void deleteBank() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bank ID : ");
        int id = sc.nextInt();

        Bank bank = em.find(Bank.class, id);

        if (bank != null) {

            et.begin();
            em.remove(bank);
            et.commit();

            System.out.println("Bank deleted successfully ");

        } else {
            System.out.println("Bank not found ");
        }
    }

}
