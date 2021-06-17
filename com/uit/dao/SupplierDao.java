/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Supplier;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vunguyen
 */
public class SupplierDao {
    final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public static List<Supplier> getAllsupplier(){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Supplier order by supplier_id asc");
        return q.list();
    }
    
    public static void addSupplier(Supplier supplier){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(supplier);
        t.commit();
        s.close();
    }
    
    public static void deleteSupplier(long id){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Supplier where supplier_id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        t.commit();
        s.close();
    }
}
