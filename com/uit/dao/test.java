/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.dao;

import com.uit.entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vunguyen
 */
public class test {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public List<Category> getAllcategory(){
        List<Category> list =  entityManager.createQuery("from Category").getResultList();
        return list;
    }
    public static void main(String[] args){
        for(Category c : new test().getAllcategory()){
            System.out.println(c.getName());
        }
    }
}
