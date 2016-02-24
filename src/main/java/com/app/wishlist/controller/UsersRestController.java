package com.app.wishlist.controller;

import com.app.wishlist.model.User;
import com.app.wishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listOfAllUsers() {
        List<User> users = userService.findAll();

        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{iduser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable int iduser) {
        User user = userService.findById(iduser);

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user) {

        userService.add(user);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
