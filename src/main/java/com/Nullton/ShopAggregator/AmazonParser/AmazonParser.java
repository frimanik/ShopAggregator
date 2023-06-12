package com.Nullton.ShopAggregator.AmazonParser;

import com.Nullton.ShopAggregator.DataFetcher;
import com.Nullton.ShopAggregator.ProductEntity;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class AmazonParser implements DataFetcher {
    @Override
    public List<ProductEntity> Fetch(String product, int quantity) throws IOException {
        String URL = "https://amazon.com/s?k="+product+"&s=price-asc-rank";
        AmazonHttpConnection connection = new AmazonHttpConnection();
        HashMap<String, ProductEntity> products = new HashMap<>();

        String content = connection.LoadContent(URL);
        int id1 = content.indexOf("img class=\"s-image\"");
        int id2 = content.lastIndexOf("img class=\"s-image\"");
        String script = content.substring(id1, id2);
        // String[]split = script.split("[=<>,:\"]");
        String[] split = script.split("<span class=\"a-offscreen\">|<span class=\"a-size-medium a-color-base a-text-normal\">|</span>|img class=\"s-image\" src=\"|srcset=");
        String temp = "";

        for (int i = 0; i < split.length; i++) {
            if (split[i].endsWith("jpg\" ")) {
                split[i] = split[i].substring(0, split[i].length() - 2);
                products.put(split[i], new AmazonProductEntity());
                temp = split[i];
                products.get(temp).setImgUrl(temp);
                products.get(temp).setId();
                products.get(temp).setShop("Amazon.com");
            }

            if (split[i].contains("<span class=\"a-size-base-plus a-color-base a-text-normal\">"))
                try {
                    products.get(temp).setTitle(split[i].substring(split[i].indexOf("a-text-normal\">") + 15, split[i].length() - 1));
                } catch (NullPointerException e) {
                    e.getMessage();
                }
            if (split[i].startsWith("$")) {
                products.get(temp).setPrice(BigDecimal.valueOf(Double.parseDouble(split[i].substring(1, split[i].length() - 1))));
            }
        }
        return products.values().stream().filter(productEntity -> productEntity.price!=null).toList();
    }
}