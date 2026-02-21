package com.bms.dao;

import java.util.List;
import java.util.Scanner;
import com.bms.entity.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class LoanDAO {
	Loan Loan = new Loan();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void insertLoan() {
    
        et.begin();
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Loan: ");
        int count=sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter details for Loan " + i);

            System.out.print("Tag Name: ");
            String tag = sc.nextLine();
            sc.nextLine();

            Loan Loan = new Loan();
            Loan.setTag(tag);
            em.persist(Loan);
        }
      
        et.commit();

        em.close();

        System.out.println("Data inserted successfully");
    }
    public void viewLoan() {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bank");
    	EntityManager em=emf.createEntityManager();
    	Query query=em.createQuery("select l FROM Loan l");
    	List<Loan>l=query.getResultList();
    	for(Loan l1:l) {
    		System.out.println(l1.getId());
    		System.out.println(l1.getTag());
    	}
    }
    public void updateLoan() {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("bank");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Id : ");
        int id = sc.nextInt();
        sc.nextLine();

        Loan l = em.find(Loan.class, id);

        if (l != null) {

            et.begin();

            System.out.println("New Tag : ");
            String tag = sc.nextLine();

            l.setTag(tag);

            em.merge(l);
            et.commit();

            System.out.println("Loan updated successfully");

        } else {
            System.out.println("Loan not found");
        }

        em.close();
        emf.close();
    }
    public void deleteLoan() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Loan ID : ");
        int id = sc.nextInt();

        Loan Loan = em.find(Loan.class, id);

        if (Loan != null) {

            et.begin();
            em.remove(Loan);
            et.commit();

            System.out.println("Loan deleted successfully ");

        } else {
            System.out.println("Loan not found ");
        }
    }

}
