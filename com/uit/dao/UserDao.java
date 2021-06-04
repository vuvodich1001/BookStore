/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Usr;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vunguyen
 */
public class UserDao {
    final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static List<Usr> getAlluser(){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Usr order by usr_id asc");
        return q.list();
    }
    
    public static void addUser(Usr user ){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(user);
        t.commit();
        s.close();
    }
    
    public static void deleteUser(int id){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Usr where usr_id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        t.commit();
        s.close();
    }
    
    public static void editUser(Usr user){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
//        Query q = s.createQuery("update Usr set full_name = :fullName, password = :password, email = :email where usr_id = :usrId");
//        q.setParameter("fullName", user.getFullName());
//        q.setParameter("password", user.getPassword());
//        q.setParameter("email", user.getEmail());
//        q.setParameter("usrId", user.getUsrId());
//        q.executeUpdate();
        s.update(user);
        t.commit();
        s.close();
    }
    
    public static long check(String username, String password){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("select count(*) from Usr where full_name = :username and password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        return (long) q.uniqueResult();
    }
    
    public static List<Usr> findUser(String username){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Usr where full_name like :username");
        q.setParameter("username", "%" + username + "%");
        return q.list();
    }
}
