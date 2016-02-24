package com.app.wishlist.controller;

import com.app.wishlist.model.Present;
import com.app.wishlist.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PresentRestController {

    @Autowired
    private PresentService presentService;

    @RequestMapping(value = "/presents/", method = RequestMethod.GET)
    public ResponseEntity<List<Present>> listOfAllPresents() {
        List<Present> presents = presentService.findAll();

        if (presents.isEmpty()) {
            return new ResponseEntity<List<Present>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Present>>(presents, HttpStatus.OK);
    }

    @RequestMapping(value = "/presents/userid/{iduser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Present>> listOfPresentsByUserId(@PathVariable int iduser) {
        List<Present> presents = presentService.findByUserId(iduser);

        if (presents.isEmpty()) {
            return new ResponseEntity<List<Present>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Present>>(presents, HttpStatus.OK);
    }

    @RequestMapping(value = "/presents/wishid/{idwish}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Present>> listOfPresentsByWishId(@PathVariable int idwish) {
        List<Present> presents = presentService.findByWishId(idwish);

        if (presents.isEmpty()) {
            return new ResponseEntity<List<Present>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Present>>(presents, HttpStatus.OK);
    }

    @RequestMapping(value = "/presents/", method = RequestMethod.POST)
    public ResponseEntity<Void> addPresent(@RequestBody Present present) {

        presentService.add(present);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
