package com.app.wishlist.controller;

import com.app.wishlist.model.Wish;
import com.app.wishlist.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishRestController {

    @Autowired
    private WishService wishService;

    @RequestMapping(value = "/wishes/", method = RequestMethod.GET)
    public ResponseEntity<List<Wish>> findAll() {
        List<Wish> wishes = wishService.findAll();

        if (wishes.isEmpty()) {
            return new ResponseEntity<List<Wish>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Wish>>(wishes, HttpStatus.OK);
    }

    @RequestMapping(value = "/wishes/userid/{idUser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Wish>> getWishByUserId(@PathVariable int idUser) {
        List<Wish> wishes = wishService.findByUserId(idUser);

        if (wishes.isEmpty()) {
            return new ResponseEntity<List<Wish>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Wish>>(wishes, HttpStatus.OK);
    }

    @RequestMapping(value = "/wishes/wishid/{idWish}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Wish> getWishByWishId(@PathVariable int idWish) {
        Wish wish = wishService.findByWishId(idWish);

        if (wish == null) {
            return new ResponseEntity<Wish>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Wish>(wish, HttpStatus.OK);
    }

    @RequestMapping(value = "/wishes/", method = RequestMethod.POST)
    public ResponseEntity<Void> addWish(@RequestBody Wish wish) {

        wishService.add(wish);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/wishes/{idwish}", method = RequestMethod.PUT)
    public ResponseEntity<Wish> updateWish(@PathVariable int idwish, @RequestBody Wish wish) {
        Wish currentWish = wishService.findByWishId(idwish);

        if (currentWish == null) {
            return new ResponseEntity<Wish>(HttpStatus.NOT_FOUND);
        }

        currentWish.setIdUser(wish.getIdUser());
        currentWish.setIdItem(wish.getIdItem());
        currentWish.setFinalPrice(wish.getFinalPrice());

        wishService.update(currentWish);

        return new ResponseEntity<Wish>(currentWish, HttpStatus.OK);
    }
}
