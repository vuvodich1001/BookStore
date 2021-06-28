/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vunguyen
 */
public class StatisticController {
    private JButton btnStatistic;
    private JMonthChooser month;
    private JYearChooser year;

    public StatisticController(JButton btnStatistic, JMonthChooser month, JYearChooser year) {
        this.btnStatistic = btnStatistic;
        this.month = month;
        this.year = year;
        btnStatistic.setBackground(Color.white);
        btnStatistic.setFocusable(false);
    }
    
    private static Connection getConnection(){
        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String username = "DOAN_NEW";
        String password = "311001";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                return DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void actions(){
        btnStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Connection con = getConnection();
                    HashMap hashMap = new HashMap();
                    hashMap.put("mainYear", Integer.valueOf(year.getYear()));
                    hashMap.put("mainMonth", Integer.valueOf(month.getMonth()) + 1);
                    String report = "C:\\Users\\vungu\\OneDrive\\Documents\\NetBeansProjects\\Hibernate\\src\\com\\uit\\report\\Customer_Money_Table.jrxml";
                    JasperReport jr = JasperCompileManager.compileReport(report);
                    JasperPrint jp = JasperFillManager.fillReport(jr, hashMap, con);
                    JasperViewer.viewReport(jp, false);
                    con.close();
                } catch (Exception e) {
                }
            }
        });
    }
    
}