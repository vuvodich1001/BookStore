/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.UserDao;
import com.uit.entity.Usr;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class UserService {
    UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    
    public List<Usr> getAlluser(){
       return userDao.getAlluser();
    }
    
    public void addUser(Usr usr){
        userDao.addUser(usr);
    }
    
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
    
    public void editUser(Usr usr){
        userDao.editUser(usr);
    }
    
    public boolean check(String username, String password){
        return userDao.check(username, password);
    }
    
    public boolean checkEmail(String email){
        return userDao.checkEmail(email);
    }
    
    public List<Usr> findUser(String username){
        return userDao.findUser(username);
    }
}
