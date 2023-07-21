package com.Nullton.ShopAggregator;

import com.Nullton.ShopAggregator.AliexpressParser.AliexpressParser;
import com.Nullton.ShopAggregator.AmazonParser.AmazonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationConfig {

    @Autowired
    private ApplicationContext context;

    public void startUpConfiguration(){
        ShopProvider provider = context.getBean(ShopProvider.class);
        provider.Add(context.getBean(AliexpressParser.class));
        provider.Add(context.getBean(AmazonParser.class));
    }
}
