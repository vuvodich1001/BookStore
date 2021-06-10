/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Book;
import com.uit.service.BookService;
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
        GridLayout gridLayout = new GridLayout(0, 3);
        preferPanel.setLayout(gridLayout);
        gridLayout.setHgap(30);
        for(Book b : bookService.mostBook()){
            JLabel label = new JLabel(b.getTitle() + " " + b.getPrice() + " VND");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            ImageIcon icon = new ImageIcon(b.getImage());
            Image image = icon.getImage();
            ImageIcon imageIcon = new ImageIcon(fitimage(image, 180, 210));
            label.setIcon(imageIcon);
            preferPanel.add(label);
        }
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
