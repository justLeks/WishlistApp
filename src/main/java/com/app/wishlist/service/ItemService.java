package com.app.wishlist.service;

import com.app.wishlist.dao.ItemDao;
import com.app.wishlist.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public List<Item> findAll() {
        return itemDao.findAll();
    }

    public Item findById(int idItem) {
        return itemDao.findById(idItem);
    }

    public Item findByName(String name) {
        return itemDao.findByName(name);
    }

    public boolean add(Item item) {
        return itemDao.add(item);
    }

    public boolean update(Item item) {
        return itemDao.update(item);
    }
}
