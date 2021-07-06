/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static boolean checkReviewDuplicate(long bookId, long customerId){
       Session s = sessionFactory.openSession();
       Query q = s.createQuery("select count(*) from Review where customer_id = :customerId and book_id = :bookId");
       q.setParameter("bookId", bookId);
       q.setParameter("customerId", customerId);
       return (long)q.uniqueResult() >= 1;
    }
    
    public static boolean checkReview(long bookId, long customerId){
       boolean result = false;
       Connection con = JDBCConnection.getJDBCConnection();
       String sql = "select count(*) as sl from book_order b join order_detail o on b.order_id = o.order_id where customer_id = ? and book_id = ?"
               + "and status = 'Completed'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, customerId);
            ps.setLong(2, bookId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getLong("sl") >= 1){
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static void main(String[] args){
        for(Review r : listAllreviewbyBookId(184)){
            System.out.println(r.getHeadline());
        }
    }
}
