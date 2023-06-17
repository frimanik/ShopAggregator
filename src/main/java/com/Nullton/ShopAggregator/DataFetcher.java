package com.Nullton.ShopAggregator;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface DataFetcher {
    /*Classes implementing this method *MUST* return items sorted by price */
    List<ProductEntity> Fetch(String product, int quantity) throws IOException;
}
