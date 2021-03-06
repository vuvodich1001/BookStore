/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.OrderDao;
import com.uit.entity.Book;
import com.uit.entity.BookOrder;
import com.uit.entity.OrderDetail;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class OrderService {
    OrderDao orderDao;
    
    public OrderService(){
         orderDao = new OrderDao();
    }
    
    public void addBookorder(BookOrder bookOrder){
        orderDao.addBookorder(bookOrder);
    }
    public void addOrder(BookOrder bookOrder, Book book, long quantity, double subtotal){
        orderDao.addOder(bookOrder, book, quantity, subtotal);
    }
    
    public List<BookOrder> listOrderforspecificCustomer(long id){
        return orderDao.listOrderforspecificUser(id);
    }
    
    public List<OrderDetail> listDetail(long id){
        return orderDao.listDetail(id);
    }
    
    public List<BookOrder> listOrder(){
        return orderDao.listOrder();
    }

    public void deleteOrder(long orderId, long bookId){
        orderDao.deleteOrder(orderId, bookId);
    }
    
    public void updateStatus(long orderId){
        orderDao.updateStatus(orderId);
    }
    
    public List<BookOrder> findOrder(String id){
        return findOrder(id);
    }
}
