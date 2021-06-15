/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Review;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vunguyen
 */
public class ReviewDao {
    final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public static List<Review> listAllreview(){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Review");
        return q.list();
    }
    
    public static void addReview(Review review){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(review);
        t.commit();
        s.close();
    }

    public static List<Review> listAllreviewbyBookId(long id){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Review where book_id = :id order by review_time desc");
        q.setParameter("id", id);
        return q.list();
    }
    public static void main(String[] args){
        for(Review r : listAllreviewbyBookId(184)){
            System.out.println(r.getHeadline());
        }
    }
}
