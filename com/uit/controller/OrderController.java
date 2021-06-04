/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Book;
import com.uit.service.BookService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author vunguyen
 */
public class OrderController {

    JPanel panel;
    BookService bookService;
    JTextField txtSearch;
    JDialog bookDetail;
    JLabel lblTitle;
    JLabel lblAuthor;
    JLabel lblPublishdate;
    JLabel lblImageorder;
    JLabel lblPrice;
    JButton btnPlus;
    JButton btnMinus;
    JButton btnBuy;
    JLabel lblQuantity;
    JLabel lblNotice;
    Map<Book, Integer> listBook;
    long bookId;
    public OrderController() {

    }
//       orderController = new OrderController(viewOrder, bookDetail, txtSearchBook, lblTitle, lblAuthor,
//         lblPublishdate, lblImageorder, lblPrice, btnPlus, btnMinus,lblQuantity);

    public OrderController(JPanel panel, JDialog bookDetail, JTextField txtSearch, JLabel lblTitle, JLabel lblAuthor,
            JLabel lblPublishdate, JLabel lblImageorder, JLabel lblPrice, JButton btnPlus, JButton btnMinus, JButton btnBuy, Map<Book, Integer> list,
            JLabel lblQuantity, JLabel lblNotice) {
        this.panel = panel;
        this.txtSearch = txtSearch;
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
        bookService = new BookService();
    }

    public OrderController(JPanel viewOrder, JDialog bookDetail, JTextField txtSearchBook, JLabel lblTitle, JLabel lblAuthor, JLabel lblPublishdate, JLabel lblImageorder, JLabel lblPrice, JButton btnPlus, JButton btnMinus, JButton btnBuy, JLabel lblQuantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setView() {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        setLabelLayout(bookService.getAllbook());
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
            JLabel label = new JLabel(book.getTitle() + " " + book.getPrice() + " VND");
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
            
            orderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    lblNotice.setText("");
                    lblNotice.setIcon(null);
                    bookId = book.getBookId();
                    bookDetail.pack();
                    //bookDetail.setLocationRelativeTo(panel);
                    final Toolkit toolkit = Toolkit.getDefaultToolkit();
                    final Dimension screenSize = toolkit.getScreenSize();
                    final int x = (screenSize.width - bookDetail.getWidth()) / 2;
                    final int y = (screenSize.height - bookDetail.getHeight()) / 2;
                    bookDetail.setLocation(x, y);
                    bookDetail.setVisible(true);
                    bookDetail.setSize(600, 480);
                    displayBook(book);
                }
            });
        }
    }

    public void displayBook(Book book) {
        lblTitle.setText(book.getTitle());
        lblAuthor.setText(book.getAuthor());
        lblPrice.setText(String.valueOf(book.getPrice()));
        lblPublishdate.setText(String.valueOf(book.getPublishDate()));
        lblQuantity.setText("1");
        ImageIcon icon = new ImageIcon(book.getImage());
        Image image = icon.getImage();
        ImageIcon imageIcon = new ImageIcon(fitimage(image, lblImageorder.getWidth(), lblImageorder.getHeight()));
        lblImageorder.setIcon(imageIcon);

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

        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int number = Integer.valueOf(lblQuantity.getText());
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
    }
}
