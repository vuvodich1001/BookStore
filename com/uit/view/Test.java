
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.view;

import com.uit.controller.AdminController;
import com.uit.controller.BookController;
import com.uit.controller.BuyOrderController;
import com.uit.controller.CategoryController;
import com.uit.controller.CustomerController;
import com.uit.controller.OrderController;
import com.uit.controller.OrderHistoryController;
import com.uit.controller.UserController;
import com.uit.entity.Book;
import com.uit.entity.Category;
import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author vunguyen
 */
public class Test extends javax.swing.JFrame {
    
    protected OrderController orderController; 
    protected BuyOrderController buyOrderController;
    protected AdminController adminController;
    protected UserController userController;
    protected CategoryController categoryController;
    protected BookController bookController;
    protected CustomerController customerController;
    protected CustomerController profileController;
    protected OrderHistoryController orderHistoryController;
    protected BookController dashBoardController;
    public static Map<Book, Integer> list;

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
        list = new HashMap<>();
        //User
      
         
         //order
         orderController = new OrderController(viewOrder, bookDetail, txtSearchBook, lblTitle, lblAuthor,
         lblPublishdate, lblImageorder, lblPrice, btnPlus, btnMinus, btnBuy, list, lblQuantity, lblNotice);
         orderController.actions();
         orderController.setView();
         orderController.setIconforShipingCart(lblCart);
         
         
         //buyorder
         buyOrderController = new BuyOrderController(lblSum, btnBuyproduct, btnClearOrder, displayPanel, list);
         buyOrderController.action();
         
         //OrderHistory
         orderHistoryController = new OrderHistoryController(tblOrder, tblOrderDetail, LoginFrame.customer);
         orderHistoryController.listOrder();
         orderHistoryController.action();
         
         //admin
         adminController = new AdminController(btnUser, btnCategory, btnBook, btnCustomer, btnAddall);
         adminController.actions();
         adminController.setIconforButton();
        
         //user 
        userController = new UserController(txtFullName, txtEmail, txtSearchall, txtPassword, txtConfirmpassword, 
                btnAddall, btnUser, btnSubmit , table, addupdateUser, adminPanel);
        userController.actions();
     
        //Category
        categoryController = new CategoryController(txtCategoryName, txtSearchall, table, btnAddall, btnSubmitCategory, btnCategory, adminPanel, addupdateCategory);
        categoryController.actions();
         
        //Book
        bookController = new BookController(txtAuthor, txtPrice, txtIsbn, txtPublishDate, txtSearchall, txtTitle, cbxCategory, lblImage, 
                btnSubmitBook, btnBook, btnUpload, btnAddall, table, adminPanel, addupdateBook);
        bookController.actions();
        
        //Customer
        customerController = new CustomerController(table, btnCustomer, btnAddall, txtSearchall, adminPanel);
        customerController.actions();
        
        //Profile
        profileController = new CustomerController(lblUsername, lblPassword, lblCity, lblCountry, lblZipcode, lblPhone, lblEmail, lblRegisterdate, btnChangePassword);
        profileController.showProfile();
        
        //DashBoard
        dashBoardController = new BookController(preferPanel, recommentPanel);
        dashBoardController.showDashBoard();
         //test imageicon
         lblProfile.setIcon(getIcon("/com/uit/image/icons8_profile_128px.png", 30, 30));
         lblOrderHistory.setIcon(getIcon("/com/uit/image/icons8_order_history_60px_1.png", 30, 30));
         lblDashBoard.setIcon(getIcon("/com/uit/image/icons8_home_page_80px_1.png", 30, 30));
         lblUser.setIcon(getIcon("/com/uit/image/icons8_user_80px.png", 30, 30));
         lblOrder.setIcon(getIcon("/com/uit/image/Order.png", 30, 30));
         lblLogout.setIcon(getIcon("/com/uit/image/icons8_logout_rounded_left_64px_2.png", 30, 30));
    }
    
    
    public ImageIcon getIcon(String url, int w, int h){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }
    
    private void changePanel(JPanel panel) {
        LayeredPane.removeAll();
        LayeredPane.add(panel);
        LayeredPane.repaint();
        LayeredPane.revalidate();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookDetail = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        btnBuy = new javax.swing.JButton();
        lblImageorder = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblPublishdate = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnPlus = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        btnMinus = new javax.swing.JButton();
        addupdateUser = new javax.swing.JDialog();
        addUserPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmpassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        addupdateCategory = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        txtCategoryName = new javax.swing.JTextField();
        btnSubmitCategory = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        addupdateBook = new javax.swing.JDialog();
        jLabel28 = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtPublishDate = new com.toedter.calendar.JDateChooser();
        jLabel33 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        btnSubmitBook = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        taskbarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblProfile = new javax.swing.JLabel();
        lblDashBoard = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblOrderHistory = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        LayeredPane = new javax.swing.JLayeredPane();
        dashboardPanel = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        preferPanel = new javax.swing.JPanel();
        recommentPanel = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblZipcode = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblRegisterdate = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        orderhistoryPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderDetail = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        bookPanel = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        btnUser = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtSearchall = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnAddall = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        orderPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSearchBook = new javax.swing.JTextField();
        lblCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewOrder = new javax.swing.JPanel();
        lblNotice = new javax.swing.JLabel();
        buyPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnBuyproduct = new javax.swing.JButton();
        lblSum = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        displayPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnMoreBook = new javax.swing.JButton();
        btnClearOrder = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnBuy.setBackground(new java.awt.Color(255, 51, 51));
        btnBuy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("ADD TO CART");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Title");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Author");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("PublishDate");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Price");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Quantity");

        jLabel18.setText("Description");

        btnPlus.setBackground(new java.awt.Color(255, 255, 255));
        btnPlus.setText("+");

        lblQuantity.setText("1");

        btnMinus.setBackground(new java.awt.Color(255, 255, 255));
        btnMinus.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(lblImageorder, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel18)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel12))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPublishdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lblQuantity)
                                .addGap(12, 12, 12)
                                .addComponent(btnPlus))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(btnMinus))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnBuy)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblImageorder, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel12)
                            .addComponent(btnMinus)
                            .addComponent(btnPlus)
                            .addComponent(lblQuantity)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblTitle))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(lblAuthor))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(lblPublishdate))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrice)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(btnBuy)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout bookDetailLayout = new javax.swing.GroupLayout(bookDetail.getContentPane());
        bookDetail.getContentPane().setLayout(bookDetailLayout);
        bookDetailLayout.setHorizontalGroup(
            bookDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookDetailLayout.setVerticalGroup(
            bookDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addUserPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ADD/UPDATE USER");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("FullName");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Password");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Confirm password");

        txtFullName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUserPanelLayout = new javax.swing.GroupLayout(addUserPanel);
        addUserPanel.setLayout(addUserPanelLayout);
        addUserPanelLayout.setHorizontalGroup(
            addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(addUserPanelLayout.createSequentialGroup()
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15))
                        .addGap(28, 28, 28)
                        .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFullName)
                            .addComponent(txtEmail)
                            .addComponent(txtPassword)
                            .addComponent(txtConfirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnSubmit)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(125, 125, 125))
        );
        addUserPanelLayout.setVerticalGroup(
            addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtConfirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnSubmit)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addupdateUserLayout = new javax.swing.GroupLayout(addupdateUser.getContentPane());
        addupdateUser.getContentPane().setLayout(addupdateUserLayout);
        addupdateUserLayout.setHorizontalGroup(
            addupdateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
            .addGroup(addupdateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addupdateUserLayout.createSequentialGroup()
                    .addComponent(addUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        addupdateUserLayout.setVerticalGroup(
            addupdateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
            .addGroup(addupdateUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addUserPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("CategoryName");

        btnSubmitCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubmitCategory.setText("SUBMIT");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("ADD/UPDATE CATEGORY");

        javax.swing.GroupLayout addupdateCategoryLayout = new javax.swing.GroupLayout(addupdateCategory.getContentPane());
        addupdateCategory.getContentPane().setLayout(addupdateCategoryLayout);
        addupdateCategoryLayout.setHorizontalGroup(
            addupdateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addupdateCategoryLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(addupdateCategoryLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(btnSubmitCategory))
            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addupdateCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(74, 74, 74))
        );
        addupdateCategoryLayout.setVerticalGroup(
            addupdateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addupdateCategoryLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(addupdateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnSubmitCategory)
                .addGap(42, 42, 42))
        );

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Category");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Title");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Author");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Isbn");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("PublishDate");

        txtPublishDate.setDateFormatString("dd-MM-yyyy");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Image");

        lblImage.setBackground(new java.awt.Color(153, 153, 255));
        lblImage.setForeground(new java.awt.Color(204, 204, 204));
        lblImage.setOpaque(true);

        btnUpload.setBackground(java.awt.Color.white);
        btnUpload.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpload.setText("Upload");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Price");

        btnSubmitBook.setBackground(java.awt.Color.white);
        btnSubmitBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubmitBook.setText("SUBMIT");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("ADD/UPDATE BOOK");

        javax.swing.GroupLayout addupdateBookLayout = new javax.swing.GroupLayout(addupdateBook.getContentPane());
        addupdateBook.getContentPane().setLayout(addupdateBookLayout);
        addupdateBookLayout.setHorizontalGroup(
            addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addGroup(addupdateBookLayout.createSequentialGroup()
                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnSubmitBook))
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel21)))
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addupdateBookLayout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addupdateBookLayout.createSequentialGroup()
                            .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(jLabel32))
                            .addGap(52, 52, 52)
                            .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(addupdateBookLayout.createSequentialGroup()
                            .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel33)
                                .addComponent(jLabel34))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnUpload)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(70, Short.MAX_VALUE)))
        );
        addupdateBookLayout.setVerticalGroup(
            addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addupdateBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(15, 15, 15)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(btnSubmitBook)
                .addGap(66, 66, 66))
            .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addupdateBookLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addupdateBookLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel32))
                        .addGroup(addupdateBookLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(txtPublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(25, 25, 25)
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnUpload)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(136, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LayerPane");

        taskbarPanel.setBackground(new java.awt.Color(47, 54, 64));
        taskbarPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UIT BOOKSTORE");

        jSeparator1.setBackground(new java.awt.Color(0, 255, 255));

        lblProfile.setBackground(new java.awt.Color(47, 54, 64));
        lblProfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProfile.setText("Profile");
        lblProfile.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblProfile.setOpaque(true);
        lblProfile.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblProfileMouseMoved(evt);
            }
        });
        lblProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProfileMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblProfileMouseExited(evt);
            }
        });

        lblDashBoard.setBackground(new java.awt.Color(47, 54, 64));
        lblDashBoard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        lblDashBoard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDashBoard.setText("DashBoard");
        lblDashBoard.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblDashBoard.setOpaque(true);
        lblDashBoard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblDashBoardMouseMoved(evt);
            }
        });
        lblDashBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashBoardMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDashBoardMouseExited(evt);
            }
        });

        lblUser.setBackground(new java.awt.Color(47, 54, 64));
        lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUser.setText("User");
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblUser.setOpaque(true);
        lblUser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblUserMouseMoved(evt);
            }
        });
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUserMouseExited(evt);
            }
        });

        lblOrderHistory.setBackground(new java.awt.Color(47, 54, 64));
        lblOrderHistory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrderHistory.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderHistory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrderHistory.setText("Order History");
        lblOrderHistory.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblOrderHistory.setOpaque(true);
        lblOrderHistory.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblOrderHistoryMouseMoved(evt);
            }
        });
        lblOrderHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderHistoryMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOrderHistoryMouseExited(evt);
            }
        });

        lblOrder.setBackground(new java.awt.Color(47, 54, 64));
        lblOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(255, 255, 255));
        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrder.setText("Order");
        lblOrder.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblOrder.setOpaque(true);
        lblOrder.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblOrderMouseMoved(evt);
            }
        });
        lblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOrderMouseExited(evt);
            }
        });

        lblLogout.setBackground(new java.awt.Color(47, 54, 64));
        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogout.setText("LogOut");
        lblLogout.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblLogout.setOpaque(true);
        lblLogout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblLogoutMouseMoved(evt);
            }
        });
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout taskbarPanelLayout = new javax.swing.GroupLayout(taskbarPanel);
        taskbarPanel.setLayout(taskbarPanelLayout);
        taskbarPanelLayout.setHorizontalGroup(
            taskbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(lblProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDashBoard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblOrderHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(taskbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        taskbarPanelLayout.setVerticalGroup(
            taskbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LayeredPane.setLayout(new java.awt.CardLayout());

        dashboardPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Best Seller Book");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("Recommend for you");

        javax.swing.GroupLayout preferPanelLayout = new javax.swing.GroupLayout(preferPanel);
        preferPanel.setLayout(preferPanelLayout);
        preferPanelLayout.setHorizontalGroup(
            preferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        preferPanelLayout.setVerticalGroup(
            preferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout recommentPanelLayout = new javax.swing.GroupLayout(recommentPanel);
        recommentPanel.setLayout(recommentPanelLayout);
        recommentPanelLayout.setHorizontalGroup(
            recommentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        recommentPanelLayout.setVerticalGroup(
            recommentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(preferPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recommentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(347, Short.MAX_VALUE))
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel38)
                .addGap(26, 26, 26)
                .addComponent(preferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel39)
                .addGap(29, 29, 29)
                .addComponent(recommentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        LayeredPane.add(dashboardPanel, "card2");

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("UserName");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Email");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Address");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("City");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Country");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Phone");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Zipcode");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Password");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("RegisterDate");

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCountry.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblZipcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblRegisterdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setText("ChangePassword");

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(95, 95, 95)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblZipcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(79, 79, 79)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(lblRegisterdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(50, 50, 50)
                .addComponent(btnChangePassword)
                .addGap(473, 473, 473))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblUsername))
                .addGap(51, 51, 51)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblEmail))
                .addGap(49, 49, 49)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblAddress))
                .addGap(48, 48, 48)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblCity))
                .addGap(46, 46, 46)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangePassword)
                        .addGap(27, 27, 27)))
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lblRegisterdate, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        LayeredPane.add(profilePanel, "card3");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblOrder);

        jLabel17.setText("ListAllOrder");

        tblOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblOrderDetail);

        jLabel19.setText("OrderDetail");

        javax.swing.GroupLayout orderhistoryPanelLayout = new javax.swing.GroupLayout(orderhistoryPanel);
        orderhistoryPanel.setLayout(orderhistoryPanelLayout);
        orderhistoryPanelLayout.setHorizontalGroup(
            orderhistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderhistoryPanelLayout.createSequentialGroup()
                .addGroup(orderhistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(orderhistoryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(orderhistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        orderhistoryPanelLayout.setVerticalGroup(
            orderhistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderhistoryPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        LayeredPane.add(orderhistoryPanel, "card4");

        javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );

        LayeredPane.add(bookPanel, "card5");

        adminPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUser.setText("User");
        btnUser.setPreferredSize(new java.awt.Dimension(85, 23));

        btnCategory.setBackground(new java.awt.Color(255, 255, 255));
        btnCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCategory.setText("Categroy");
        btnCategory.setPreferredSize(new java.awt.Dimension(85, 23));

        btnBook.setBackground(new java.awt.Color(255, 255, 255));
        btnBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBook.setText("Book");
        btnBook.setPreferredSize(new java.awt.Dimension(85, 23));

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomer.setText("Customer");
        btnCustomer.setPreferredSize(new java.awt.Dimension(85, 23));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Search");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(table);

        btnAddall.setBackground(new java.awt.Color(255, 255, 255));
        btnAddall.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddall.setText("Add new ");

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14)
                        .addGap(32, 32, 32)
                        .addComponent(txtSearchall, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnAddall, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(400, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addComponent(jScrollPane7)
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddall)
                    .addComponent(txtSearchall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
        );

        LayeredPane.add(adminPanel, "card6");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Search");

        lblCart.setBackground(new java.awt.Color(102, 255, 102));
        lblCart.setForeground(new java.awt.Color(102, 51, 255));
        lblCart.setOpaque(true);
        lblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCartMouseClicked(evt);
            }
        });

        viewOrder.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout viewOrderLayout = new javax.swing.GroupLayout(viewOrder);
        viewOrder.setLayout(viewOrderLayout);
        viewOrderLayout.setHorizontalGroup(
            viewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        viewOrderLayout.setVerticalGroup(
            viewOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(viewOrder);

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(lblCart, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCart, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblNotice)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );

        LayeredPane.add(orderPanel, "card7");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("SUM:");

        btnBuyproduct.setBackground(new java.awt.Color(255, 0, 51));
        btnBuyproduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuyproduct.setForeground(new java.awt.Color(255, 255, 255));
        btnBuyproduct.setText("BUY");

        lblSum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        displayPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayPanel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane3.setViewportView(displayPanel);

        jLabel13.setBackground(new java.awt.Color(255, 255, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(Color.decode("#e17055")
        );
        jLabel13.setText("MY ORDERs");
        jLabel13.setOpaque(true);

        btnMoreBook.setBackground(new java.awt.Color(255, 255, 255));
        btnMoreBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMoreBook.setText("+ Add More Book");
        btnMoreBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreBookActionPerformed(evt);
            }
        });

        btnClearOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnClearOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClearOrder.setText("Clear Order");

        javax.swing.GroupLayout buyPanelLayout = new javax.swing.GroupLayout(buyPanel);
        buyPanel.setLayout(buyPanelLayout);
        buyPanelLayout.setHorizontalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buyPanelLayout.createSequentialGroup()
                .addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buyPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)
                        .addComponent(btnMoreBook)
                        .addGap(47, 47, 47)
                        .addComponent(btnClearOrder)
                        .addGap(15, 15, 15))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSum, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuyproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        buyPanelLayout.setVerticalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buyPanelLayout.createSequentialGroup()
                .addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buyPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMoreBook)
                            .addComponent(btnClearOrder))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buyPanelLayout.createSequentialGroup()
                        .addGroup(buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(74, 74, 74)
                        .addComponent(btnBuyproduct)
                        .addGap(0, 537, Short.MAX_VALUE))))
        );

        LayeredPane.add(buyPanel, "card8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(taskbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taskbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LayeredPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        changePanel(adminPanel);
    }//GEN-LAST:event_lblUserMouseClicked

    private void lblDashBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashBoardMouseClicked
        changePanel(dashboardPanel);
    }//GEN-LAST:event_lblDashBoardMouseClicked

    private void lblProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfileMouseClicked
       changePanel(profilePanel);
    }//GEN-LAST:event_lblProfileMouseClicked

    private void lblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseClicked
        changePanel(orderPanel);
        orderController.setView();
    }//GEN-LAST:event_lblOrderMouseClicked

    private void lblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCartMouseClicked
        changePanel(buyPanel);
        buyOrderController.setView();
        lblNotice.setText("");
        lblNotice.setIcon(null);
        //list.clear();
    }//GEN-LAST:event_lblCartMouseClicked

    private void lblUserMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseMoved
        // TODO add your handling code here:
        lblUser.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblUserMouseMoved

    private void lblUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseExited
        // TODO add your handling code here:
        lblUser.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblUserMouseExited

    private void lblOrderMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseMoved
        // TODO add your handling code here:
        lblOrder.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblOrderMouseMoved

    private void lblOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseExited
        // TODO add your handling code here:
        lblOrder.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblOrderMouseExited

    private void lblProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfileMouseMoved
        // TODO add your handling code here:
         lblProfile.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblProfileMouseMoved

    private void lblProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfileMouseExited
        // TODO add your handling code here:
        lblProfile.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblProfileMouseExited

    private void lblDashBoardMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashBoardMouseMoved
        // TODO add your handling code here:
        lblDashBoard.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblDashBoardMouseMoved

    private void lblDashBoardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashBoardMouseExited
        // TODO add your handling code here:
        lblDashBoard.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblDashBoardMouseExited

    private void lblOrderHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderHistoryMouseClicked
        // TODO add your handling code here:
        changePanel(orderhistoryPanel);
        orderHistoryController.listOrder();
        tblOrder.getSelectionModel().clearSelection();
    }//GEN-LAST:event_lblOrderHistoryMouseClicked

    private void lblOrderHistoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderHistoryMouseMoved
        // TODO add your handling code here:
         lblOrderHistory.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblOrderHistoryMouseMoved

    private void lblOrderHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderHistoryMouseExited
        // TODO add your handling code here:
        lblOrderHistory.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblOrderHistoryMouseExited

    private void btnMoreBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreBookActionPerformed
        // TODO add your handling code here:
        changePanel(orderPanel);
    }//GEN-LAST:event_btnMoreBookActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void lblLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLogoutMouseMoved

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
        LoginFrame lf = new LoginFrame();
        lf.pack();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLogoutMouseExited

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JPanel addUserPanel;
    private javax.swing.JDialog addupdateBook;
    private javax.swing.JDialog addupdateCategory;
    private javax.swing.JDialog addupdateUser;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JDialog bookDetail;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JButton btnAddall;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnBuyproduct;
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnClearOrder;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMoreBook;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmitBook;
    private javax.swing.JButton btnSubmitCategory;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel buyPanel;
    private javax.swing.JComboBox<Category> cbxCategory;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDashBoard;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageorder;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblNotice;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrderHistory;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblPublishdate;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblRegisterdate;
    private javax.swing.JLabel lblSum;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblZipcode;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JPanel orderhistoryPanel;
    private javax.swing.JPanel preferPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JPanel recommentPanel;
    private javax.swing.JTable table;
    private javax.swing.JPanel taskbarPanel;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblOrderDetail;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JPasswordField txtConfirmpassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPrice;
    private com.toedter.calendar.JDateChooser txtPublishDate;
    private javax.swing.JTextField txtSearchBook;
    private javax.swing.JTextField txtSearchall;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JPanel viewOrder;
    // End of variables declaration//GEN-END:variables
}
