package com.app.wishlist.dao;

import com.app.wishlist.model.Present;

import java.util.List;

public interface PresentDao {
    List<Present> findAll();

    List<Present> findByWishId(int idwish);

    List<Present> findByUserId(int iduser);

    boolean add(Present present);
}
