package com.bms.dao;

import java.util.List;
import java.util.Scanner;

import com.bms.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomerDAO {
	Customer customer = new Customer();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public void insertCustomer() {
    
        et.begin();
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of customer: ");
        int count=sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= count; i++) {

            System.out.println("\nEnter details for Customer " + i);

            System.out.print("Name: ");
            String name = sc.nextLine();
            
            System.out.print("Email: ");
            String email = sc.nextLine();
            
            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            
            System.out.print("Phone: ");
            long phone = sc.nextLong();
            
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhno(count);
            customer.setAddress(address);
            customer.setAge(age);
            
            em.persist(customer);
        }
      
        et.commit();

        em.close();

        System.out.println("Data inserted successfully");
    }
    public void viewCustomer() {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("bank");
    	EntityManager em=emf.createEntityManager();
    	Query query=em.createQuery("select c FROM Customer c");
    	List<Customer>l=query.getResultList();
    	for(Customer c1:l) {
    		System.out.println(c1.getId());
    		System.out.println(c1.getName());
    		System.out.println(c1.getEmail());
    		System.out.println(c1.getPhno());
    	}
    }
    public void updateCustomer() {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("bank");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Id : ");
        int id = sc.nextInt();
        sc.nextLine();

        Customer c = em.find(Customer.class, id);

        if (c != null) {

            et.begin();

            System.out.println("New Name : ");
            String name = sc.nextLine();

            System.out.println("New Email : ");
            String email = sc.next();

            System.out.println("New Phone : ");
            Long phone = sc.nextLong();

            c.setName(name);
            c.setEmail(email);
            c.setPhno(id);

            em.merge(c);
            et.commit();

            System.out.println("Customer updated successfully");

        } else {
            System.out.println("Customer not found");
        }

        em.close();
        emf.close();
    }
    public void deleteCustomer() {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID : ");
        int id = sc.nextInt();

        Customer customer = em.find(Customer.class, id);

        if (customer != null) {

            et.begin();
            em.remove(customer);
            et.commit();

            System.out.println("Customer deleted successfully ");

        } else {
            System.out.println("Customer not found ");
        }
    }
}

