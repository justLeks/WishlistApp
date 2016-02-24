package com.app.wishlist.dao;

import com.app.wishlist.model.Item;

import java.util.List;

public interface ItemDao {
    List<Item> findAll();

    Item findById(int idItem);

    Item findByName(String name);

    boolean add(Item item);

    boolean update(Item item);
}
