package com.app.wishlist.service;

import com.app.wishlist.dao.UserDao;
import com.app.wishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(int userId) {
        return userDao.findById(userId);
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public boolean add(User user) {
        return userDao.add(user);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean disableUser(String email) {
        return userDao.disableUser(email);
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public User findByIdAndName(int idUser, String name) {
        return userDao.findByIdAndName(idUser, name);
    }
}
