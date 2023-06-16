package com.Nullton.ShopAggregator;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CurrencyExchangeRateService {

    public BigDecimal computeCurrencyToDollar(String fromCurrency) throws IOException {
        if (fromCurrency.equals("USD")) return BigDecimal.valueOf(1);
            HtmlPage t = HttpConnection.webClient.getPage("https://www.xe.com/currencyconverter/convert/?Amount=1&From="+fromCurrency+"&To=USD");
            List<DomNode> els = t.querySelectorAll("[class*=\"result__BigRate\"]");
            for (DomNode el : els){
                System.out.println(el.getTextContent());
            }
           return BigDecimal.valueOf(Double.parseDouble(els.get(0).getTextContent().split(" ")[0]));
    }
}
