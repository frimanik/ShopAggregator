package com.Nullton.ShopAgregator.AliexpressParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public void Parse(int quantity, String URL, int page) throws IOException {
        HttpConnection connection = new HttpConnection();
        HashMap<String, Entity> products = new HashMap<>();
        while (products.size() < quantity) {
            page++;
            String content = connection.fetchData(URL);
            String script = content.substring(content.indexOf("dida_config"), content.lastIndexOf("dida_config"));
            String[] split = script.split("[,:\"]");
            String temp = "";

            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("seoTitle")) {
                    products.put(split[i + 3], new Entity());
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

    }
}
