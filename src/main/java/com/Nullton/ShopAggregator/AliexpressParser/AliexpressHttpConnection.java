package com.Nullton.ShopAggregator.AliexpressParser;

import com.Nullton.ShopAggregator.HttpConnection;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AliexpressHttpConnection  extends HttpConnection {

    @Override
    public String loadProducts(String URL) throws IOException {
        return super.loadProducts(URL);
    }
}