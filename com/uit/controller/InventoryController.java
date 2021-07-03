/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.InventoryTracking;
import com.uit.entity.Supplier;
import com.uit.service.InventoryService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author vunguyen
 */
public class InventoryController {
    JButton btnInventory;
    JButton btnAddall;
    JTextField btnSearchall;
    JTable table;
    JPanel panel;
    DefaultTableModel defaultTableModel;
    InventoryService inventoryService;

    public InventoryController(JButton btnInventory, JButton btnAddall, JTextField btnSearchall, JTable table, JPanel panel) {
        this.btnInventory = btnInventory;
        this.btnAddall = btnAddall;
        this.btnSearchall = btnSearchall;
        this.table = table;
        this.panel = panel;
        inventoryService = new InventoryService();
    }
    
    
    public void listSupplier(){
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.decode("#2c3e50"));
        header.setForeground(Color.white);
        header.setFont(new Font("Tahome", Font.BOLD, 14));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("TrackingId");
        defaultTableModel.addColumn("BookId");
        defaultTableModel.addColumn("SupplierId");
        defaultTableModel.addColumn("Title");
        defaultTableModel.addColumn("Supplier");
        defaultTableModel.addColumn("Quantity");
        defaultTableModel.addColumn("Subtotal");
        defaultTableModel.addColumn("ReceiptDate");

       
        table.setRowHeight(30);
        setTabledata(inventoryService.getAllinventory());
    }
    
     private void setTabledata(List<InventoryTracking> list) {
        defaultTableModel.setRowCount(0);
        for (InventoryTracking i : list) {
            defaultTableModel.addRow(new Object[]{i.getTrackingId(), i.getBook().getBookId(),i.getSupplier().getSupplierId(), i.getBook().getTitle(),
            i.getSupplier().getName(), i.getQuantity(), i.getSubtotal(), i.getReceiptDate()});
        }
     }
     
    public void actions() {
        btnInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listSupplier();
                for (ActionListener al : btnAddall.getActionListeners()) {
                    btnAddall.removeActionListener(al);
                }
                btnAddall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                       
                    }
                });

//                txtSearchall.addKeyListener(new KeyAdapter() {
//                    @Override
//                    public void keyReleased(KeyEvent ke) {
//                        setTabledata(customerService.findUser(txtSearchall.getText()));
//                    }
//                });
            }
        });
    }


}
