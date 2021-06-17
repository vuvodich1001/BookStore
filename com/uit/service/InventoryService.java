/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.InventoryDao;
import com.uit.entity.InventoryTracking;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class InventoryService {

    InventoryDao inventoryDao;

    public InventoryService() {
        inventoryDao = new InventoryDao();
    }

    public List<InventoryTracking> getAllinventory() {
        return inventoryDao.getAllinventory();
    }

    public void addInventory(InventoryTracking inventoryTracking) {
        inventoryDao.addInventory(inventoryTracking);
    }
}
