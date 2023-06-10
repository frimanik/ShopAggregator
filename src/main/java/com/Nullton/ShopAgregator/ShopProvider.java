package com.Nullton.ShopAgregator;

import java.util.List;
import java.util.Map;

public class ShopProvider {
   static List<FetchData> provider;

    static public void Add(FetchData entity){
       provider.add(entity);
    }
}
