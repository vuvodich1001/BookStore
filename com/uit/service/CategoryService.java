/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.CategoryDao;
import com.uit.entity.Category;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class CategoryService {
    CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }
    
    public List<Category> getAllcategory(){
        return categoryDao.getAllcategory();
    }
    
    public void addCategory(Category c){
        categoryDao.addCategory(c);
    }
    
    public void deleteCategory(int id){
        categoryDao.deleteCategory(id);
    }
    
    public void editCategory(Category c){
        categoryDao.editCategory(c);
    }
    
    public List<Category> findCategory(String name){
        return categoryDao.findCategory(name);
    }
}
