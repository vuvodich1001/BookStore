/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.view.ChangePasswordFrame;
import com.uit.view.LoginFrame;
import java.awt.Color;
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
    private JLabel lblRegisterdate;
    private JButton btnChangePassword;

    public ProfileController(JLabel lblUsername, JLabel lblPassword, JLabel lblCity, JLabel lblCountry, JLabel lblZipcode, JLabel lblPhone, JLabel lblEmail, JLabel lblRegisterdate, JButton btnChangePassword) {
        this.lblUsername = lblUsername;
        this.lblPassword = lblPassword;
        this.lblCity = lblCity;
        this.lblCountry = lblCountry;
        this.lblZipcode = lblZipcode;
        this.lblPhone = lblPhone;
        this.lblEmail = lblEmail;
        this.lblRegisterdate = lblRegisterdate;
        this.btnChangePassword = btnChangePassword;
    }

    public void showProfile() {
        lblUsername.setText(LoginFrame.customer.getFullName());
        lblPassword.setText(LoginFrame.customer.getPassword());
        lblRegisterdate.setText(String.valueOf(LoginFrame.customer.getRegisterDate()));
        lblUsername.setBorder(BorderFactory.createLineBorder(Color.decode("#2980b9")));
        lblPassword.setBorder(BorderFactory.createLineBorder(Color.decode("#2980b9")));
        lblRegisterdate.setBorder(BorderFactory.createLineBorder(Color.decode("#2980b9")));
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
