package com.app.wishlist.controller;

import com.app.wishlist.model.Item;
import com.app.wishlist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsRestController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/items/", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> listOfAllItems() {
        List<Item> users = itemService.findAll();

        if (users.isEmpty()) {
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Item>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/items/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItemByName(@PathVariable String name) {
        Item item = itemService.findByName(name);

        if (item == null) {
            return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @RequestMapping(value = "/items/id/{idItem}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItemById(@PathVariable int idItem) {
        Item item = itemService.findById(idItem);

        if (item == null) {
            return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @RequestMapping(value = "/items/", method = RequestMethod.POST)
    public ResponseEntity<Void> addItem(@RequestBody Item item) {

        itemService.add(item);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
