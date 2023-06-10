package com.Nullton.ShopAgregator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShopAgregator {
    private ShopProvider provider;

    public ShopAgregator(ShopProvider provider) {
        this.provider = provider;
    }

    public Map<String, ProductEntity> searchCheapest(String product, int quantity) throws IOException {
        Map<String, ProductEntity> assumedResult = new HashMap<>();
        for (DataFetcher shop : provider.providerList) {
            assumedResult = shop.Fetch(product, quantity);
        }
        //assumedResult.someKindOfSort;
        return assumedResult;
    }
}