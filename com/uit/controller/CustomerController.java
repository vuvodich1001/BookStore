/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Customer;
import com.uit.service.CustomerService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author vunguyen
 */
public class CustomerController {

    JTable table;
    JPanel panel;
    JButton btnCustomer;
    JButton btnAddall;
    JTextField txtSearchall;
    DefaultTableModel defaultTableModel;
    CustomerService customerService;
    JPopupMenu menuCustomer;
    JMenuItem deleteCustomer;
    JMenuItem modifyCustomer;

    public CustomerController() {

    }

    public CustomerController(JTable table, JButton btnCustomer, JButton btnAddall, JTextField txtSearhall, JPanel panel) {
        this.table = table;
        this.btnCustomer = btnCustomer;
        this.btnAddall = btnAddall;
        this.txtSearchall = txtSearhall;
        this.panel = panel;
        customerService = new CustomerService();
        menuCustomer = new JPopupMenu();
        deleteCustomer = new JMenuItem();
        modifyCustomer = new JMenuItem();
    }

    public void listCustomer() {
        initMenuItem(menuCustomer, deleteCustomer, modifyCustomer);
        table.setComponentPopupMenu(menuCustomer);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.decode("#686de0"));
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
        defaultTableModel.addColumn("CustomerId");
        defaultTableModel.addColumn("FullName");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Address");
        defaultTableModel.addColumn("City");
        defaultTableModel.addColumn("Country");
        defaultTableModel.addColumn("zipcode");
        defaultTableModel.addColumn("Password");
        table.setRowHeight(30);
        setTabledata(customerService.getAllcustomer());
    }

    private void setTabledata(List<Customer> list) {
        defaultTableModel.setRowCount(0);
        for (Customer m : list) {
            defaultTableModel.addRow(new Object[]{m.getCustomerId(), m.getFullName(), m.getEmail(), m.getAddress(),
                m.getCity(), m.getCountry(), m.getZipcode(), m.getPassword()});
        }
    }

    public void initMenuItem(JPopupMenu menu, JMenuItem delete, JMenuItem modify) {
        delete.setIcon(getIcon("/com/uit/image/icons8_delete_96px.png", 20, 20));
        delete.setText("delete");
        modify.setIcon(getIcon("/com/uit/image/icons8_edit_file_128px.png", 20, 20));
        modify.setText("modify");
        menu.add(delete);
        menu.add(modify);
    }

    public ImageIcon getIcon(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public void actions() {
        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listCustomer();
                for (ActionListener al : btnAddall.getActionListeners()) {
                    btnAddall.removeActionListener(al);
                }
                btnAddall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                    }
                });

                txtSearchall.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent ke) {
                        setTabledata(customerService.findUser(txtSearchall.getText()));
                    }
                });
            }
        });
        deleteCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(panel, "You need to select row first!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(panel, "are you sure to delete this row!", "Message", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        int customerId = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
                        for (Customer c : customerService.getAllcustomer()) {
                            if (c.getCustomerId() == customerId) {
                                customerService.deleteCustomer(c);
                                setTabledata(customerService.getAllcustomer());
                            }
                        }
                    }
                }
            }
        });

        modifyCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("oke");
            }
        });
    }
}
