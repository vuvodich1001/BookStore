/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vunguyen
 */
public class JDBCConnection {
    public static Connection getJDBCConnection(){
        try {
             return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "DOAN_NEW", "311001");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
