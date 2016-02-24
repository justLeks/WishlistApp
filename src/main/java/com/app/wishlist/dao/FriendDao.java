package com.app.wishlist.dao;

import com.app.wishlist.model.Friend;

import java.util.List;

public interface FriendDao {
    boolean add(Friend friend);

    List<Integer> findById1(int id1);
}
