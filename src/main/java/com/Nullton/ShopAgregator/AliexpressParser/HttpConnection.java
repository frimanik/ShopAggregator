package com.Nullton.ShopAgregator.AliexpressParser;

import com.Nullton.ShopAgregator.FetchJSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

import java.io.IOException;

public class HttpConnection implements FetchJSON {

    @Override
    public String fetchData(String URL) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);
        webClient.getOptions().setJavaScriptEnabled(true);
        String content = webClient.getPage(URL).getWebResponse().getContentAsString();
        webClient.close();
        return content;
    }
}
