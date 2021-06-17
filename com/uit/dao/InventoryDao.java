/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.InventoryTracking;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vunguyen
 */
public class InventoryDao {
    final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public static List<InventoryTracking> getAllinventory(){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from InventoryTracking order by tracking_id asc");
        return q.list();
    }
    
    public static void addInventory(InventoryTracking inventoryTracking){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(inventoryTracking);
        t.commit();
        s.close();
    }
    
    public static void deleteInventory(InventoryTracking inventoryTracking){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.delete(inventoryTracking);
        t.commit();
        s.close();
    }
}
