package com.Nullton.ShopAggregator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;

public abstract class HttpConnection {

    protected String configureConnection(String URL) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        String content = webClient.getPage(URL).getWebResponse().getContentAsString();
        webClient.close();
        return content;
    }
}
