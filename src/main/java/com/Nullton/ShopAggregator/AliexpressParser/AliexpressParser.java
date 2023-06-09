 package com.Nullton.ShopAggregator.AliexpressParser;

import com.Nullton.ShopAggregator.DataFetcher;
import com.Nullton.ShopAggregator.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class AliexpressParser implements DataFetcher {
    @Autowired
    AliexpressHttpConnection connection;
    @Override
    public List<ProductEntity> Fetch(String product, int quantity) throws IOException {
        HashMap<String, ProductEntity> products = new HashMap<>();
        int page = 1;
        while (products.size() < quantity) {
            String URL = "https://www.aliexpress.com/w/wholesale-" + product + ".html?&sortType=price_asc&page=" + page++;
            String content = connection.loadProducts(URL);
            String script = content.substring(content.indexOf("dida_config"), content.lastIndexOf("dida_config"));
            String[] split = script.split("[,:\"]");
            String temp = "";
            String currency =script.substring(script.indexOf("currencySymbol"),script.indexOf("currencySymbol")+30);
            currency = currency.substring(currency.indexOf(":")+2,currency.indexOf(",")-1);
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("imgUrl")) {
                    products.put(split[i + 3], new AliexpressProductEntity());
                    temp = split[i + 3];
                    products.get(temp).setImgUrl(temp);
                    products.get(temp).setId();
                    products.get(temp).setShop("AliExpress.com");
                }
                if (split[i].equals("seoTitle")) {
                    products.get(temp).setTitle(split[i + 3]);
                }
                if (split[i].equals("minPrice")) {
                    products.get(temp).setCurrency(currency);
                    products.get(temp).setPrice(BigDecimal.valueOf(Double.parseDouble(split[i + 2])));
                }
            }
        }
        return products.values().stream().filter(productEntity -> productEntity.price != null).toList();
    }
}
