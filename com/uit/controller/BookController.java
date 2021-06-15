/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.controller;

import com.toedter.calendar.JDateChooser;
import com.uit.entity.Book;
import com.uit.entity.Category;
import com.uit.service.BookService;
import com.uit.service.CategoryService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
public class BookController {

    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtPrice;
    private com.toedter.calendar.JDateChooser txtPublishDate;
    private javax.swing.JTextField txtSearchall;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JComboBox<Category> cbxCategory;
    private javax.swing.JLabel lblImage;
    private javax.swing.JButton btnSubmitBook;
    private javax.swing.JButton btnUpload;
    private javax.swing.JTable table;
    private javax.swing.JButton btnAddall;
    private javax.swing.JButton btnBook;
    private JPopupMenu menuBook;
    private JMenuItem deleteBook;
    private JMenuItem modifyBook;
    private JDialog addupdateBook;
    private DefaultTableModel defaultTableModel;
    private Book book;
    private BookService bookService;
    private javax.swing.JPanel panel;
    private CategoryService categoryService;
    private File file;

    public BookController() {
    }

    public BookController(JTextField txtAuthor, JTextField txtPrice, JTextField txtIsbn, JDateChooser txtPublishDate,
            JTextField txtSearchall, JTextField txtTitle, JComboBox<Category> cbxCategroy, JLabel lblImage, JButton btnSubmitBook, JButton btnBook, JButton btnUpload,
            JButton btnAddall, JTable table, JPanel panel, JDialog addupdateBook) {
        this.txtAuthor = txtAuthor;
        this.txtIsbn = txtIsbn;
        this.txtPrice = txtPrice;
        this.txtPublishDate = txtPublishDate;
        this.txtSearchall = txtSearchall;
        this.txtTitle = txtTitle;
        this.btnSubmitBook = btnSubmitBook;
        this.btnBook = btnBook;
        this.btnUpload = btnUpload;
        this.btnAddall = btnAddall;
        this.table = table;
        this.cbxCategory = cbxCategroy;
        this.lblImage = lblImage;
        this.panel = panel;
        this.addupdateBook = addupdateBook;
        book = new Book();
        bookService = new BookService();
        categoryService = new CategoryService();
        menuBook = new JPopupMenu();
        deleteBook = new JMenuItem();
        modifyBook = new JMenuItem();
        file = new File("");
    }

    public void listBook() {
        initMenuItem(menuBook, deleteBook, modifyBook);
        table.setComponentPopupMenu(menuBook);

        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.yellow);
        header.setForeground(Color.blue);
        header.setFont(new Font("Tahome", Font.BOLD, 13));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("book_id");
        defaultTableModel.addColumn("category_id");
        defaultTableModel.addColumn("title");
        defaultTableModel.addColumn("author");
        defaultTableModel.addColumn("image");
        defaultTableModel.addColumn("isbn");
        defaultTableModel.addColumn("price");
        defaultTableModel.addColumn("publish_date");

        setTabledata(bookService.getAllbook());
        table.setRowHeight(130);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(4).setCellRenderer(new ImageRender());
    }

    public void setTabledata(List<Book> list) {
        cbxCategory.removeAllItems();
        for (Category c : categoryService.getAllcategory()) {
            cbxCategory.addItem(c);
        }
        defaultTableModel.setRowCount(0);
        for (Book b : list) {
            defaultTableModel.addRow(new Object[]{b.getBookId(), b.getCategory().getCategoryId(),
                b.getTitle(), b.getAuthor(), b.getImage(), b.getIsbn(), b.getPrice(), b.getPublishDate()});
        }
    }

    public void initMenuItem(JPopupMenu menu, JMenuItem delete, JMenuItem modify) {
        delete.setIcon(getIcon("/com/uit/image/icons8_delete_96px.png", 20, 20));
        delete.setText("delete");
        modify.setIcon(getIcon("/com/uit/image/icons8_edit_file_128px.png", 20, 20));
        modify.setText("modify");
        menu.add(delete);
        menu.add(modify);
    }

    public ImageIcon getIcon(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        Image image = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    public class ImageRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String photoName = value.toString();
            JLabel label = new JLabel();
            ImageIcon icon = new ImageIcon(photoName);
            Image image = icon.getImage();
            ImageIcon imageIcon = new ImageIcon(fitimage(image, 115, 130));
            return new JLabel(imageIcon);
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

    public Category findCategoryID(String string) {
        for (Category c : categoryService.getAllcategory()) {
            if (c.getName().equals(string)) {
                return c;
            }
        }
        return null;
    }

    public void setNull() {
        cbxCategory.setEnabled(true);
        cbxCategory.getModel().setSelectedItem("");
        lblImage.setIcon(null);
        txtAuthor.setText("");
        txtIsbn.setText("");
        txtPublishDate.setDate(null);
        txtPrice.setText("");
        lblImage.setText("");
        txtTitle.setText("");
    }

    private Category findCategoryID(long id) {
        for (Category c : categoryService.getAllcategory()) {
            if (c.getCategoryId() == id) {
                return c;
            }
        }
        return null;
    }

    public void actionAdd() {
        setNull();
        for (ActionListener al : btnSubmitBook.getActionListeners()) {
            btnSubmitBook.removeActionListener(al);
        }
        btnSubmitBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (String.valueOf(cbxCategory.getSelectedItem()).equals("") || txtTitle.getText().equals("") || txtAuthor.getText().equals("")
                        || txtIsbn.getText().equals("") || txtPrice.getText().equals("") || txtPublishDate.getDate().equals("")) {
                    JOptionPane.showMessageDialog(panel, "Input not enough information!");
                } else if (bookService.checkTitleAuthor(txtTitle.getText(), txtAuthor.getText())) {
                    JOptionPane.showMessageDialog(panel, "Title and author already existed!");
                } else {
                    book.setCategory((Category) cbxCategory.getSelectedItem());
                    book.setTitle(txtTitle.getText());
                    book.setAuthor(txtAuthor.getText());
                    book.setIsbn(txtIsbn.getText());
                    book.setImage(file.getAbsolutePath());
                    book.setPrice(Double.valueOf(txtPrice.getText()));
                    book.setPublishDate(txtPublishDate.getDate());
                    book.setLastUpdate(new java.util.Date());
                    bookService.addBook(book);
                    addupdateBook.dispose();
                    JOptionPane.showMessageDialog(panel, "Insert successfully!");
                    setTabledata(bookService.getAllbook());
                }
            }
        });

    }

    public void actionModify() {
        for (ActionListener al : btnSubmitBook.getActionListeners()) {
            btnSubmitBook.removeActionListener(al);
        }
        btnSubmitBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (String.valueOf(cbxCategory.getSelectedItem()).equals("") || txtTitle.getText().equals("") || txtAuthor.getText().equals("")
                        || txtIsbn.getText().equals("") || txtPrice.getText().equals("") || txtPublishDate.getDate().equals("")) {
                    JOptionPane.showMessageDialog(panel, "Input not enough information");
                } else {
                    //book.setCategory(findCategoryID((Long)table.getValueAt(row, 1)));
                    book.setTitle(txtTitle.getText());
                    book.setAuthor(txtAuthor.getText());
                    book.setPrice(Double.valueOf(txtPrice.getText()));
                    book.setImage(file.getAbsolutePath());
                    book.setIsbn(txtIsbn.getText());
                    book.setPublishDate(txtPublishDate.getDate());
                    bookService.editBook(book);
                    addupdateBook.dispose();
                    JOptionPane.showMessageDialog(panel, "update successfully!");
                    setTabledata(bookService.getAllbook());
                    setNull();
                }
            }
        });
    }

    public void actions() {
        btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listBook();
                for (ActionListener al : btnAddall.getActionListeners()) {
                    btnAddall.removeActionListener(al);
                }
                btnAddall.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        addupdateBook.pack();
                        addupdateBook.setLocationRelativeTo(null);
                        addupdateBook.setVisible(true);
                        actionAdd();
                    }
                });

                for (KeyListener kl : txtSearchall.getKeyListeners()) {
                    txtSearchall.removeKeyListener(kl);
                }

                txtSearchall.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent ke) {
                        setTabledata(bookService.findBook(txtSearchall.getText()));
                    }
                });
            }
        });

        deleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(panel, "you need choose book first!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(panel, "Do you want to delete this book?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        int id = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
                        bookService.deleteBook(id);
                        setTabledata(bookService.getAllbook());
                        //setNull();
                    }
                }
            }
        });

        modifyBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(panel, "you need choose book first!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(panel, "do you want to modify this book!", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        book.setBookId(Long.valueOf(String.valueOf(table.getValueAt(row, 0))));
                        book.setCategory(findCategoryID((Long) table.getValueAt(row, 1)));
                        book.setImage(String.valueOf(table.getValueAt(row, 4)));
                        cbxCategory.getModel().setSelectedItem(findCategoryID((long) table.getValueAt(row, 1)));
                        cbxCategory.setEnabled(false);
                        //set data for jtextfield
                        txtTitle.setText(String.valueOf(table.getValueAt(row, 2)));
                        txtAuthor.setText(String.valueOf(table.getValueAt(row, 3)));
                        lblImage.setIcon(new ImageIcon(fitimage(new ImageIcon(String.valueOf(table.getValueAt(row, 4))).getImage(), 100, 130)));
                        txtPrice.setText(String.valueOf(table.getValueAt(row, 6)));
                        txtIsbn.setText(String.valueOf(table.getValueAt(row, 5)));
                        txtPublishDate.setDate(Date.valueOf(String.valueOf(table.getValueAt(row, 7))));
                        addupdateBook.pack();
                        addupdateBook.setLocationRelativeTo(null);
                        addupdateBook.setVisible(true);
                        actionModify();
                    }
                }
            }
        });

        btnUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                //FileNameExtensionFilter imageFilter  = new FileNameExtensionFilter("");
                //fileChooser.setFileFilter(imageFilter);
                fileChooser.setMultiSelectionEnabled(false);
                int x = fileChooser.showDialog(panel, "chon file");
                if (x == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    Image image = icon.getImage();
                    ImageIcon imageIcon = new ImageIcon(fitimage(image, 100, 130));
                    lblImage.setIcon(imageIcon);

                }
            }
        });
    }

}
