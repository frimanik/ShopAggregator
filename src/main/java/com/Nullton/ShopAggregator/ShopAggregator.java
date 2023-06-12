package com.Nullton.ShopAggregator;

import java.io.IOException;
import java.util.*;

public class ShopAggregator {
    private ShopProvider provider;

    public ShopAggregator(ShopProvider provider) {
        this.provider = provider;
    }

    public List<ProductEntity> searchCheapest(String product, int quantity) throws IOException {
       List<ProductEntity> assumedResult = new ArrayList<>();
        for (DataFetcher shop : provider.providerList) {
            assumedResult.addAll(shop.Fetch(product, quantity));
        }

        assumedResult.sort(Comparator.comparing(ProductEntity::getPrice));
        for (ProductEntity pr : assumedResult){
            System.out.println(pr.getTitle()+":"+pr.getPrice()+pr.getShop().toUpperCase());
        }
        return assumedResult;
    }
}