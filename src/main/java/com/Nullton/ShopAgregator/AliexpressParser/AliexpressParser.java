package com.Nullton.ShopAgregator.AliexpressParser;

import com.Nullton.ShopAgregator.ProductEntity;
import com.Nullton.ShopAgregator.DataFetcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AliexpressParser implements DataFetcher {

    @Override
    public List<ProductEntity> Fetch(String product, int quantity) throws IOException {
        String URL = "https://www.aliexpress.com";
        AliexpressHttpConnection connection = new AliexpressHttpConnection();
        HashMap<String, ProductEntity> products = new HashMap<>();
        int page = 0;
        while (products.size() < quantity) {
            page++;
            String content = connection.fetchData(URL, product);
            String script = content.substring(content.indexOf("dida_config"), content.lastIndexOf("dida_config"));
            String[] split = script.split("[,:\"]");
            String temp = "";
            long id = 0;
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("imgUrl")) {
                    products.put(split[i + 3], new AliexpressProductEntity());
                    temp = split[i + 3];
                    products.get(temp).setImgHref(temp);
                    products.get(temp).setId(id++);
                    products.get(temp).setShop("AliExpress.com");
                }
                if (split[i].equals("seoTitle")) {
                    products.get(temp).setName(split[i + 3]);
                }
                if (split[i].equals("minPrice")) {
                    products.get(temp).setPrice(split[i + 2]);
                }
            }
            URL = URL.replace("page=" + (page - 1), "page=" + page);
        }
        for (Map.Entry<String, ProductEntity> res : products.entrySet()) {
            System.out.println(res.getValue().id + ":" + res.getValue().getName() + " " + res.getValue().getPrice());
        }

        return products.values().stream().toList();
    }
}
