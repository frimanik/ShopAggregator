package com.Nullton.ShopAggregator;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class ShopAggregator {
    private final ShopProvider provider;
    private final CurrencyExchangeRateService exchangeRateService;

    public ShopAggregator(ShopProvider provider, CurrencyExchangeRateService exchangeRateService) {
        this.provider = provider;
        this.exchangeRateService = exchangeRateService;
    }

    public List<ProductEntity> searchCheapest(String toCurrency, String product, int quantity) throws IOException {
        HashMap<String, BigDecimal> curToUsd = new HashMap<>();
        List<ProductEntity> assumedResult = new ArrayList<>();

        for (DataFetcher shop : provider.providerList) {
            assumedResult.addAll(shop.Fetch(product, quantity));
        }

        for (ProductEntity pr : assumedResult) {
            if (!curToUsd.containsKey(pr.getCurrency())) {
                    curToUsd.put(pr.getCurrency(), exchangeRateService.getExhangeRate(pr.getCurrency(),toCurrency));
            }
                pr.setNotionalPrice(curToUsd.get(pr.getCurrency()).multiply(pr.getPrice()));
        }

        assumedResult.sort(Comparator.comparing(ProductEntity::getNotionalPrice));
        for (ProductEntity pr : assumedResult) {
            System.out.println(pr.getTitle() + ":" + pr.getNotionalPrice() + pr.getShop().toUpperCase());
        }

        return assumedResult;
    }
}