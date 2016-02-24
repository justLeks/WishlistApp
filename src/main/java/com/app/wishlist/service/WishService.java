package com.app.wishlist.service;

import com.app.wishlist.dao.WishDao;
import com.app.wishlist.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {

    @Autowired
    private WishDao wishDao;

    public List<Wish> findAll() {
        return wishDao.findAll();
    }

    public List<Wish> findByUserId(int idUser) {
        return wishDao.findByUserId(idUser);
    }

    public boolean add(Wish wish) {
        return wishDao.add(wish);
    }

    public boolean update(Wish wish) {
        return wishDao.update(wish);
    }

    public Wish findByWishId(int idWish) {
        return wishDao.findByWishId(idWish);
    }
}
