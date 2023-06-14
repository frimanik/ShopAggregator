package com.Nullton.ShopAggregator;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class CurrencyExchangeRateProvider {
   public static HashMap<String,BigDecimal> curToUsd = new HashMap<>();

    public static void computeCurrencyToDollar(String fromCurrency) throws IOException {
            HtmlPage t = HttpConnection.webClient.getPage("https://www.xe.com/currencyconverter/convert/?Amount=1&From="+fromCurrency+"&To=USD");
            List<DomNode> els = t.getByXPath("/html[1]/body[1]/div[1]/div[2]/div[2]/section[1]/div[2]/div[1]/main[1]/div[1]/div[2]/div[1]/p[2]");
            for (DomNode el : els){
                System.out.println(el.getTextContent());
            }
            curToUsd.put(fromCurrency,BigDecimal.valueOf(Double.parseDouble(els.get(0).getTextContent().substring(0,10))));
    }
}
