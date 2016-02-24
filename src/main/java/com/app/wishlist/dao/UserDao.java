package com.app.wishlist.dao;

import com.app.wishlist.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findByEmail(String email);

    User findById(int idUser);

    boolean add(User user);

    boolean update(User user);

    boolean disableUser(String email);

    User findByName(String name);

    User findByIdAndName(int idUser, String name);
}
