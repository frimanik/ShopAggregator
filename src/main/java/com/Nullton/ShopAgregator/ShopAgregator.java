package com.Nullton.ShopAgregator;

import com.Nullton.ShopAgregator.AliexpressParser.AliexpressEntity;
import com.Nullton.ShopAgregator.AliexpressParser.AliexpressParser;

import java.io.IOException;
import java.util.Map;

public class ShopAgregator {
    public void returnCheapest() throws IOException {
     ShopAgregator shopAgregator = new ShopAgregator();
     shopAgregator.searchCheapest("fridge",1);
    }

    private Map<String, AliexpressEntity> searchCheapest(String product, int quantity) throws IOException {
        AliexpressParser aliexpressParser = new AliexpressParser();
        return aliexpressParser.Parse(product,quantity,"https://www.aliexpress.com",0);
    }
}