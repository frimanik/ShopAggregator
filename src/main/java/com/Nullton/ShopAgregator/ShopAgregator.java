package com.Nullton.ShopAgregator;

import java.io.IOException;
import java.util.*;

public class ShopAgregator {
    private ShopProvider provider;

    public ShopAgregator(ShopProvider provider) {
        this.provider = provider;
    }

    public List<ProductEntity> searchCheapest(String product, int quantity) throws IOException {
       List<ProductEntity> assumedResult = new ArrayList<>();
        for (DataFetcher shop : provider.providerList) {
            assumedResult=shop.Fetch(product, quantity);
        }
        //assumedResult.someKindOfSort;
        return assumedResult;
    }
}