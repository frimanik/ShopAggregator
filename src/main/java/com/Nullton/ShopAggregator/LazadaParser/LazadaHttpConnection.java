package com.Nullton.ShopAggregator.LazadaParser;

import com.Nullton.ShopAggregator.HttpConnection;

import java.io.IOException;

public class LazadaHttpConnection extends HttpConnection {
    @Override
    protected String loadProducts(String URL) throws IOException {
        return super.loadProducts(URL);
    }
}
