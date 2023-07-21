package com.Nullton.ShopAggregator;
import com.Nullton.ShopAggregator.AliexpressParser.AliexpressParser;
import com.Nullton.ShopAggregator.AmazonParser.AmazonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ShopAggregatorApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(ShopAggregatorApplication.class, args);
        ShopProvider provider = context.getBean(ShopProvider.class);
        provider.Add(context.getBean(AmazonParser.class));
    }
}
