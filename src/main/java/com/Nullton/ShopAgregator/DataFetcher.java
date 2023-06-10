package com.Nullton.ShopAgregator;

import java.io.IOException;
import java.util.Map;

public interface DataFetcher {
    Map<String, ProductEntity> Fetch(String product, int quantity) throws IOException;
}
