package com.Nullton.ShopAggregator.AmazonParser;

import com.Nullton.ShopAggregator.HttpConnection;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AmazonHttpConnection extends HttpConnection {
    @Override
    protected String loadProducts(String URL) throws IOException {
        return super.loadProducts(URL);
    }
}
