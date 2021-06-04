/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Customer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vunguyen
 */
public class CustomerDao {
    final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public static long check(String username, String password){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("select count(*) from Customer where full_name = :username and password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        return (long) q.uniqueResult();
    }
    
    public static Customer returnCustomer(String username,  String password){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Customer where full_name = :username and password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        return (Customer)q.uniqueResult();
    }
    
    public static void addCustomer(Customer customer){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(customer);
        t.commit();
        s.close();
    }
    
    public static List<Customer> getAllcustomer(){
        Session s =  sessionFactory.openSession();
        Query q = s.createQuery("from Customer order by customer_id asc");
        return q.list();
    }
    
    public static void deleteCustomer(Customer customer){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Customer where customer_id = :customerId");
        q.setParameter("customerId", customer.getCustomerId());
        q.executeUpdate();
        t.commit();
        s.close();
    }
    
    public static List<Customer> findUser(String username){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Customer where full_name like :username");
        q.setParameter("username", "%" + username + "%");
        return q.list();
    }
}
