/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.uit.entity.Book;
import com.uit.view.BuyBookFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author vunguyen
 */
public class BuyOrderController {
    private JLabel title1;
    private JButton btnBuyproduct;
    private JButton btnClearOrder;
    private JPanel displayPanel;
    private Map<Book, Integer> list;
    public static double sum;

    public BuyOrderController(){
        
    }
    
    public BuyOrderController(JLabel title1,  JButton btnBuyproduct, JButton btnClearOrder, JPanel displayPanel, Map<Book, Integer> list ) {
        this.title1 = title1;
        this.btnBuyproduct = btnBuyproduct;
        this.btnClearOrder = btnClearOrder;
        this.displayPanel = displayPanel;
        this.list = list;
    }

    public void setView(){
       sum = 0;
       displayPanel.removeAll();
       displayPanel.repaint();
       displayPanel.revalidate();
       GridLayout gridLayout = new GridLayout(0,1);
       displayPanel.setLayout(gridLayout);
      for(Map.Entry<Book, Integer> m : list.entrySet()){
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(m.getKey().getTitle() + " by " + m.getKey().getAuthor() + " " + m.getKey().getPrice() + " VND");
            ImageIcon icon = new ImageIcon(m.getKey().getImage());
            Image image = icon.getImage();
            ImageIcon imageIcon = new ImageIcon(fitimage(image, 100, 130));
            label.setIcon(imageIcon);
            
            JLabel lblNumber = new JLabel(String.valueOf(m.getValue()));
            JLabel lblBookId = new JLabel("#" + m.getKey().getBookId());
            JButton plus = new JButton("+");
            plus.setBackground(Color.WHITE);
            JButton minus = new JButton("-");
            minus.setBackground(Color.WHITE);
            JButton delete =  new JButton("X");
            //action
            actionforinsidePanel(delete, plus, minus, lblNumber, lblBookId);
            
            delete.setBackground(Color.WHITE);
            delete.setForeground(Color.RED);
            panel.add(lblBookId);
            panel.add(delete);
            panel.add(label);
            panel.add(minus);
            panel.add(lblNumber);
            panel.add(plus);
            panel.setBorder(BorderFactory.createLineBorder(Color.decode("#1B1464")));
            panel.setBackground(Color.WHITE);
            displayPanel.add(panel);
            sum += m.getKey().getPrice() * m.getValue();
       }
       title1.setText(String.valueOf(sum) + " VND");
    }
    public void actionforinsidePanel(JButton delete, JButton plus, JButton minus, JLabel lblNumber, JLabel lblBookId){
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int bookId = Integer.valueOf(lblBookId.getText().substring(1));
                Iterator<Book> iterator = list.keySet().iterator();
                while(iterator.hasNext()){
                    Book book = iterator.next();
                    if(book.getBookId() == bookId){
                        iterator.remove();
                    }
                }        
                setView();
            }
        });
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int number = Integer.valueOf(lblNumber.getText());
               lblNumber.setText(String.valueOf(number + 1));
               for(Map.Entry<Book, Integer> map : list.entrySet()){
                   if(Integer.valueOf(lblBookId.getText().substring(1)) == map.getKey().getBookId()){
                      map.setValue(number + 1);
                      sum += map.getKey().getPrice();
                      title1.setText(String.valueOf(sum) + " VND");
                   }     
               }
            }
        });
        
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int number = Integer.valueOf(lblNumber.getText());
                if(number > 1){
                    lblNumber.setText(String.valueOf(number - 1));
                    for(Map.Entry<Book, Integer> map : list.entrySet()){
                    if(Integer.valueOf(lblBookId.getText().substring(1)) == map.getKey().getBookId()){
                       map.setValue(number - 1);
                       sum -= map.getKey().getPrice();
                       title1.setText(String.valueOf(sum) + " VND");
                    }     
               }
                }
           
            }
        });
    }
    
    public void action(){
        btnBuyproduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               BuyBookFrame bbf = new BuyBookFrame();
               bbf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
               bbf.pack();
               bbf.setLocationRelativeTo(null);
               bbf.setVisible(true);
               System.out.println(list.toString());
            }
        });
        btnClearOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                list.clear();
                setView();
            }
        });
    }
    public Image fitimage(Image img, int w, int h) {
        BufferedImage resizedimage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizedimage;
    }
    
}
