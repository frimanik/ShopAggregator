package com.Nullton.ShopAgregator.AliexpressParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AliexpressParser {
    public Map<String, AliexpressEntity> Parse(String product,int quantity, String URL, int page) throws IOException {
        AliexpressHttpConnection connection = new AliexpressHttpConnection();
        HashMap<String, AliexpressEntity> products = new HashMap<>();
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
        for (Map.Entry<String, AliexpressEntity> res : products.entrySet()) {
            System.out.println(counter + ":" + res.getKey() + " " + res.getValue().getPrice());
            counter++;
        }
        return products;

    }
}
