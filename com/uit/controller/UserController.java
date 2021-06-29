/*
 * To change panel license header, choose License Headers in Project Properties.
 * To change panel template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;
import com.uit.entity.Usr;
import com.uit.service.UserService;
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
import javax.swing.JPasswordField;
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
public class UserController{

    private JTextField txtFullName, txtEmail, txtSearchall;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmpassword;
    private JTable table;
    private JButton btnAddall;
    private JButton btnUser;
    private JButton btnAdduser;
    private Usr user;
    private UserService userService;
    private JPopupMenu menuUser;
    private JMenuItem deleteUser;
    private JMenuItem modifyUser;
    private JDialog addnewUser;
    private DefaultTableModel defaultTableModel;
    private JPanel panel;
    
    public UserController() {
    
    }


    public UserController(JTextField txtFullName, JTextField txtEmail, JTextField txtSearchall, JPasswordField txtPassword, 
            JPasswordField txtConfirmpassword, JButton btnAddall, JButton btnUser, JButton btnAdduser, JTable table, JDialog addnewUser, JPanel panel) {
        this.txtFullName = txtFullName;
        this.txtEmail = txtEmail;
        this.txtSearchall = txtSearchall;
        this.txtPassword = txtPassword;
        this.txtConfirmpassword = txtConfirmpassword;
        this.btnAddall = btnAddall;
        this.btnUser = btnUser;
        this.btnAdduser = btnAdduser;
        this.table = table;
        this.addnewUser = addnewUser;
        this.panel =panel;
        menuUser = new JPopupMenu();
        deleteUser = new JMenuItem();
        modifyUser = new JMenuItem();
        user = new Usr();
        userService = new UserService();
    }
      

    
    public void listUser(){
        initMenuItem(menuUser, deleteUser, modifyUser);
        table.setComponentPopupMenu(menuUser);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.decode("#686de0"));
        header.setForeground(Color.white);
        header.setFont(new Font("Tahome", Font.BOLD, 14));
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("UserID");
        defaultTableModel.addColumn("Fullname");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Password");
        table.setRowHeight(30);
        setTabledata(userService.getAlluser());  
    }
    
     public void setTabledata(List<Usr> list){
        defaultTableModel.setRowCount(0);
        for(Usr user : list){
            defaultTableModel.addRow(new Object[]{user.getUsrId(), user.getFullName(), user.getEmail(), user.getPassword()});
        }
    }
   
    public void setNull(){
        txtConfirmpassword.setText("");
        txtFullName.setText("");
        txtPassword.setText("");
        txtEmail.setText("");
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
     
    public void actionAdd(){
         setNull();
         for (ActionListener al : btnAdduser.getActionListeners()) {
                   btnAdduser.removeActionListener(al);
                }
         btnAdduser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               if(txtEmail.getText().equals("") || txtFullName.getText().equals("") || txtPassword.getPassword().equals("")){
                    JOptionPane.showMessageDialog(panel, "Input not enough information");
                }
                else if(String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtConfirmpassword.getPassword())) == false){
                    JOptionPane.showMessageDialog(panel, "Confirm password not correct");
                }
                else if(userService.checkEmail(txtEmail.getText())){
                    JOptionPane.showMessageDialog(panel, "Email already existed!");
                }
                else{
                    user.setFullName(txtFullName.getText());
                    user.setEmail(txtEmail.getText());
                    user.setPassword(String.valueOf(txtPassword.getPassword()));
                    userService.addUser(user);
                    addnewUser.dispose();
                    JOptionPane.showMessageDialog(panel, "Insert Successfully!");
                    setTabledata(userService.getAlluser());
                    
                }
            }
        });
    }
    public void actionModify(){
         for (ActionListener al : btnAdduser.getActionListeners()) {
                 btnAdduser.removeActionListener(al);
         }
        btnAdduser.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                  if(txtEmail.getText().equals("") || txtFullName.getText().equals("") || txtPassword.getPassword().equals("")){
                    JOptionPane.showMessageDialog(panel, "Input not enough information");
                }
                else if(String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtConfirmpassword.getPassword())) == false){
                    JOptionPane.showMessageDialog(panel, "Confirm password not correct");
                }
                else{ 
                    user.setFullName(txtFullName.getText());
                    user.setEmail(txtEmail.getText());
                    user.setPassword(String.valueOf(txtPassword.getPassword()));
                    userService.editUser(user);
                    addnewUser.dispose();
                    JOptionPane.showMessageDialog(panel, "update Successfully!");
                    setTabledata(userService.getAlluser());
                }
             }
         });
    }
    public void actions(){
       
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUser.setBackground(Color.green);
                listUser();
                for (ActionListener al : btnAddall.getActionListeners()) {
                 btnAddall.removeActionListener(al);
                }
                
                btnAddall.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    addnewUser.pack();
                    addnewUser.setLocationRelativeTo(null);
                    addnewUser.setVisible(true);
                    actionAdd();
                }
                 });
                
                for(KeyListener kl : txtSearchall.getKeyListeners()){
                    txtSearchall.removeKeyListener(kl);
                }
                
                txtSearchall.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent ke) {
                        setTabledata(userService.findUser(txtSearchall.getText()));
                    }
                });
            }
        });
        
        deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(panel, "you need choose user first!");
                }
                else{
                    int confirm = JOptionPane.showConfirmDialog(panel, "Do you want to delete panel user?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        int id = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
                        userService.deleteUser(id);
                        setTabledata(userService.getAlluser());
                    }
                }
            }
        });
        
        modifyUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(panel, "you nead choose user first!");
                }
                else{
                    user.setUsrId((Long)table.getValueAt(row, 0));
                    txtEmail.setText(String.valueOf(table.getValueAt(row, 2)));
                    txtFullName.setText(String.valueOf(table.getValueAt(row, 1)));
                    txtPassword.setText(String.valueOf(table.getValueAt(row, 3)));
                    txtConfirmpassword.setText(String.valueOf(table.getValueAt(row, 3)));
                    addnewUser.pack();
                    addnewUser.setLocationRelativeTo(null);
                    addnewUser.setVisible(true);
                    actionModify();
                }
            }
        });
       
    }
    
}
