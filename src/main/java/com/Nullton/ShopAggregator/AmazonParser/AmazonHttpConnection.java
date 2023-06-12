package com.Nullton.ShopAggregator.AmazonParser;

import com.Nullton.ShopAggregator.HttpConnection;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;

public class AmazonHttpConnection extends HttpConnection {
    @Override
    protected String LoadContent(String URL) throws IOException {
        return super.configureConnection(URL);
    }
}
