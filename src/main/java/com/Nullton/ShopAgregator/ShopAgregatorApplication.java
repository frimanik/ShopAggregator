package com.Nullton.ShopAgregator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ShopAgregatorApplication {

    public static void main(String[] args) throws IOException {
//		SpringApplication.run(ShopAgregatorApplication.class, args);
        ShopAgregator shopAgregator = new ShopAgregator();
        shopAgregator.returnCheapest();
    }
}
