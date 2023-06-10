package com.Nullton.ShopAgregator.AliexpressParser;

import com.Nullton.ShopAgregator.Entity;
import com.Nullton.ShopAgregator.FetchData;
import com.Nullton.ShopAgregator.ShopProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AliexpressParser implements FetchData {

    @Override
    public Map<String,Entity> Parse(String product, int quantity)  throws IOException {
        ShopProvider.Add(new AliexpressParser());
        String URL = "https://www.aliexpress.com";
        AliexpressHttpConnection connection = new AliexpressHttpConnection();
        HashMap<String, Entity> products = new HashMap<>();
        int page=0;
        while (products.size() < quantity) {
            page++;
            String content = connection.fetchData(URL,product);
            String script = content.substring(content.indexOf("dida_config"), content.lastIndexOf("dida_config"));
            String[] split = script.split("[,:\"]");
            String temp = "";

            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("seoTitle")) {
                    products.put(split[i + 3], new AliexpressEntity());
                    temp = split[i + 3];
                }
                if (split[i].equals("minPrice")) {
                    products.get(temp).setName(temp);
                    products.get(temp).setPrice(split[i + 2]);
                }
            }
            URL = URL.replace("page=" + (page - 1), "page=" + page);
        }
        int counter = 1;
        for (Map.Entry<String, Entity> res : products.entrySet()) {
            System.out.println(counter + ":" + res.getKey() + " " + res.getValue().getPrice());
            counter++;
        }
        return products;
    }
}
