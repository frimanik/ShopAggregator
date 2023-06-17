package com.Nullton.ShopAggregator.LazadaParser;

import com.Nullton.ShopAggregator.HttpConnection;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class LazadaHttpConnection extends HttpConnection {
    @Override
    protected String loadProducts(String URL) throws IOException {
        return super.loadProducts(URL);
    }
}
