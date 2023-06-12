package com.Nullton.ShopAggregator.AliexpressParser;

import com.Nullton.ShopAggregator.HttpConnection;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;

public class AliexpressHttpConnection  extends HttpConnection {

    @Override
    public String LoadContent(String URL) throws IOException {
        return super.configureConnection(URL);
    }
}