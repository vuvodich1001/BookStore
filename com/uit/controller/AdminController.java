/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author vunguyen
 */
public class AdminController {
    JButton btnUser;
    JButton btnCategory;
    JButton btnBook;
    JButton btnCustomer;
    JButton btnAddall;
    JButton btnOrder;
    JButton btnSupplier;
    JButton btnInventory;

    public AdminController() {
       
    }

    public AdminController(JButton btnUser, JButton btnCategory, JButton btnBook, JButton btnCustomer, JButton btnAddall, JButton btnOrder,
            JButton btnSupplier, JButton btnInventory) {
        this.btnUser = btnUser;
        this.btnCategory = btnCategory;
        this.btnBook = btnBook;
        this.btnCustomer = btnCustomer;
        this.btnAddall  = btnAddall;
        this.btnOrder = btnOrder;
        this.btnSupplier = btnSupplier;
        this.btnInventory = btnInventory;
    }
    
    
    public void setIconforButton(){
        btnBook.setIcon(getIcon("/com/uit/image/icons8_book_80px.png", 20, 20));
        btnCustomer.setIcon(getIcon("/com/uit/image/icons8_customer_128px.png", 20, 20));
        btnCategory.setIcon(getIcon("/com/uit/image/Category.png", 20, 20));
        btnUser.setIcon(getIcon("/com/uit/image/icons8_user_80px.png", 20, 20));
        btnAddall.setIcon(getIcon("/com/uit/image/addIcon.png", 20, 20));
        btnOrder.setIcon(getIcon("/com/uit/image/icons8_order_history_60px_1.png", 20, 20));
        btnSupplier.setIcon(getIcon("/com/uit/image/icons8_supplier_60px_1.png", 20, 20));
        btnInventory.setIcon(getIcon("/com/uit/image/icons8_warehouse_60px.png", 20, 20));

//        btnBook.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
//        btnCustomer.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
//        btnUser.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
//        btnCategory.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
//        btnOrder.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
        btnBook.setFocusable(false);
        btnCustomer.setFocusable(false);
        btnCategory.setFocusable(false);
        btnUser.setFocusable(false);
        btnOrder.setFocusable(false);
        btnInventory.setFocusable(false);
        btnSupplier.setFocusable(false);
    }
    
  
    
    
    public void actions(){
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeButtonColor(btnUser, btnBook, btnCategory, btnCustomer, btnOrder, btnSupplier, btnInventory);
            }
        });
        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeButtonColor(btnBook, btnUser, btnCategory, btnCustomer, btnOrder, btnSupplier, btnInventory);
            }
        });
        btnCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeButtonColor(btnCategory, btnUser, btnBook, btnCustomer, btnOrder, btnSupplier, btnInventory);
            
            }
        });
        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeButtonColor(btnCustomer, btnBook, btnCategory, btnUser, btnOrder, btnSupplier, btnInventory);
            }
        });
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeButtonColor(btnOrder, btnBook, btnCategory, btnCustomer, btnUser, btnSupplier, btnInventory);
            }
        });
        
        btnSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeButtonColor(btnSupplier, btnBook, btnCategory, btnCustomer, btnOrder, btnUser, btnInventory);        
            }
        });
        
        btnInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                changeButtonColor(btnInventory, btnBook, btnCategory, btnCustomer, btnOrder, btnUser, btnSupplier);        
            }
        });
        
    }
    
    public void changeButtonColor(JButton b1, JButton b2, JButton b3, JButton b4, JButton b5, JButton b6, JButton b7){
         b1.setBackground(Color.green);
         b2.setBackground(Color.white);
         b3.setBackground(Color.white);
         b4.setBackground(Color.white);
         b5.setBackground(Color.white);
         b6.setBackground(Color.white);
         b7.setBackground(Color.white);
    }
    public ImageIcon getIcon(String url, int w, int h){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }
    
    
}
