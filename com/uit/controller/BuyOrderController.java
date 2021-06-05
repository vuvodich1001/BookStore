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
import java.awt.GridBagLayout;
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
       GridBagLayout layout = new GridBagLayout();
      
      for(Map.Entry<Book, Integer> m : list.entrySet()){
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(m.getKey().getTitle() + " by " + m.getKey().getAuthor() + " " + m.getKey().getPrice() + " VND");
            //label.setHorizontalAlignment(JLabel.CENTER);
            //label.setHorizontalTextPosition(JLabel.RIGHT);
           // label.setVerticalTextPosition(JLabel.RIGHT);
            ImageIcon icon = new ImageIcon(m.getKey().getImage());
            Image image = icon.getImage();
            ImageIcon imageIcon = new ImageIcon(fitimage(image, 100, 130));
            label.setIcon(imageIcon);
            JLabel label1 = new JLabel(String.valueOf(m.getValue()));
            JLabel label2 = new JLabel("#" + m.getKey().getBookId());
            JButton plus = new JButton("+");
            plus.setBackground(Color.WHITE);
            JButton minus = new JButton("-");
            minus.setBackground(Color.WHITE);
            JButton delete =  new JButton("X");
            actionforinsidePanel(delete, plus, minus, label1, label2);
            delete.setBackground(Color.WHITE);
            delete.setForeground(Color.RED);
            panel.add(label2);
            panel.add(delete);
            panel.add(label);
            panel.add(minus);
            panel.add(label1);
            panel.add(plus);
            panel.setBorder(BorderFactory.createLineBorder(Color.decode("#1B1464")));
            panel.setBackground(Color.WHITE);
            displayPanel.add(panel);
            sum += m.getKey().getPrice() * m.getValue();
       }
       title1.setText(String.valueOf(sum) + " VND");
    }
    public void actionforinsidePanel(JButton delete, JButton plus, JButton minus, JLabel label1, JLabel label2){
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int bookId = Integer.valueOf(label2.getText().substring(1));
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
               int number = Integer.valueOf(label1.getText());
               label1.setText(String.valueOf(number + 1));
               for(Map.Entry<Book, Integer> map : list.entrySet()){
                   if(Integer.valueOf(label2.getText().substring(1)) == map.getKey().getBookId()){
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
               int number = Integer.valueOf(label1.getText());
                if(number > 1){
                    label1.setText(String.valueOf(number - 1));
                    for(Map.Entry<Book, Integer> map : list.entrySet()){
                    if(Integer.valueOf(label2.getText().substring(1)) == map.getKey().getBookId()){
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
