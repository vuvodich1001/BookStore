/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.service.OrderService;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vunguyen
 */
public class OrderHistoryController {
    private JTable tblOrder;
    private JTable tblOrderDetail;
    private OrderService orderService;
    private JPopupMenu menu;
    private JMenuItem detail;
    private DefaultTableModel defaulTatableModel;
    
    public OrderHistoryController(JTable tblOrder, JTable tblOrderDeatail){
        this.tblOrder = tblOrder;
        this.tblOrderDetail = tblOrderDeatail;
        orderService = new OrderService();
        menu = new JPopupMenu();
        detail = new JMenuItem();
    }
    
    public void listOrder(){
        
    }
}
