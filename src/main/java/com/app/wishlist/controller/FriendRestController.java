package com.app.wishlist.controller;

import com.app.wishlist.model.Friend;
import com.app.wishlist.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendRestController {

    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/friends/", method = RequestMethod.POST)
    public ResponseEntity<Void> addFriend(@RequestBody Friend friend) {

        friendService.add(friend);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/friends/{id1}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> getFriendById1(@PathVariable int id1) {
        List<Integer> ids = friendService.findByEmail1(id1);

        if (ids == null) {
            return new ResponseEntity<List<Integer>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Integer>>(ids, HttpStatus.OK);
    }

}
