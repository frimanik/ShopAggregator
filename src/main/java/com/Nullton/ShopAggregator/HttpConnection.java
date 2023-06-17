package com.Nullton.ShopAggregator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public  class HttpConnection {
static WebClient webClient;
   static public void openConnection(){
        webClient = new WebClient(BrowserVersion.FIREFOX);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
    }

   static public void closeConnection(){
        webClient.close();
    }

    protected String loadProducts(String URL) throws IOException {
        String content = webClient.getPage(URL).getWebResponse().getContentAsString();
        return content;
    }
}
