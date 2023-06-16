package com.Nullton.ShopAggregator;

import java.util.ArrayList;
import java.util.List;

public class ShopProvider {
    List<DataFetcher> providerList;

    public ShopProvider(){this.providerList = new ArrayList<>();}

    public void Add(DataFetcher entity){
       providerList.add(entity);
    }
}
