package com.Nullton.ShopAggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ShopAggregatorController {

    @Autowired
    private ShopAggregator aggregator;
    @GetMapping("/items")
    public ResponseEntity getItems(@RequestParam(value = "item") String searchRequest, @RequestParam(value = "quantity") int quantity){
        System.out.println("insideController");
        try {
            System.out.println("method here");
            return new ResponseEntity(aggregator.searchCheapest("PHP",searchRequest,quantity), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
