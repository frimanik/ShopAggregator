package com.Nullton.ShopAgregator.AliexpressParser;

import com.Nullton.ShopAgregator.FetchJSON;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class AliexpressHttpConnection implements FetchJSON {

    @Override
    public String fetchData(String URL,String product) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        String content = webClient.getPage(URL+"/w/wholesale-"+product+".html").getWebResponse().getContentAsString();
        webClient.close();
        return content;
    }
}
