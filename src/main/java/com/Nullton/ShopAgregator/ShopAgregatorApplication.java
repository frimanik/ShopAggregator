package com.Nullton.ShopAgregator;

import com.Nullton.ShopAgregator.AliexpressParser.AliexpressParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.LinkedList;

@SpringBootApplication
public class ShopAgregatorApplication {

    public static void main(String[] args) throws IOException {
//		SpringApplication.run(ShopAgregatorApplication.class, args);
        ShopProvider provider = new ShopProvider(new LinkedList<>());
        provider.Add(new AliexpressParser());
        ShopAgregator shopAgregator = new ShopAgregator(provider);
        shopAgregator.searchCheapest("fridge",1);
    }
}
