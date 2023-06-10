package com.Nullton.ShopAgregator.AliexpressParser;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;

public class AliexpressHttpConnection {

    public String fetchData(String URL,String product) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        String content = webClient.getPage(URL+"/w/wholesale-"+product+".html?&sortType=price_asc").getWebResponse().getContentAsString();
        webClient.close();
        return content;
    }
}