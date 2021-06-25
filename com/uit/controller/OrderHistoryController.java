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
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author vunguyen
 */
public class OrderHistoryController {
    private JTable tblOrder;
    private JTable tblOrderDetail;
    private OrderService orderService;
    private JPopupMenu menu;
    private JPopupMenu menuDetail;
    private JMenuItem delete;
    private JMenuItem detail;
    private DefaultTableModel defaultTableModel1;
    private DefaultTableModel defaultTableModel2;
    private Customer customer;
    private String status;
    
    public OrderHistoryController(JTable tblOrder, JTable tblOrderDetail, Customer customer){
        this.tblOrder = tblOrder;
        this.tblOrderDetail = tblOrderDetail;
        this.customer = customer;
        orderService = new OrderService();
        menu = new JPopupMenu();
        menuDetail = new JPopupMenu();
        detail = new JMenuItem();
        detail.setText("view detail");
        detail.setIcon(getIcon("/com/uit/image/icons8_view_128px_9.png", 20, 20));
        delete = new JMenuItem();
        delete.setText("delete");
        delete.setIcon(getIcon("/com/uit/image/icons8_delete_96px.png", 20, 20));
    }
    
    public void listOrder(){
        menu.add(detail);
        tblOrder.setComponentPopupMenu(menu);
        //tblorder
        defaultTableModel1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tblOrder.setModel(defaultTableModel1);
        //tblOrderDetail
        defaultTableModel2 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tblOrderDetail.setModel(defaultTableModel2);
        
        JTableHeader header = tblOrder.getTableHeader();
        header.setBackground(Color.yellow);
        header.setForeground(Color.blue);
        header.setFont(new Font("Tahome", Font.BOLD, 13));
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        defaultTableModel1.addColumn("OrderID");
        defaultTableModel1.addColumn("ShippingAddress");
        defaultTableModel1.addColumn("RecipentName");
        defaultTableModel1.addColumn("RecipentPhone");
        defaultTableModel1.addColumn("PaymentMethod");
        defaultTableModel1.addColumn("Total");
        defaultTableModel1.addColumn("Status");
        tblOrder.setRowHeight(30);
        setTabledata(orderService.listOrderforspecificCustomer(customer.getCustomerId()));
    }
    
    private void setTabledata(List<BookOrder> list){
        defaultTableModel1.setRowCount(0);
        for(BookOrder b : list){
            defaultTableModel1.addRow(new Object[]{b.getOrderId(), b.getShippingAddress(), b.getRecipentName(), b.getRecipentPhone(),
            b.getPaymentMethod(), b.getTotal(), b.getStatus()});
        }
    }
    
    private void setTabledetail(List<OrderDetail> list){
        defaultTableModel2.setRowCount(0);
        for(OrderDetail o : list){
            defaultTableModel2.addRow(new Object[]{o.getBookOrder().getOrderId(), o.getBook().getBookId(), o.getBook().getTitle(), o.getQuantity(), o.getSubtotal()});
        }
    }
    
    public ImageIcon getIcon(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
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
                    status = String.valueOf(tblOrder.getValueAt(row, 6));
                    defaultTableModel2 = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                    };
                    menuDetail.add(delete);
                    tblOrderDetail.setComponentPopupMenu(menuDetail);
                    tblOrderDetail.setModel(defaultTableModel2);
                     JTableHeader header = tblOrderDetail.getTableHeader();
                    header.setBackground(Color.yellow);
                    header.setForeground(Color.blue);
                    header.setFont(new Font("Tahome", Font.BOLD, 13));
                    ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                    defaultTableModel2.addColumn("OrderId");
                    defaultTableModel2.addColumn("BookId");
                    defaultTableModel2.addColumn("Title");
                    defaultTableModel2.addColumn("Quantity");
                    defaultTableModel2.addColumn("Total");
                    setTabledetail(orderService.listDetail((long)tblOrder.getValueAt(row, 0)));
                }
            }
        });
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = tblOrderDetail.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(menu, "you need choose order first");
                }
                else if(status.equals("Completed")){
                    JOptionPane.showMessageDialog(menu, "Can't delete this order detail");
                }
                else{
                    int confirm = JOptionPane.showConfirmDialog(menu, "Do you want do delete this order detail", "Message", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        long orderId = (long)tblOrderDetail.getValueAt(row, 0);
                        long bookId = (long)tblOrderDetail.getValueAt(row, 1);
                        orderService.deleteOrder(orderId, bookId);
                        setTabledetail(orderService.listDetail(orderId));
                        setTabledata(orderService.listOrderforspecificCustomer(customer.getCustomerId()));
                    }
                }
            }
        });
    }
    
}
