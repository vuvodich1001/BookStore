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

    public AdminController() {
       
    }

    public AdminController(JButton btnUser, JButton btnCategory, JButton btnBook, JButton btnCustomer, JButton btnAddall) {
        this.btnUser = btnUser;
        this.btnCategory = btnCategory;
        this.btnBook = btnBook;
        this.btnCustomer = btnCustomer;
        this.btnAddall  = btnAddall;
      
    }
    
    
    public void setIconforButton(){
        btnBook.setIcon(getIcon("/com/uit/image/icons8_book_80px.png", 20, 20));
        btnCustomer.setIcon(getIcon("/com/uit/image/icons8_customer_128px.png", 20, 20));
        btnCategory.setIcon(getIcon("/com/uit/image/Category.png", 20, 20));
        btnUser.setIcon(getIcon("/com/uit/image/icons8_user_80px.png", 20, 20));
        btnAddall.setIcon(getIcon("/com/uit/image/c.png", 20, 20));
        btnBook.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
        btnCustomer.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
        btnUser.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
        btnCategory.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 2));
        btnBook.setFocusable(false);
        btnCustomer.setFocusable(false);
        btnCategory.setFocusable(false);
        btnUser.setFocusable(false);
    }
    
  
    
    
    public void actions(){
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUser.setBackground(Color.green);
                btnBook.setBackground(Color.white);
                btnCategory.setBackground(Color.white);
                btnCustomer.setBackground(Color.white);
            }
        });
          btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUser.setBackground(Color.white);
                btnBook.setBackground(Color.green);
                btnCategory.setBackground(Color.white);
                btnCustomer.setBackground(Color.white);
            }
        });
            btnCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUser.setBackground(Color.white);
                btnBook.setBackground(Color.white);
                btnCategory.setBackground(Color.green);
                btnCustomer.setBackground(Color.white);
            }
        });
              btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUser.setBackground(Color.white);
                btnBook.setBackground(Color.white);
                btnCategory.setBackground(Color.white);
                btnCustomer.setBackground(Color.green);
            }
        });
    }
     public ImageIcon getIcon(String url, int w, int h){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }
    
    
}
