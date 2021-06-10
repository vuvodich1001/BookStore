/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Category;
import com.uit.service.CategoryService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class CategoryController {
    private JTextField txtName, txtSeachall;
    private JTable table;
    private JButton btnAddall;
    private JButton btnSubmitCategory;
    private JButton btnCategory;
    private JPopupMenu menuCategory;
    private JMenuItem modifyCategory;
    private JMenuItem deleteCategory;
    private DefaultTableModel defaultTableModel;
    private Category category;
    private CategoryService categoryService;
    private JPanel panel;
    private JDialog addupdateCategory;

    public CategoryController(){
        
    }
    public CategoryController(JTextField txtName, JTextField txtSearchall, JTable table, JButton btnAddall,
            JButton btnSubmitCategoy, JButton btnCategory, JPanel panel, JDialog addupdateCategory) {
        this.txtName = txtName;
        this.txtSeachall = txtSearchall;
        this.table = table;
        this.btnAddall = btnAddall;
        this.btnSubmitCategory = btnSubmitCategoy;
        this.btnCategory = btnCategory;
        this.panel = panel;
        this.addupdateCategory = addupdateCategory;
        menuCategory = new JPopupMenu();
        deleteCategory = new JMenuItem();
        modifyCategory = new JMenuItem();
        category = new Category();
        categoryService = new CategoryService();
    }
    public void listCategory(){
        initMenuItem(menuCategory, deleteCategory, modifyCategory);
        table.setComponentPopupMenu(menuCategory);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.yellow);
        header.setForeground(Color.blue);
        header.setFont(new Font("Tahome", Font.BOLD, 13));
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
         defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }  
        };
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("Category_id");
        defaultTableModel.addColumn("Name");
        table.setRowHeight(30);
        setTabledata(categoryService.getAllcategory());
    }
    
    public void setTabledata(List<Category> list){
        defaultTableModel.setRowCount(0);
        for(Category c : list){
            defaultTableModel.addRow(new Object[]{c.getCategoryId(), c.getName()});
        }
    }
    
    public void initMenuItem(JPopupMenu menu, JMenuItem delete, JMenuItem modify){
        delete.setIcon(getIcon("/com/uit/image/icons8_delete_96px.png", 20, 20));
        delete.setText("delete");
        modify.setIcon(getIcon("/com/uit/image/icons8_edit_file_128px.png", 20, 20));
        modify.setText("modify");
        menu.add(delete);
        menu.add(modify); 
    }
    
     public ImageIcon getIcon(String url, int w, int h){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }
    
    public void setNull(){
        txtName.setText("");
    }
    
    public void actionAdd(){
        setNull();
        for (ActionListener al : btnSubmitCategory.getActionListeners()) {
            btnSubmitCategory.removeActionListener(al);
        }
        btnSubmitCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtName.getText().equals("")){
                    JOptionPane.showMessageDialog(panel, "Input not enough information!");
                }
                else{
                    category.setName(txtName.getText());
                    categoryService.addCategory(category);
                    addupdateCategory.dispose();
                    JOptionPane.showMessageDialog(panel, "Insert successfully!");
                    setTabledata(categoryService.getAllcategory());
                }
            }
        });
        
    }
    
    public void actionModify(){
        for (ActionListener al : btnSubmitCategory.getActionListeners()) {
                   btnSubmitCategory.removeActionListener(al);
        }
        btnSubmitCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            if(txtName.getText().equals("")){
                JOptionPane.showMessageDialog(panel, "Input not enough information");
            }
            else{
                category.setName(txtName.getText());
                categoryService.editCategory(category);
                addupdateCategory.dispose();
                JOptionPane.showMessageDialog(panel, "update successfully!");
                setTabledata(categoryService.getAllcategory());
            }
            }
        });
        
    }
    public void actions(){
        btnCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listCategory();
                for (ActionListener al : btnAddall.getActionListeners()) {
                 btnAddall.removeActionListener(al);
                }
                
                btnAddall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                         addupdateCategory.pack();
                         addupdateCategory.setLocationRelativeTo(null);
                         addupdateCategory.setVisible(true);
                         actionAdd();
                    }
                });
                
                for (KeyListener kl : txtSeachall.getKeyListeners()){
                    txtSeachall.removeKeyListener(kl);
                }
                txtSeachall.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent ke) {
                        setTabledata(categoryService.findCategory(txtSeachall.getText()));
                    }
                });
            }
        });
        
        deleteCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(panel, "you need choose Category first!");
                }
                else{
                    int confirm = JOptionPane.showConfirmDialog(panel, "Do you want to delete this user!", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        int id = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
                        categoryService.deleteCategory(id);
                        setTabledata(categoryService.getAllcategory());
                    }
                }
            }
        });
        
        modifyCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 int row = table.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(panel, "you need choose Category first!");
            }
            else{
                category.setCategoryId((Long) table.getValueAt(row, 0));
                txtName.setText(String.valueOf(table.getValueAt(row, 1)));
                addupdateCategory.pack();
                addupdateCategory.setLocationRelativeTo(null);
                addupdateCategory.setVisible(true);
                actionModify();
            }
            }
        });
    }
}
