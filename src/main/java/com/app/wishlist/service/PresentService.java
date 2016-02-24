package com.app.wishlist.service;

import com.app.wishlist.dao.PresentDao;
import com.app.wishlist.model.Present;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentService {

    @Autowired
    private PresentDao presentDao;

    public List<Present> findAll() {
        return presentDao.findAll();
    }

    public List<Present> findByWishId(int idwish) {
        return presentDao.findByWishId(idwish);
    }

    public List<Present> findByUserId(int iduser) {
        return presentDao.findByUserId(iduser);
    }

    public Present findByWishIdAndUserId(int idWish, int idUser) {
        return presentDao.findByWishIdAndUserId(idWish, idUser);
    }

    public boolean add(Present present) {
        return presentDao.add(present);
    }

    public boolean delete(int idWish, int idUser) {
        return presentDao.delete(idWish, idUser);
    }
}
