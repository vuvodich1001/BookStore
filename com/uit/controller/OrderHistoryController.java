/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.BookOrder;
import com.uit.entity.Customer;
import com.uit.entity.OrderDetail;
import com.uit.service.OrderService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    private DefaultTableModel defaultTableModel1;
    private DefaultTableModel defaultTableModel2;
    private Customer customer;
    
    public OrderHistoryController(JTable tblOrder, JTable tblOrderDetail, Customer customer){
        this.tblOrder = tblOrder;
        this.tblOrderDetail = tblOrderDetail;
        this.customer = customer;
        orderService = new OrderService();
        menu = new JPopupMenu();
        detail = new JMenuItem();
        detail.setText("view detail");
    }
    
    public void listOrder(){
        menu.add(detail);
        tblOrder.setComponentPopupMenu(menu);
        defaultTableModel1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tblOrder.setModel(defaultTableModel1);
        defaultTableModel1.addColumn("OrderID");
        defaultTableModel1.addColumn("ShippingAddress");
        defaultTableModel1.addColumn("RecipentName");
        defaultTableModel1.addColumn("RecipentPhone");
        defaultTableModel1.addColumn("PaymentMethod");
        defaultTableModel1.addColumn("Total");
        tblOrder.setRowHeight(30);
        setTabledata(orderService.listOrderforspecificCustomer(customer.getCustomerId()));
    }
    
    private void setTabledata(List<BookOrder> list){
        defaultTableModel1.setRowCount(0);
        for(BookOrder b : list){
            defaultTableModel1.addRow(new Object[]{b.getOrderId(), b.getShippingAddress(), b.getRecipentName(), b.getRecipentPhone(),
            b.getPaymentMethod(), b.getTotal()});
        }
    }
    
    private void setTabledetail(List<OrderDetail> list){
        defaultTableModel2.setRowCount(0);
        for(OrderDetail o : list){
            defaultTableModel2.addRow(new Object[]{o.getBookOrder().getOrderId(), o.getBook().getBookId(), o.getBook().getTitle(), o.getQuantity(), o.getSubtotal()});
        }
    }
    public void action(){
        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = tblOrder.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(menu, "you need choose order first!");
                }
                else{
                    defaultTableModel2 = new DefaultTableModel(){
                        @Override
                        public boolean isCellEditable(int i, int i1) {
                            return false;
                        }  
                    };
                    tblOrderDetail.setModel(defaultTableModel2);
                    defaultTableModel2.addColumn("OrderId");
                    defaultTableModel2.addColumn("BookId");
                    defaultTableModel2.addColumn("Title");
                    defaultTableModel2.addColumn("Quantity");
                    defaultTableModel2.addColumn("Total");
                    setTabledetail(orderService.listDetail((long)tblOrder.getValueAt(row, 0)));
                }
            }
        });
    }
    
}
