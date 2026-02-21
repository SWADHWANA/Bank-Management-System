package com.bms.dao;

import java.util.List;
import java.util.Scanner;

import com.bms.entity.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BranchDAO {
	Branch b  = new Branch();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void insertBranch() {
    
        et.begin();
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Branch: ");
        int count=sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter details for Branch " + i);

            System.out.print("Branch Name: ");
            String name = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();


            Branch b  = new Branch();
            b.setAdd(address);
            b.setName(name);

            em.persist(b);
        }
      
        et.commit();

        em.close();

        System.out.println("Data inserted successfully");
    }
    public void viewBranch() {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bank");
    	EntityManager em=emf.createEntityManager();
    	Query query=em.createQuery("select b FROM Branch b");
    	List<Branch>l=query.getResultList();
    	for(Branch b1:l) {
    		System.out.println(b1.getId());
    		System.out.println(b1.getName());
    		System.out.println(b1.getAdd());
    		System.out.println(b1.getAccounts());
    	}
    }
    public void updateBranch() {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("bank");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Id : ");
        int id = sc.nextInt();
        sc.nextLine();

        Branch b = em.find(Branch.class, id);

        if (b != null) {

            et.begin();

            System.out.println("New Name : ");
            String name = sc.nextLine();

            System.out.println("New Address : ");
            String address = sc.next();


            Branch bu = new Branch();
            bu.setName(name);
            bu.setAdd(address);

            em.merge(bu);
            et.commit();

            System.out.println("Branch updated successfully");

        } else {
            System.out.println("Branch not found");
        }

        em.close();
        emf.close();
    }
    public void deleteBranch() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Branch ID : ");
        int id = sc.nextInt();

        Branch b1 = em.find(Branch.class, id);

        if (b1 != null) {

            et.begin();
            em.remove(b1);
            et.commit();

            System.out.println("Branch deleted successfully ");

        } else {
            System.out.println("Branch not found ");
        }
    }

}
