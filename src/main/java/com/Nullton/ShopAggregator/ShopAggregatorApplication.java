package com.Nullton.ShopAggregator;

import com.Nullton.ShopAggregator.AliexpressParser.AliexpressParser;
import com.Nullton.ShopAggregator.AmazonParser.AmazonParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.LinkedList;

@SpringBootApplication
public class ShopAggregatorApplication {

    public static void main(String[] args) throws IOException {
//		SpringApplication.run(ShopAggregatorApplication.class, args);
        HttpConnection.openConnection();
        CurrencyExchangeRateService exchangeRateService = new CurrencyExchangeRateService();
        ShopProvider provider = new ShopProvider();
        provider.Add(new AliexpressParser());
        provider.Add(new AmazonParser());
        ShopAggregator shopAggregator = new ShopAggregator(provider, exchangeRateService);
        shopAggregator.searchCheapest("EUR","lamp",1);
        HttpConnection.closeConnection();
    }
}
