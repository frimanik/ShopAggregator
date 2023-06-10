package com.Nullton.ShopAgregator;

import java.io.IOException;
import java.util.List;

public interface DataFetcher {
    /*Classes implementing this method *MUST* return items sorted by price */
    List<ProductEntity> Fetch(String product, int quantity) throws IOException;
}
