package com.app.wishlist.dao;

import com.app.wishlist.model.Present;

import java.util.List;

public interface PresentDao {
    List<Present> findAll();

    List<Present> findByWishId(int idwish);

    List<Present> findByUserId(int iduser);

    Present findByWishIdAndUserId(int idWish, int idUser);

    boolean add(Present present);

    boolean delete(int idWish, int idUser);

}
