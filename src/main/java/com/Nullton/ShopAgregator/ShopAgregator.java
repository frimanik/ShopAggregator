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
        List<FetchData>fetchData = new LinkedList<>();
        Map<String,Entity>assumedResult = new HashMap<>();
        fetchData.add(new AliexpressParser());
        for (FetchData data:fetchData){
           assumedResult = data.Parse(product,quantity);
        }
        //assumedResult.someKindOfSort;
        return assumedResult;
    }
}