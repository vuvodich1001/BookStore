/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Book;
import com.uit.entity.BookOrder;
import com.uit.entity.OrderDetail;
import com.uit.entity.OrderDetailId;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author vunguyen
 */
public class OrderDao {
    static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public static List<BookOrder> listOrder(){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from BookOrder order by order_id");
        return q.list();
    }
  
    public static List<BookOrder> listOrderforspecificUser(long id){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from BookOrder where customer_id = :id order by order_id asc");
        q.setParameter("id", id);
        return q.list();
    }
    
    public static List<OrderDetail> listDetail(long id){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from OrderDetail where order_id = :id order by order_id asc");
        q.setParameter("id", id);
        return q.list();
    }
    
    public static void addBookorder(BookOrder bookOrder){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(bookOrder);
        t.commit();
        s.close();
    }
    public static void addOder(BookOrder bookOrder, Book book, long quantity, double subtotal){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        OrderDetailId orderDetailId = new OrderDetailId(bookOrder.getOrderId(), book.getBookId());
        OrderDetail orderDetail = new OrderDetail(orderDetailId, book, bookOrder, quantity, subtotal);
        bookOrder.addOrderDetail(orderDetail);
        s.update(bookOrder);
        t.commit();
        s.close();
    }
    
    

    public static void main(String[] args){
           //BookService bookService = new BookService();
//        CustomerService customerService = new CustomerService();
//        Customer customer = new Customer();
       // Session s = sessionFactory.openSession();
        //Transaction t = s.beginTransaction();
//        
//        for(Customer c: customerService.getAllcustomer()){
//            if(c.getCustomerId() == 303){
//                customer = c;
//            }
//        }

        //public OrderDetail(OrderDetailId id, Book book, BookOrder bookOrder, Long quantity, Double subtotal)
        
       
 
//        for(Book list : bookService.getAllbook()){
//            if(list.getBookId() == 161){
//                BookOrder bookOrder = new BookOrder(customer, new java.util.Date(), "tphcm", "test", "123456", "Paypal", 300.0, "0");
//                s.save(bookOrder);
//                
//                OrderDetailId ordertailId = new OrderDetailId(bookOrder.getOrderId() , list.getBookId());
//                
//                OrderDetail orderDetail = new OrderDetail(ordertailId, list, bookOrder, Long.valueOf(15) , 300.0);
//                
//                bookOrder.addOrderDetail(orderDetail);
//                
//                s.save(bookOrder);
//            }
//        }
//        t.commit();
//        s.close();
      
       
    }
}
