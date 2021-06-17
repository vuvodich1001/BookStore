/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.SupplierDao;
import com.uit.entity.Supplier;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class SupplierService {
    SupplierDao supplierDao;
    
     public SupplierService(){
         supplierDao = new SupplierDao();
     }
     
     public List<Supplier> getAllsupplier(){
         return supplierDao.getAllsupplier();
     }
     
     public void addSupplier(Supplier supplier){
         supplierDao.addSupplier(supplier);
     }
     
     public void deleteSupplier(long id){
         supplierDao.deleteSupplier(id);
     }
}
