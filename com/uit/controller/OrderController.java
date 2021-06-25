/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Book;
import com.uit.entity.BookOrder;
import com.uit.entity.Category;
import com.uit.entity.OrderDetail;
import com.uit.entity.Review;
import com.uit.service.BookService;
import com.uit.service.CategoryService;
import com.uit.service.OrderService;
import com.uit.service.ReviewService;
import com.uit.view.LoginFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author vunguyen
 */
public class OrderController {

    JPanel panel;
    JPanel commentPanel;
    JTextField txtSearch;
    JTextArea txtComment;
    JDialog bookDetail;
    JLabel lblTitle;
    JLabel lblAuthor;
    JLabel lblPublishdate;
    JLabel lblImageorder;
    JLabel lblPrice;
    JLabel lblDescription;
    JLabel lblStatus;
    JButton btnPlus;
    JButton btnMinus;
    JButton btnBuy;
    JButton btnSend;
    JLabel lblQuantity;
    JLabel lblNotice;
    JComboBox cbxOrderCategory;
    JRadioButton rb1, rb2, rb3, rb4, rb5;
    Map<Book, Integer> listBook;
    long bookId;
    BookService bookService;
    ReviewService reviewService;
    CategoryService categoryService;
    
    //admin order
    JTable table;
    JTable tblDetail;
    JButton btnOrder;
    JButton btnAddall;
    JPopupMenu menuOrder;
    JMenuItem detail;
    JMenuItem complete;
    JDialog orderDetail;
    JPanel adminPanel;
    OrderService orderService;
    DefaultTableModel defaultTableModel1;
    DefaultTableModel defaultTableModel2;
    public OrderController() {

    }
       
    public OrderController(JPanel panel, JDialog bookDetail, JTextField txtSearch, JComboBox cbxOrderCategory, JLabel lblTitle, JLabel lblAuthor,
            JLabel lblPublishdate, JLabel lblImageorder, JLabel lblPrice, JButton btnPlus, JButton btnMinus, JButton btnBuy, Map<Book, Integer> list,
            JLabel lblQuantity, JLabel lblNotice, JLabel lblDescription, JLabel lblStatus,
            JPanel commentPanel, JTextArea txtComment, JButton btnSend, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3, JRadioButton rb4, JRadioButton rb5) {
        this.panel = panel;
        this.txtSearch = txtSearch;
        this.cbxOrderCategory = cbxOrderCategory;
        this.bookDetail = bookDetail;
        this.lblTitle = lblTitle;
        this.lblAuthor = lblAuthor;
        this.lblPublishdate = lblPublishdate;
        this.lblImageorder = lblImageorder;
        this.lblPrice = lblPrice;
        this.btnPlus = btnPlus;
        this.btnMinus = btnMinus;
        this.btnBuy = btnBuy;
        this.listBook = list;
        this.lblQuantity = lblQuantity;
        this.lblNotice = lblNotice;
        this.lblDescription = lblDescription;
        this.lblStatus = lblStatus;
        this.commentPanel = commentPanel;
        this.txtComment = txtComment;
        this.btnSend = btnSend;
        this.rb1 = rb1;
        this.rb2 = rb2;
        this.rb3 = rb3;
        this.rb4 = rb4;
        this.rb5 = rb5;
        bookService = new BookService();
        reviewService = new ReviewService();
        categoryService = new CategoryService();
    }
    
    // admin order
    public OrderController(JTable table, JButton btnOrder, JButton btnAddall, JTable tblDetail, JDialog orderDetail, JPanel adminPanel){
        this.table = table;
        this.btnOrder = btnOrder;
        this.btnAddall = btnAddall;
        this.tblDetail = tblDetail;
        this.orderDetail = orderDetail;
        this.adminPanel = adminPanel;
        orderService = new OrderService();
        menuOrder = new JPopupMenu();
        detail = new JMenuItem();
        detail.setText("View detail");
        detail.setIcon(getIcon("/com/uit/image/icons8_view_128px_9.png", 20, 20));
        complete = new JMenuItem();
        complete.setText("Completed");
        complete.setIcon(getIcon("/com/uit/image/icons8_ok_96px.png", 20, 20));
    }
    
    public void listOrder(){
        menuOrder.add(detail);
        menuOrder.add(complete);
        table.setComponentPopupMenu(menuOrder);
        defaultTableModel1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        table.setModel(defaultTableModel1);
        defaultTableModel1.addColumn("OrderId");
        defaultTableModel1.addColumn("CustomerId");
        defaultTableModel1.addColumn("CustomerName");
        defaultTableModel1.addColumn("ShippingAddress");
        defaultTableModel1.addColumn("RecipentName");
        defaultTableModel1.addColumn("RecipentPhone");
        defaultTableModel1.addColumn("PaymentMethod");
        defaultTableModel1.addColumn("Total");
        defaultTableModel1.addColumn("OrderDate");
        defaultTableModel1.addColumn("Status");
        table.setRowHeight(30);
        setTabledata(orderService.listOrder());
        
    }
    
    public void setTabledata(List<BookOrder> list){
        defaultTableModel1.setRowCount(0);
        for(BookOrder b : list){
            defaultTableModel1.addRow(new Object[]{b.getOrderId(), b.getCustomer().getCustomerId(), b.getCustomer().getFullName(), b.getShippingAddress(),
            b.getRecipentName(), b.getRecipentPhone(), b.getPaymentMethod(), b.getTotal(), b.getOrderDate(), b.getStatus()});
        }
    }
    
    private void setTabledetail(List<OrderDetail> list){
        defaultTableModel2.setRowCount(0);
        for(OrderDetail o : list){
            defaultTableModel2.addRow(new Object[]{o.getBookOrder().getOrderId(), o.getBook().getBookId(), o.getBook().getTitle(), o.getQuantity(), o.getSubtotal()});
        }
    }
    public void setViewAdminOrder(){
        btnOrder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               listOrder();
            }
        });
        
        for(ActionListener al : btnAddall.getActionListeners()){
            btnAddall.removeActionListener(al);
        }
        
        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                orderDetail.pack();
                orderDetail.setLocationRelativeTo(null);
                orderDetail.setVisible(true);
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(adminPanel, "you need choose order first!");
                }
                else{
                    defaultTableModel2 = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int i, int i1) {
                        return false;
                    }
                    };
                    tblDetail.setModel(defaultTableModel2);
                     JTableHeader header = tblDetail.getTableHeader();
                    header.setBackground(Color.yellow);
                    header.setForeground(Color.blue);
                    header.setFont(new Font("Tahome", Font.BOLD, 13));
                    ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                    defaultTableModel2.addColumn("OrderId");
                    defaultTableModel2.addColumn("BookId");
                    defaultTableModel2.addColumn("Title");
                    defaultTableModel2.addColumn("Quantity");
                    defaultTableModel2.addColumn("Total");
                    setTabledetail(orderService.listDetail((long)table.getValueAt(row, 0)));
                }
                
            }
        });
        complete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int row = table.getSelectedRow();
               if(row == -1){
                   JOptionPane.showMessageDialog(adminPanel, "you need choose order first!");
               }
               else{
                   int confirm = JOptionPane.showConfirmDialog(adminPanel, "do you want to change status", "Message", JOptionPane.YES_NO_OPTION);
                   if(confirm == JOptionPane.YES_OPTION){
                       long orderId = (long)table.getValueAt(row, 0);
                       orderService.updateStatus(orderId);
                       setTabledata(orderService.listOrder());
                   }
               }
            }
        });
    }
    // Customer order
    public void setView() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        setLabelLayout(bookService.getAllbook());
        cbxOrderCategory.removeAllItems();
        cbxOrderCategory.addItem("All");
        for(Category category: categoryService.getAllcategory()){
            cbxOrderCategory.addItem(category.getName());
        }
    }

    public void setIconforShipingCart(JLabel label) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/uit/image/favorite_cart_200px.png"));
        Image image = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        label.setIcon(imageIcon);
    }

     public ImageIcon getIcon(String url, int w, int h){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }
     
    public void setLabelLayout(List<Book> list) {
        GridLayout gridLayout = new GridLayout(0, 3);
        gridLayout.setVgap(40);
        gridLayout.setHgap(30);
        panel.setLayout(gridLayout);
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#1B1464")));
        for (Book book : list) {
            JPanel labelPanel = new JPanel();
            JButton orderButton = new JButton();
            orderButton.setIcon(getIcon("/com/uit/image/icons8_create_order_80px.png", 20, 20));
            orderButton.setBackground(Color.white);
            orderButton.setFocusable(false);
            JLabel label = new JLabel("<html><center><b>" + "<font color=blue> " + book.getTitle() +"</font></b><br/><i>by " + book.getAuthor() + "</i>" + " <br/><b> " + 
                     book.getPrice() + " VND" + "</b></center>"+ "</html>");
            label.setFont(new Font("Serif", Font.PLAIN, 15));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            ImageIcon icon = new ImageIcon(book.getImage());
            Image image = icon.getImage();
            ImageIcon imageIcon = new ImageIcon(fitimage(image, 180, 210));
            label.setIcon(imageIcon);
            //add vo panel
            labelPanel.add(label);
            labelPanel.add(orderButton);
            labelPanel.setBackground(Color.white);
            panel.add(labelPanel);
            for(ActionListener al : orderButton.getActionListeners()){
                orderButton.removeActionListener(al);
            }
            orderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    lblNotice.setText("");
                    lblNotice.setIcon(null);
                    bookId = book.getBookId();
                    bookDetail.pack();
                    final Toolkit toolkit = Toolkit.getDefaultToolkit();
                    final Dimension screenSize = toolkit.getScreenSize();
                    final int x = (screenSize.width - bookDetail.getWidth()) / 2;
                    final int y = (screenSize.height - bookDetail.getHeight()) / 2;
                    bookDetail.setLocation(x, y);
                    //bookDetail.setLocationRelativeTo(null);
                    bookDetail.setVisible(true);
                    bookDetail.setSize(850, 600);
                    displayBook(book);
                }
            });
        }
    }

    public void displayBook(Book book) {
        lblTitle.setText(book.getTitle());
        lblAuthor.setText(book.getAuthor());
        lblPrice.setText(String.valueOf(book.getPrice()) + " VND");
        lblPublishdate.setText(String.valueOf(book.getPublishDate()));
        lblQuantity.setText("1");
        long count = 0;
        for(OrderDetail o :  book.getOrderDetails()){
            count += o.getQuantity();
        }
        lblStatus.setText(book.getCurQuantity() + " available products | " + count + " selled");
        lblStatus.setBorder(BorderFactory.createLineBorder(Color.red));
        lblDescription.setText("<html>" + book.getDescription() + "</html>");
        ImageIcon icon = new ImageIcon(book.getImage());
        Image image = icon.getImage();
        ImageIcon imageIcon = new ImageIcon(fitimage(image, lblImageorder.getWidth(), lblImageorder.getHeight()));
        lblImageorder.setIcon(imageIcon);
        
        //radio button
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        buttonGroup.add(rb3);
        buttonGroup.add(rb4);
        buttonGroup.add(rb5);
        rb1.setIcon(getIcon("/com/uit/image/star.png", 15, 15));
        rb2.setIcon(getIcon("/com/uit/image/star.png", 15, 15));
        rb3.setIcon(getIcon("/com/uit/image/star.png", 15, 15));
        rb4.setIcon(getIcon("/com/uit/image/star.png", 15, 15));
        rb5.setIcon(getIcon("/com/uit/image/star.png", 15, 15));
        
        //
        rb1.setActionCommand("1");
        rb2.setActionCommand("2");
        rb3.setActionCommand("3");
        rb4.setActionCommand("4");
        rb5.setActionCommand("5");
        
        //custom
        btnSend.setBackground(Color.white);
        txtComment.setText("Write your comment! < 150 characters");
        txtComment.setForeground(Color.gray);

        //panel Commnet
        setViewCommentPanel(book);
        //action
        for(ActionListener al : btnSend.getActionListeners()){
            btnSend.removeActionListener(al);
        }
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtComment.getText().equals("") || txtComment.getText().equals("Write your comment! < 150 characters")){
                    JOptionPane.showMessageDialog(bookDetail, "Input not enough information!");
                }
                else{
                    Review review = new Review();
                    review.setBook(book);
                    review.setCustomer(LoginFrame.customer);
                    review.setHeadline(txtComment.getText());
                    review.setRating(Integer.valueOf(buttonGroup.getSelection().getActionCommand()));
                    review.setReviewTime(new java.util.Date());
                    reviewService.addReview(review);
                    setViewCommentPanel(book);
                    txtComment.setText("Write your comment! < 150 characters");
                    txtComment.setForeground(Color.gray);
                }
            }
        });

    }

    public void setViewCommentPanel(Book book){
        commentPanel.removeAll();
        commentPanel.repaint();
        commentPanel.revalidate();
        GridLayout gridLayout = new GridLayout(0, 1);
        commentPanel.setLayout(gridLayout);
        commentPanel.setBackground(Color.white);
        
        for(Review review : reviewService.listAllreviewbyBookId(book.getBookId())){
            JPanel cpanel = new JPanel();
            cpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel comment = new JLabel(getIcon("/com/uit/image/icons8_customer_128px.png", 35, 35));
            comment.setText("<html>" +review.getCustomer().getFullName().toUpperCase()+ "<br>" + review.getHeadline() + "----" + review.getReviewTime()+ "</html>");
            JLabel rating = new JLabel(getIcon("/com/uit/image/star.png", 15, 15));
            rating.setText(String.valueOf(review.getRating()));
            rating.setBorder(BorderFactory.createLineBorder(Color.decode("#f1c40f")));
            //JLabel reviewTime = new JLabel(String.valueOf(review.getReviewTime()));
            cpanel.setBackground(Color.decode("#fd79a8"));
            cpanel.setBorder(BorderFactory.createLineBorder(Color.decode("#ecf0f1")));
            //cpanel.setSize(60, 60);
            cpanel.add(comment);
            cpanel.add(rating);
            //cpanel.add(reviewTime);
            commentPanel.add(cpanel);
        }
    }
    public Image fitimage(Image img, int w, int h) {
        BufferedImage resizedimage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizedimage;
    }

    public void actions() {
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                panel.removeAll();
                panel.repaint();
                panel.revalidate();
                setLabelLayout(bookService.findBook(txtSearch.getText()));
            }

        });
        
        cbxOrderCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.removeAll();
                panel.repaint();
                panel.revalidate();
                setLabelLayout(bookService.findBookbyCategory(String.valueOf(cbxOrderCategory.getSelectedItem())));
            }
        });
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int number = Integer.valueOf(lblQuantity.getText());
                for(Book book: bookService.getAllbook()){
                    if(book.getBookId() == bookId && book.getCurQuantity() == number ){
                        //JOptionPane.showMessageDialog(panel, "cannot enough products!");
                        lblQuantity.setText(String.valueOf(number));
                        return;
                    }
                }
               
                lblQuantity.setText(String.valueOf(number + 1));
            }
        });

        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int number = Integer.valueOf(lblQuantity.getText());
                if (number > 1) {
                    lblQuantity.setText(String.valueOf(number - 1));
                }
            }
        });
        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (Book book : bookService.getAllbook()) {
                    if (book.getBookId() == bookId) {
                        listBook.put(book, Integer.valueOf(lblQuantity.getText()));
                        bookDetail.setVisible(false);
                        ImageIcon icon = new ImageIcon(getClass().getResource("/com/uit/image/icons8_ok_96px.png"));
                        Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                        lblNotice.setIcon(new ImageIcon(image));
                        lblNotice.setText("Book already add to cart!"); 
                        System.out.println(book.getTitle());
                    }
                }
            }
        });
       txtComment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
               txtComment.setText("");
               txtComment.setForeground(Color.black);
            }
        });
    }
    
    
}
