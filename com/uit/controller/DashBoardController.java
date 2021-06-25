/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Book;
import com.uit.service.BookService;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vunguyen
 */
public class DashBoardController {
    private javax.swing.JPanel preferPanel;
    private javax.swing.JPanel recommendPanel;
    private BookService bookService;
     //DashBoard
    public DashBoardController(JPanel preferPanel, JPanel recommendPanel){
        this.recommendPanel = recommendPanel;
        this.preferPanel = preferPanel;
        bookService = new BookService();
    }
    
    public void showDashBoard(){
        GridLayout gridLayout = new GridLayout(0, 4);
        preferPanel.setLayout(gridLayout);
        recommendPanel.setLayout(gridLayout);
        gridLayout.setHgap(40);
        
        preferPanel.setBackground(Color.white);
        recommendPanel.setBackground(Color.white);
        
        preferPanel.removeAll();
        preferPanel.repaint();
        preferPanel.revalidate();
        
        recommendPanel.removeAll();
        recommendPanel.repaint();
        recommendPanel.revalidate();
        
        //fill preferPanel
        for(Book book : bookService.bestSellerBook()){
            JLabel label = new JLabel("<html><center><b>" + "<font color=blue> " + book.getTitle() +"</font></b><br/><i>by " + book.getAuthor()  + "</i><br/><b> " + 
                     book.getPrice() + " VND" + "</b></center>"+ "</html>");
            label.setFont(new Font("Serif", Font.PLAIN, 15));            
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
//            JLabel test = new JLabel(getIcon("/com/uit/image/star.png", 20, 20));
//            test.setText("5");
            ImageIcon icon = new ImageIcon(book.getImage());
            Image image = icon.getImage();
            ImageIcon imageIcon = new ImageIcon(fitimage(image, 180, 210));
            label.setIcon(imageIcon);
            preferPanel.add(label);
        }
        
        //fill recommnedPanel
        
        for(Book book : bookService.recommendBook()){
            JLabel label = new JLabel("<html><center><b>" + "<font color=blue> " + book.getTitle() +"</font></b><br/><i>by " + book.getAuthor()  + "</i><br/><b> " + 
                     book.getPrice() + " VND" + "</b></center>"+ "</html>");
            label.setFont(new Font("Serif", Font.PLAIN, 15));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            ImageIcon icon = new ImageIcon(book.getImage());
            Image image = icon.getImage();
            ImageIcon imageIcon = new ImageIcon(fitimage(image, 180, 210));
            label.setIcon(imageIcon);
            recommendPanel.add(label);
        }
        
    }
    
    public ImageIcon getIcon(String url, int w, int h){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }
    
    public Image fitimage(Image img , int w , int h){
        BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0,w,h,null);
        g2.dispose();
        return resizedimage;
    }
}
