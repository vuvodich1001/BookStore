/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Book;
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
public class BookDao {
    final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static List<Book> getAllbook(){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Book order by book_id asc");
        return q.list();
    }
    
    public static void addBook(Book book){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(book);
        t.commit();
        s.close();
    }
    
    public static void deleteBook(int id){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Book where book_id = :bookId");
        q.setParameter("bookId", id);
        q.executeUpdate();
        t.commit();
        s.close();
    }
    
    public static List<Book> findBook(String name){
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("from Book where lower(title) like :name");
        q.setParameter("name", "%" + name.toLowerCase() + "%");
        return q.list();
    }
    
    public static void editBook(Book book){
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("update Book set title = :title, author = :author, isbn= :isbn, image= :image,"
                + " price= :price, publish_date = :publishDate where book_id = :bookId");
        q.setParameter("title", book.getTitle());
        q.setParameter("author", book.getAuthor());
        q.setParameter("isbn", book.getIsbn());
        q.setParameter("image", book.getImage());
        q.setParameter("price", book.getPrice());
        q.setParameter("publishDate", book.getPublishDate());
        q.setParameter("bookId", book.getBookId());
        q.executeUpdate();
        t.commit();
        s.close();
    }
    
    
    public static void main(String[] args) {
        Category c = new Category();
        c.setName("Java");
        Book b = new Book();
        b.setTitle("test");
        b.setCategory(c);
        addBook(b);
    }
}
