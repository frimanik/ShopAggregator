package com.Nullton.ShopAggregator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShopProvider {
    List<DataFetcher> providerList;

    public ShopProvider(){this.providerList = new ArrayList<>();}

    public void Add(DataFetcher entity){
       providerList.add(entity);
    }
}
