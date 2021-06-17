/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Supplier;
import com.uit.service.SupplierService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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
public class SupplierController {
    JButton btnSupplier;
    JButton btnAddall;
    JButton btnSubmit;
    JTextField txtName;
    JTextField txtAddress;
    JTextField txtPhone;
    JDialog addupdateSupplier;
    JTextField txtSearchall;
    JTable table;
    JPanel panel;
    SupplierService supplierService;
    DefaultTableModel defaultTableModel;
    JPopupMenu menuSupplier;
    JMenuItem deleteSupplier;
    JMenuItem modifySupplier;

    public SupplierController(JButton btnSupplier, JButton btnAddall, JButton btnSubmit, JTextField txtName, JTextField txtAddress, JTextField txtPhone, JDialog addupdateSupplier, JTextField txtSearchall, JTable table, JPanel panel) {
        this.btnSupplier = btnSupplier;
        this.btnAddall = btnAddall;
        this.btnSubmit = btnSubmit;
        this.txtName = txtName;
        this.txtAddress = txtAddress;
        this.txtPhone = txtPhone;
        this.addupdateSupplier = addupdateSupplier;
        this.txtSearchall = txtSearchall;
        this.table = table;
        this.panel = panel;
        supplierService = new SupplierService();
        menuSupplier = new JPopupMenu();
        deleteSupplier = new JMenuItem();
        modifySupplier = new JMenuItem();
    }
    
    
    
    public void listSupplier(){
        initMenuItem(menuSupplier, deleteSupplier, modifySupplier);
        table.setComponentPopupMenu(menuSupplier);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.yellow);
        header.setForeground(Color.blue);
        header.setFont(new Font("Tahome", Font.BOLD, 13));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("SupplierId");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Address");
        defaultTableModel.addColumn("Phone");
       
        table.setRowHeight(30);
        setTabledata(supplierService.getAllsupplier());
    }
    
     private void setTabledata(List<Supplier> list) {
        defaultTableModel.setRowCount(0);
        for (Supplier s : list) {
            defaultTableModel.addRow(new Object[]{s.getSupplierId(), s.getName(), s.getAddress(), s.getPhone()});
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

    public void actionAdd(){
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtName.getText().equals("") || txtAddress.getText().equals("") || txtPhone.getText().equals("")){
                    JOptionPane.showMessageDialog(panel, "Input not enough information");
                }
                else{
                    Supplier supplier = new Supplier();
                    supplier.setName(txtName.getText());
                    supplier.setAddress(txtAddress.getText());
                    supplier.setPhone(txtPhone.getText());
                    supplierService.addSupplier(supplier);
                    addupdateSupplier.setVisible(false);
                    JOptionPane.showMessageDialog(panel, "Insert successfully!");
                    setTabledata(supplierService.getAllsupplier());
                }
            }
        });
    }
    public void actions() {
        btnSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listSupplier();
                for (ActionListener al : btnAddall.getActionListeners()) {
                    btnAddall.removeActionListener(al);
                }
                btnAddall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        addupdateSupplier.pack();
                        addupdateSupplier.setLocationRelativeTo(null);
                        addupdateSupplier.setVisible(true);
                        actionAdd();
                    }
                });

                for (KeyListener kl : txtSearchall.getKeyListeners()){
                    txtSearchall.removeKeyListener(kl);
                }
//                txtSearchall.addKeyListener(new KeyAdapter() {
//                    @Override
//                    public void keyReleased(KeyEvent ke) {
//                        setTabledata(customerService.findUser(txtSearchall.getText()));
//                    }
//                });
            }
        });
        deleteSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(panel, "You need to select row first!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(panel, "are you sure to delete this row!", "Message", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        int supplierId = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
                        supplierService.deleteSupplier(supplierId);
                        setTabledata(supplierService.getAllsupplier());
                    }
                }
            }
        });

        modifySupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("oke");
            }
        });
    }


}
