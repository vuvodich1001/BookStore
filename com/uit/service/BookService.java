/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.BookDao;
import com.uit.entity.Book;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class BookService {

    BookDao bookDao;

    public BookService() {
        bookDao = new BookDao();
    }

    public List<Book> getAllbook() {
        return bookDao.getAllbook();
    }

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    public void editBook(Book book) {
        bookDao.editBook(book);
    }

    public List<Book> findBook(String title) {
        return bookDao.findBook(title);
    }

    public List<Book> findBookbyCategory(String name) {
        return bookDao.findBookbyCategory(name);
    }

    public List<Book> mostBook() {
        return bookDao.mostBook();
    }

    public List<Book> bestSellerBook() {
        return bookDao.bestSellerBook();
    }

    public List<Book> recommendBook() {
        return bookDao.recommendBook();
    }

    public boolean checkTitleAuthor(String title, String author) {
        return bookDao.checkTitleAuthor(title, author);
    }
    
    public long quantityStatistic(String name){
        return bookDao.quantityStatistic(name);
    }
}
