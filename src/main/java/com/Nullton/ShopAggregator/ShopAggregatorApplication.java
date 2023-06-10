package com.Nullton.ShopAggregator;

import com.Nullton.ShopAggregator.AliexpressParser.AliexpressParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.LinkedList;

@SpringBootApplication
public class ShopAggregatorApplication {

    public static void main(String[] args) throws IOException {
//		SpringApplication.run(ShopAggregatorApplication.class, args);
        ShopProvider provider = new ShopProvider(new LinkedList<>());
        provider.Add(new AliexpressParser());
        ShopAggregator shopAggregator = new ShopAggregator(provider);
        shopAggregator.searchCheapest("fridge",1);
    }
}
