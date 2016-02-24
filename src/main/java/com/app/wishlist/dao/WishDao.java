package com.app.wishlist.dao;

import com.app.wishlist.model.Wish;

import java.util.List;

public interface WishDao {
    List<Wish> findAll();

    List<Wish> findByUserId(int idUser);

    Wish findByWishId(int idWish);

    boolean add(Wish wish);

    boolean update(Wish wish);

}
