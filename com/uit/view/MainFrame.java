
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
import com.uit.controller.DashBoardController;
import com.uit.controller.InventoryController;
import com.uit.controller.OrderController;
import com.uit.controller.OrderHistoryController;
import com.uit.controller.ProfileController;
import com.uit.controller.StatisticController;
import com.uit.controller.SupplierController;
import com.uit.controller.UserController;
import com.uit.entity.Book;
import com.uit.entity.Category;
import com.uit.entity.Supplier;
import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vunguyen
 */
public class MainFrame extends javax.swing.JFrame {

    protected OrderController orderController;
    protected OrderController adminOrder;
    protected BuyOrderController buyOrderController;
    protected AdminController adminController;
    protected UserController userController;
    protected CategoryController categoryController;
    protected BookController bookController;
    protected CustomerController customerController;
    protected SupplierController supplierController;
    protected InventoryController inventoryController;
    protected ProfileController profileController;
    protected OrderHistoryController orderHistoryController;
    protected DashBoardController dashBoardController;
    protected StatisticController statisticController;
    public static Map<Book, Integer> list;

    /**
     * Creates new form Test
     */
    public MainFrame() {
        initComponents();
        list = new HashMap<>();
         //Admin
        adminController = new AdminController(btnUser, btnCategory, btnBook, btnCustomer, btnAddall, btnOrder, btnSupplier, btnInventory);
        adminController.actions();
        adminController.setIconforButton();
        
         //User 
        userController = new UserController(txtFullName, txtEmail, txtSearchall, txtPassword, txtConfirmpassword,
                btnAddall, btnUser, btnSubmit, table, addupdateUser, adminPanel);
        userController.actions();

        //Category
        categoryController = new CategoryController(txtCategoryName, txtSearchall, table, btnAddall, btnSubmitCategory, btnCategory, adminPanel, addupdateCategory);
        categoryController.actions();

        //Book
        bookController = new BookController(txtAuthor, txtPrice, txtIsbn, txtPublishDate, txtSearchall, txtTitle, cbxCategory, lblImage,
                btnSubmitBook, btnBook, btnUpload, btnAddall, table, adminPanel, addupdateBook, cbxSupplier, txtCurQuantity, txtSubtotal, txtDescription);
        bookController.actions();

        //Customer
        customerController = new CustomerController(table, btnCustomer, btnAddall, txtSearchall, adminPanel);
        customerController.actions();
        
        //Supplier
        supplierController = new SupplierController(btnSupplier, btnAddall, btnSubmitSupplier, txtSupplierName, txtSupplierAdress, 
                txtSupplierPhone, addupdateSupplier, txtSearchall, table, adminPanel);
        supplierController.actions();

        //inventory
        inventoryController = new InventoryController(btnInventory, btnAddall, txtSearchall, table, adminPanel);
        inventoryController.actions();
        
        //Order
        orderController = new OrderController(viewOrder, bookDetail, txtSearchBook, cbxOrderCategroy, lblTitle, lblAuthor,
                lblPublishdate, lblImageorder, lblPrice, btnPlus, btnMinus, btnBuy, list, lblQuantity, lblNotice, lblDescription, lblStatus,
                commentPanel, txtComment, btnSend, rb1, rb2, rb3, rb4, rb5);
        orderController.actions();
        orderController.setIconforShipingCart(lblCart);

        adminOrder = new OrderController(table, btnOrder, btnAddall, txtSearchall, tblDetail, orderDetail, adminPanel);
        adminOrder.setViewAdminOrder();

        //BuyOrder
        buyOrderController = new BuyOrderController(lblSum, btnBuyproduct, btnClearOrder, displayPanel, list);
        buyOrderController.action();

        //OrderHistory
        orderHistoryController = new OrderHistoryController(tblOrder, tblOrderDetail, LoginFrame.customer, 
                bookDetail, commentPanel, lblImageorder, lblTitle, lblAuthor, lblDescription, lblPublishdate, txtComment, btnSend, rb1, rb2, rb3, rb4, rb5);
        orderHistoryController.listOrder();
        orderHistoryController.action();

        //Profile
        profileController = new ProfileController(lblUsername, lblPassword, lblCity, lblAddress, lblCountry, lblZipcode, lblPhone, lblEmail, lblRegisterdate, btnChangePassword);
        profileController.showProfile();

        //DashBoard
        dashBoardController = new DashBoardController(preferPanel, recommentPanel, lblWelcome);
        dashBoardController.showDashBoard();
        
        //Statistic
        statisticController = new StatisticController(btnStatistic, month, year, btnView, btnList, lblQuantityBook, lblQuantityCustomer, lblQuantityOrder);
        statisticController.actions();
        
        //test imageicon
        lblProfile.setIcon(getIcon("/com/uit/image/icons8_profile_128px.png", 30, 30));
        lblOrderHistory.setIcon(getIcon("/com/uit/image/icons8_order_history_60px_1.png", 30, 30));
        lblDashBoard.setIcon(getIcon("/com/uit/image/icons8_home_page_80px_1.png", 30, 30));
        lblAdmin.setIcon(getIcon("/com/uit/image/icons8_user_80px.png", 30, 30));
        lblOrder.setIcon(getIcon("/com/uit/image/Order.png", 30, 30));
        lblLogout.setIcon(getIcon("/com/uit/image/icons8_logout_rounded_left_64px_2.png", 30, 30));
        lblStatistic.setIcon(getIcon("/com/uit/image/icons8_combo_chart_80px_6.png", 30, 30));
        
        //change dashboar
        changePanel(dashboardPanel);
    }

    public ImageIcon getIcon(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public JLabel getLblAdmin(){
        return lblAdmin;
    }
    
    public JLabel getLblStatistic(){
        return lblStatistic;
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
        btnPlus = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        btnMinus = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        rb5 = new javax.swing.JRadioButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        commentPanel = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
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
        jLabel48 = new javax.swing.JLabel();
        cbxSupplier = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        txtCurQuantity = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        orderDetail = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        addupdateSupplier = new javax.swing.JDialog();
        jLabel44 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        txtSupplierAdress = new javax.swing.JTextField();
        txtSupplierPhone = new javax.swing.JTextField();
        btnSubmitSupplier = new javax.swing.JButton();
        taskbarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblProfile = new javax.swing.JLabel();
        lblDashBoard = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        lblOrderHistory = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblStatistic = new javax.swing.JLabel();
        LayeredPane = new javax.swing.JLayeredPane();
        profilePanel = new javax.swing.JPanel();
        btnChangePassword = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblRegisterdate = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblZipcode = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        orderhistoryPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderDetail = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        bookPanel = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtSearchall = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnAddall = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnUser = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        orderPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSearchBook = new javax.swing.JTextField();
        lblCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewOrder = new javax.swing.JPanel();
        lblNotice = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        cbxOrderCategroy = new javax.swing.JComboBox<>();
        buyPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnBuyproduct = new javax.swing.JButton();
        lblSum = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        displayPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnMoreBook = new javax.swing.JButton();
        btnClearOrder = new javax.swing.JButton();
        statisticPanel = new javax.swing.JPanel();
        btnStatistic = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        year = new com.toedter.calendar.JYearChooser();
        month = new com.toedter.calendar.JMonthChooser();
        jLabel53 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        btnList = new javax.swing.JButton();
        lblQuantityBook = new javax.swing.JLabel();
        lblQuantityCustomer = new javax.swing.JLabel();
        lblQuantityOrder = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        dashboardPanel = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        preferPanel = new javax.swing.JPanel();
        recommentPanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();

        bookDetail.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnBuy.setBackground(new java.awt.Color(255, 51, 51));
        btnBuy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("ADD TO CART");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

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

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lblAuthor.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lblPublishdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        btnPlus.setBackground(new java.awt.Color(255, 255, 255));
        btnPlus.setText("+");

        lblQuantity.setText("1");

        btnMinus.setBackground(new java.awt.Color(255, 255, 255));
        btnMinus.setText("-");
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("*Comment");

        btnSend.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSend.setText("SEND");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("*Rating");

        rb1.setText("1");

        rb2.setText("2");

        rb3.setText("3");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        rb4.setText("4");

        rb5.setText("5");

        txtComment.setColumns(20);
        txtComment.setRows(5);
        jScrollPane8.setViewportView(txtComment);

        commentPanel.setAutoscrolls(true);

        javax.swing.GroupLayout commentPanelLayout = new javax.swing.GroupLayout(commentPanel);
        commentPanel.setLayout(commentPanelLayout);
        commentPanelLayout.setHorizontalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        commentPanelLayout.setVerticalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(commentPanel);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("*Write");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rb1)
                        .addGap(18, 18, 18)
                        .addComponent(rb2)
                        .addGap(18, 18, 18)
                        .addComponent(rb3)
                        .addGap(18, 18, 18)
                        .addComponent(rb4)
                        .addGap(18, 18, 18)
                        .addComponent(rb5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSend))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel41))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel42)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblImageorder, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblPublishdate, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuy)
                                        .addGap(80, 80, 80))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(50, 50, 50)
                                                .addComponent(btnMinus)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnPlus))
                                            .addComponent(jLabel10)
                                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(402, Short.MAX_VALUE))))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblImageorder, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPublishdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnBuy)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblQuantity)
                                    .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb1)
                            .addComponent(rb2)
                            .addComponent(rb3)
                            .addComponent(rb4)
                            .addComponent(rb5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSend)
                                .addGap(41, 41, 41))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            .addComponent(jSeparator4)
            .addGroup(addupdateCategoryLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtCategoryName)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addupdateCategoryLayout.createSequentialGroup()
                .addGap(52, 107, Short.MAX_VALUE)
                .addGroup(addupdateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addupdateCategoryLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addupdateCategoryLayout.createSequentialGroup()
                        .addComponent(btnSubmitCategory)
                        .addGap(123, 123, 123))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnSubmitCategory)
                .addGap(43, 43, 43))
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
        btnSubmitBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitBookActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ADD/UPDATE BOOK");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Supplier");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("Quantity");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Subtotal");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane9.setViewportView(txtDescription);

        javax.swing.GroupLayout addupdateBookLayout = new javax.swing.GroupLayout(addupdateBook.getContentPane());
        addupdateBook.getContentPane().setLayout(addupdateBookLayout);
        addupdateBookLayout.setHorizontalGroup(
            addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addupdateBookLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addGap(56, 56, 56)
                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel49))
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPublishDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addupdateBookLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpload)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(109, 109, 109)
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addupdateBookLayout.createSequentialGroup()
                                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel48))
                                .addGap(30, 30, 30)
                                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCurQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 34, Short.MAX_VALUE))
            .addComponent(jSeparator5)
            .addGroup(addupdateBookLayout.createSequentialGroup()
                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(btnSubmitBook))
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addupdateBookLayout.setVerticalGroup(
            addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addupdateBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel48)
                        .addComponent(cbxSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addupdateBookLayout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addupdateBookLayout.createSequentialGroup()
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpload)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmitBook)
                        .addGap(26, 26, 26))
                    .addGroup(addupdateBookLayout.createSequentialGroup()
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel49)
                                .addComponent(txtCurQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addGroup(addupdateBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addupdateBookLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtPublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addupdateBookLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(233, Short.MAX_VALUE))))
        );

        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblDetail);

        javax.swing.GroupLayout orderDetailLayout = new javax.swing.GroupLayout(orderDetail.getContentPane());
        orderDetail.getContentPane().setLayout(orderDetailLayout);
        orderDetailLayout.setHorizontalGroup(
            orderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        orderDetailLayout.setVerticalGroup(
            orderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        addupdateSupplier.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("ADD/UPDATE SUPPLIER");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Name");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Address");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Phone");

        btnSubmitSupplier.setBackground(new java.awt.Color(255, 255, 255));
        btnSubmitSupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSubmitSupplier.setText("SUBMIT");

        javax.swing.GroupLayout addupdateSupplierLayout = new javax.swing.GroupLayout(addupdateSupplier.getContentPane());
        addupdateSupplier.getContentPane().setLayout(addupdateSupplierLayout);
        addupdateSupplierLayout.setHorizontalGroup(
            addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator7)
            .addGroup(addupdateSupplierLayout.createSequentialGroup()
                .addGroup(addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addupdateSupplierLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel44))
                    .addGroup(addupdateSupplierLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47))
                        .addGap(76, 76, 76)
                        .addGroup(addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmitSupplier)
                            .addGroup(addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSupplierName, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(txtSupplierAdress)
                                .addComponent(txtSupplierPhone)))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        addupdateSupplierLayout.setVerticalGroup(
            addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addupdateSupplierLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtSupplierAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(addupdateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(txtSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnSubmitSupplier)
                .addGap(43, 43, 43))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lblAdmin.setBackground(new java.awt.Color(47, 54, 64));
        lblAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAdmin.setText("Admin");
        lblAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblAdmin.setOpaque(true);
        lblAdmin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblAdminMouseMoved(evt);
            }
        });
        lblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAdminMouseExited(evt);
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

        lblStatistic.setBackground(new java.awt.Color(47, 54, 64));
        lblStatistic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStatistic.setForeground(new java.awt.Color(255, 255, 255));
        lblStatistic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStatistic.setText("Statistic");
        lblStatistic.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblStatistic.setOpaque(true);
        lblStatistic.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblStatisticMouseMoved(evt);
            }
        });
        lblStatistic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStatisticMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblStatisticMouseExited(evt);
            }
        });

        javax.swing.GroupLayout taskbarPanelLayout = new javax.swing.GroupLayout(taskbarPanel);
        taskbarPanel.setLayout(taskbarPanelLayout);
        taskbarPanelLayout.setHorizontalGroup(
            taskbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(lblProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDashBoard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblOrderHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(taskbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        taskbarPanelLayout.setVerticalGroup(
            taskbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LayeredPane.setLayout(new java.awt.CardLayout());

        profilePanel.setBackground(Color.decode("#ecf0f1"));
        profilePanel.setMaximumSize(new java.awt.Dimension(70, 70));
        profilePanel.setPreferredSize(new java.awt.Dimension(70, 70));

        btnChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setText("ChangePassword");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("ADDRESS");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("USERNAME");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEmail.setText("Email");
        lblEmail.setMaximumSize(new java.awt.Dimension(70, 70));
        lblEmail.setPreferredSize(new java.awt.Dimension(70, 70));

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPassword.setText("Pasword");
        lblPassword.setMaximumSize(new java.awt.Dimension(70, 70));
        lblPassword.setPreferredSize(new java.awt.Dimension(70, 70));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("CITY");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("COUNTRY");

        lblRegisterdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRegisterdate.setText("Date");
        lblRegisterdate.setMaximumSize(new java.awt.Dimension(70, 70));
        lblRegisterdate.setPreferredSize(new java.awt.Dimension(70, 70));

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUsername.setText("Username");
        lblUsername.setMaximumSize(new java.awt.Dimension(70, 70));
        lblUsername.setPreferredSize(new java.awt.Dimension(70, 70));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("EMAIL");

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPhone.setText("Phone");

        lblCity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCity.setText("City");
        lblCity.setMaximumSize(new java.awt.Dimension(70, 70));
        lblCity.setPreferredSize(new java.awt.Dimension(70, 70));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("PHONE");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddress.setText("Address");
        lblAddress.setMaximumSize(new java.awt.Dimension(70, 70));
        lblAddress.setPreferredSize(new java.awt.Dimension(70, 70));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("ZIPCODE");

        lblZipcode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblZipcode.setText("Zipcode");
        lblZipcode.setMaximumSize(new java.awt.Dimension(70, 70));
        lblZipcode.setPreferredSize(new java.awt.Dimension(70, 70));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("REGISTERDATE");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("PASSWORD");

        lblCountry.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCountry.setText("Country");
        lblCountry.setMaximumSize(new java.awt.Dimension(70, 70));
        lblCountry.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblRegisterdate, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblZipcode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(lblCountry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lblRegisterdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnChangePassword)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChangePassword)
                .addGap(214, 214, 214))
        );

        LayeredPane.add(profilePanel, "card3");

        orderhistoryPanel.setBackground(Color.decode("#ecf0f1")
        );

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

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("OrderDetail");

        javax.swing.GroupLayout orderhistoryPanelLayout = new javax.swing.GroupLayout(orderhistoryPanel);
        orderhistoryPanel.setLayout(orderhistoryPanelLayout);
        orderhistoryPanelLayout.setHorizontalGroup(
            orderhistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderhistoryPanelLayout.createSequentialGroup()
                .addGroup(orderhistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        orderhistoryPanelLayout.setVerticalGroup(
            orderhistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderhistoryPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        LayeredPane.add(orderhistoryPanel, "card4");

        javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 944, Short.MAX_VALUE)
        );
        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        LayeredPane.add(bookPanel, "card5");

        adminPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Search");

        txtSearchall.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUser.setText("User");
        btnUser.setPreferredSize(new java.awt.Dimension(85, 23));
        jPanel1.add(btnUser);

        btnCategory.setBackground(new java.awt.Color(255, 255, 255));
        btnCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCategory.setText("Categroy");
        btnCategory.setPreferredSize(new java.awt.Dimension(85, 23));
        jPanel1.add(btnCategory);

        btnBook.setBackground(new java.awt.Color(255, 255, 255));
        btnBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBook.setText("Book");
        btnBook.setPreferredSize(new java.awt.Dimension(85, 23));
        jPanel1.add(btnBook);

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomer.setText("Customer");
        btnCustomer.setPreferredSize(new java.awt.Dimension(85, 23));
        jPanel1.add(btnCustomer);

        btnOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOrder.setText("Order");
        jPanel1.add(btnOrder);

        btnSupplier.setBackground(new java.awt.Color(255, 255, 255));
        btnSupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSupplier.setText("Supplier");
        jPanel1.add(btnSupplier);

        btnInventory.setBackground(new java.awt.Color(255, 255, 255));
        btnInventory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventory.setText("Inventory");
        jPanel1.add(btnInventory);

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jScrollPane7)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel14)
                .addGap(32, 32, 32)
                .addComponent(txtSearchall, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnAddall, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddall)
                    .addComponent(txtSearchall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
        );

        LayeredPane.add(adminPanel, "card6");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Search");

        txtSearchBook.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Category");

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxOrderCategroy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(lblNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCart, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addComponent(jScrollPane2)
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCart, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43)
                        .addComponent(cbxOrderCategroy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
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
        btnClearOrder.setText("x Clear Order");

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
                .addGap(0, 7, Short.MAX_VALUE))
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
                        .addGap(0, 497, Short.MAX_VALUE))))
        );

        LayeredPane.add(buyPanel, "card8");

        statisticPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnStatistic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStatistic.setText("Statistic");
        btnStatistic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(Color.blue);
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Top 3 potential customer");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Month/year:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel53.setForeground(Color.blue);
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Total revenue by month-year");

        btnView.setBackground(new java.awt.Color(255, 255, 255));
        btnView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnView.setText("View");
        btnView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel54.setForeground(Color.blue);
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("List book by category");

        btnList.setBackground(new java.awt.Color(255, 255, 255));
        btnList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnList.setText("List");
        btnList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblQuantityBook.setText("jLabel55");

        lblQuantityCustomer.setText("jLabel56");

        lblQuantityOrder.setText("jLabel57");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel55.setForeground(Color.blue);
        jLabel55.setText("Overview:");

        javax.swing.GroupLayout statisticPanelLayout = new javax.swing.GroupLayout(statisticPanel);
        statisticPanel.setLayout(statisticPanelLayout);
        statisticPanelLayout.setHorizontalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticPanelLayout.createSequentialGroup()
                .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statisticPanelLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(statisticPanelLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(18, 18, 18)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statisticPanelLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statisticPanelLayout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantityCustomer)
                            .addComponent(lblQuantityBook)
                            .addComponent(lblQuantityOrder)
                            .addComponent(jLabel55)))
                    .addGroup(statisticPanelLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statisticPanelLayout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statisticPanelLayout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(244, Short.MAX_VALUE))
            .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statisticPanelLayout.createSequentialGroup()
                    .addContainerGap(248, Short.MAX_VALUE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(222, 222, 222)))
        );
        statisticPanelLayout.setVerticalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticPanelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addComponent(btnStatistic)
                .addGap(37, 37, 37)
                .addComponent(jLabel18)
                .addGap(28, 28, 28)
                .addComponent(btnView)
                .addGap(46, 46, 46)
                .addComponent(jLabel54)
                .addGap(31, 31, 31)
                .addComponent(btnList)
                .addGap(26, 26, 26)
                .addComponent(jLabel55)
                .addGap(18, 18, 18)
                .addComponent(lblQuantityBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuantityCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuantityOrder)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statisticPanelLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jLabel53)
                    .addContainerGap(575, Short.MAX_VALUE)))
        );

        LayeredPane.add(statisticPanel, "card9");

        dashboardPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setText("Best Seller Book");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setText("Recommend for you");

        javax.swing.GroupLayout preferPanelLayout = new javax.swing.GroupLayout(preferPanel);
        preferPanel.setLayout(preferPanelLayout);
        preferPanelLayout.setHorizontalGroup(
            preferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        preferPanelLayout.setVerticalGroup(
            preferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout recommentPanelLayout = new javax.swing.GroupLayout(recommentPanel);
        recommentPanel.setLayout(recommentPanelLayout);
        recommentPanelLayout.setHorizontalGroup(
            recommentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        recommentPanelLayout.setVerticalGroup(
            recommentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWelcome)
                .addGap(181, 181, 181))
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recommentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(preferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblWelcome)
                .addGap(13, 13, 13)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(preferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recommentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        LayeredPane.add(dashboardPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(taskbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(taskbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LayeredPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminMouseClicked
        changePanel(adminPanel);
    }//GEN-LAST:event_lblAdminMouseClicked

    private void lblDashBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashBoardMouseClicked
        changePanel(dashboardPanel);
        dashBoardController.showDashBoard();
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

    private void lblAdminMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminMouseMoved

        lblAdmin.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblAdminMouseMoved

    private void lblAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminMouseExited

        lblAdmin.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblAdminMouseExited

    private void lblOrderMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseMoved

        lblOrder.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblOrderMouseMoved

    private void lblOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseExited

        lblOrder.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblOrderMouseExited

    private void lblProfileMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfileMouseMoved

        lblProfile.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblProfileMouseMoved

    private void lblProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProfileMouseExited

        lblProfile.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblProfileMouseExited

    private void lblDashBoardMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashBoardMouseMoved

        lblDashBoard.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblDashBoardMouseMoved

    private void lblDashBoardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashBoardMouseExited

        lblDashBoard.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblDashBoardMouseExited

    private void lblOrderHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderHistoryMouseClicked

        changePanel(orderhistoryPanel);
        orderHistoryController.listOrder();
        tblOrder.getSelectionModel().clearSelection();
    }//GEN-LAST:event_lblOrderHistoryMouseClicked

    private void lblOrderHistoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderHistoryMouseMoved

        lblOrderHistory.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblOrderHistoryMouseMoved

    private void lblOrderHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderHistoryMouseExited

        lblOrderHistory.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblOrderHistoryMouseExited

    private void btnMoreBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreBookActionPerformed

        changePanel(orderPanel);
    }//GEN-LAST:event_btnMoreBookActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void lblLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblLogoutMouseMoved

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked

        LoginFrame lf = new LoginFrame();
        lf.pack();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited

    }//GEN-LAST:event_lblLogoutMouseExited

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb3ActionPerformed

    private void btnSubmitBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitBookActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinusActionPerformed

    private void lblStatisticMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatisticMouseMoved
        lblStatistic.setBackground(new Color(225, 177, 44));
    }//GEN-LAST:event_lblStatisticMouseMoved

    private void lblStatisticMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatisticMouseClicked
        changePanel(statisticPanel);
    }//GEN-LAST:event_lblStatisticMouseClicked

    private void lblStatisticMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatisticMouseExited
        lblStatistic.setBackground(new Color(47, 54, 64));
    }//GEN-LAST:event_lblStatisticMouseExited

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JPanel addUserPanel;
    private javax.swing.JDialog addupdateBook;
    private javax.swing.JDialog addupdateCategory;
    private javax.swing.JDialog addupdateSupplier;
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
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMoreBook;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmitBook;
    private javax.swing.JButton btnSubmitCategory;
    private javax.swing.JButton btnSubmitSupplier;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel buyPanel;
    private javax.swing.JComboBox<Category> cbxCategory;
    private javax.swing.JComboBox<String> cbxOrderCategroy;
    private javax.swing.JComboBox<Supplier> cbxSupplier;
    private javax.swing.JPanel commentPanel;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDashBoard;
    private javax.swing.JLabel lblDescription;
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
    private javax.swing.JLabel lblQuantityBook;
    private javax.swing.JLabel lblQuantityCustomer;
    private javax.swing.JLabel lblQuantityOrder;
    private javax.swing.JLabel lblRegisterdate;
    private javax.swing.JLabel lblStatistic;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSum;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblZipcode;
    private com.toedter.calendar.JMonthChooser month;
    private javax.swing.JDialog orderDetail;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JPanel orderhistoryPanel;
    private javax.swing.JPanel preferPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JPanel recommentPanel;
    private javax.swing.JPanel statisticPanel;
    private javax.swing.JTable table;
    private javax.swing.JPanel taskbarPanel;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblOrderDetail;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextArea txtComment;
    private javax.swing.JPasswordField txtConfirmpassword;
    private javax.swing.JTextField txtCurQuantity;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPrice;
    private com.toedter.calendar.JDateChooser txtPublishDate;
    private javax.swing.JTextField txtSearchBook;
    private javax.swing.JTextField txtSearchall;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtSupplierAdress;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierPhone;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JPanel viewOrder;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
