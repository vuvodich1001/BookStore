/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.view.ChangePasswordFrame;
import com.uit.view.LoginFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author vunguyen
 */
public class ProfileController {

    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblCity;
    private JLabel lblCountry;
    private JLabel lblZipcode;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JLabel lblAddress;
    private JLabel lblRegisterdate;
    private JButton btnChangePassword;

    public ProfileController(JLabel lblUsername, JLabel lblPassword, JLabel lblCity, JLabel lblAddress, JLabel lblCountry, JLabel lblZipcode, JLabel lblPhone, JLabel lblEmail, JLabel lblRegisterdate, JButton btnChangePassword) {
        this.lblUsername = lblUsername;
        this.lblPassword = lblPassword;
        this.lblCity = lblCity;
        this.lblAddress = lblAddress;
        this.lblCountry = lblCountry;
        this.lblZipcode = lblZipcode;
        this.lblPhone = lblPhone;
        this.lblEmail = lblEmail;
        this.lblRegisterdate = lblRegisterdate;
        this.btnChangePassword = btnChangePassword;
    }

    public void showProfile() {
        //set text
        lblUsername.setText(LoginFrame.customer.getFullName());
        lblUsername.setFont(new Font("Serif", Font.BOLD, 15));
        
        lblEmail.setText(LoginFrame.customer.getEmail());
        lblEmail.setFont(new Font("Serif", Font.BOLD, 15));
        
        lblPassword.setText("*********");
        lblPassword.setFont(new Font("Serif", Font.BOLD, 15));
        
        lblAddress.setText(LoginFrame.customer.getAddress());
        lblAddress.setFont(new Font("Serif", Font.BOLD, 15));
        
        lblCity.setText(LoginFrame.customer.getCity());
        lblCity.setFont(new Font("Serif", Font.BOLD, 15));
        
        lblCountry.setText(LoginFrame.customer.getCountry());
        lblCountry.setFont(new Font("Serif", Font.BOLD, 15));
        
        lblPhone.setText(LoginFrame.customer.getPhone());
        lblPhone.setFont(new Font("Serif", Font.BOLD, 15));
        
        lblZipcode.setText(LoginFrame.customer.getZipcode());
        lblZipcode.setFont(new Font("Serif", Font.BOLD, 15));

        lblRegisterdate.setText(String.valueOf(LoginFrame.customer.getRegisterDate()));
        lblRegisterdate.setFont(new Font("Serif", Font.BOLD, 15));
        
        //set border
        lblUsername.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblEmail.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblPassword.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblAddress.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblRegisterdate.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblCity.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblCountry.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblPhone.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        lblZipcode.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        btnChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ChangePasswordFrame c = new ChangePasswordFrame();
                c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                c.pack();
                c.setLocationRelativeTo(null);
                c.setVisible(true);
            }
        });
    }
}
