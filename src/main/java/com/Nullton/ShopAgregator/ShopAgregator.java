package com.Nullton.ShopAgregator;

import com.Nullton.ShopAgregator.AliexpressParser.AliexpressParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShopAgregator {
    public void returnCheapest() throws IOException {
     ShopAgregator shopAgregator = new ShopAgregator();
     shopAgregator.searchCheapest("fridge",1);
    }

    private Map<String, Entity> searchCheapest(String product, int quantity) throws IOException {

        Map<String,Entity>assumedResult = new HashMap<>();
        for (FetchData shop:ShopProvider.provider){
          assumedResult =  shop.Parse(product,quantity);
        }
        //assumedResult.someKindOfSort;
        return assumedResult;
    }
}