package com.Nullton.ShopAgregator;

import java.io.IOException;
import java.util.List;


public interface DataFetcher {
    List<ProductEntity> Fetch(String product, int quantity) throws IOException;
}
