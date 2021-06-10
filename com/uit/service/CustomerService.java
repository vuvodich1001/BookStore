/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.CustomerDao;
import com.uit.entity.Customer;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class CustomerService {
    CustomerDao customerDao;
    
    public CustomerService(){
        customerDao = new CustomerDao();
    }
    
    public void add(Customer customer){
        customerDao.addCustomer(customer);
    }
    
    public boolean check(String username, String password){
        return customerDao.check(username, password);
    }
    
    public List<Customer> getAllcustomer(){
        return customerDao.getAllcustomer();
    }
    
    public void deleteCustomer(Customer customer){
        customerDao.deleteCustomer(customer);
    }
    
    public Customer returnCustomer(String username, String password){
        return customerDao.returnCustomer(username, password);
    }
    
    public List<Customer>  findUser(String username){
        return customerDao.findUser(username);
    }
}
