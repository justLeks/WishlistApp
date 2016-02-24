package com.app.wishlist.service;

import com.app.wishlist.dao.FriendDao;
import com.app.wishlist.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    public boolean add(Friend friend) {
        return friendDao.add(friend);
    }

    public List<Integer> findByEmail1(int id1) {
        return friendDao.findById1(id1);
    }
}
