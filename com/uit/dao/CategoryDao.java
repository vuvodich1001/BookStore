/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Category;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vunguyen
 */
public class CategoryDao {
    final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static List<Category> getAllcategory(){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Category order by category_id asc");
        return q.list();
    }
    public static void addCategory(Category category){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(category);
        t.commit();
        s.close();
    }
    
    public static void deleteCategory(int id){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Category where category_id = :categoryId");
        q.setParameter("categoryId", id);
        q.executeUpdate();
        t.commit();
        s.close();
    }
    
    public static void editCategory(Category category){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
//        Query q = s.createQuery("update Category set name = :name where category_id = :categoryId");
//        q.setParameter("name", category.getName())
//         .setParameter("categoryId", category.getCategoryId());
//        q.executeUpdate();
        s.update(category);
        t.commit();
        s.close();
    }
    
    public static List<Category> findCategory(String name){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Category where name like :name");
        q.setParameter("name", "%" + name + "%");
        return q.list();
    }
    public static void main(String[] args){
        Category c = new Category();
        c.setName("VatLi");
        addCategory(c);
    }
}
