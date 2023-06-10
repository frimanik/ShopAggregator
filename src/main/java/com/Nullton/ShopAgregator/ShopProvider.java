package com.Nullton.ShopAgregator;

import java.util.List;

public class ShopProvider {
    List<DataFetcher> providerList;

    public ShopProvider(List<DataFetcher> providerList) {
        this.providerList = providerList;
    }

    public void Add(DataFetcher entity){
       providerList.add(entity);
    }
}
