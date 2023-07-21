package com.Nullton.ShopAggregator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class HttpConnection {
    WebClient webClient;

public HttpConnection(){
    webClient = new WebClient(BrowserVersion.FIREFOX);
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
}
    public void closeConnection(){
        webClient.close();
    }

    protected String loadProducts(String URL) throws IOException {
        String content = webClient.getPage(URL).getWebResponse().getContentAsString();
        return content;
    }
}
