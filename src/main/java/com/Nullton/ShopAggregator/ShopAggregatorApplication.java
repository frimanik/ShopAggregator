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
        CurrencyExchangeRateProvider.computeCurrencyToDollar("PHP");
        ShopProvider provider = new ShopProvider(new LinkedList<>());
        provider.Add(new AliexpressParser());
        provider.Add(new AmazonParser());
        ShopAggregator shopAggregator = new ShopAggregator(provider);
        shopAggregator.searchCheapest("lamp",1);
        HttpConnection.closeConnection();
    }
}
