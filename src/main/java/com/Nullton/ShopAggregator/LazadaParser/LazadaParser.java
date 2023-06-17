package com.Nullton.ShopAggregator.LazadaParser;

import com.Nullton.ShopAggregator.AmazonParser.AmazonHttpConnection;
import com.Nullton.ShopAggregator.DataFetcher;
import com.Nullton.ShopAggregator.ProductEntity;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class LazadaParser implements DataFetcher {
    @Autowired
    LazadaHttpConnection connection;
    @Override
    public List<ProductEntity> Fetch(String product, int quantity) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        int page = 1;
        boolean firstRequest = true;
        HashMap<String, ProductEntity> products = new HashMap<>();
        JsonFactory factory = new JsonFactory();
        while (products.size()<quantity) {
            String URL = "https://www.lazada.com.ph/tag/" + product + "/?ajax=true&isFirstRequest="+firstRequest+"&page=" + page++ + "&q=" + product + "&sort=priceasc";
            String content = connection.loadProducts(URL);
            JsonParser parser = factory.createParser(content);
            JsonNode node = mapper.readValue(parser, JsonNode.class);
            JsonNode node2 = node.findValue("listItems");
            parser = node2.traverse();
            String temp = "";
            while (!parser.isClosed()) {
                parser.nextToken();
                if (parser.getCurrentName() != null && parser.getCurrentName().equals("name")) {
                    products.put(parser.nextTextValue(), new LazadaProductEntity());
                    temp = parser.getValueAsString();
                    products.get(temp).setTitle(temp);
                }
                if (parser.getCurrentName() != null && parser.getCurrentName().equals("image")) {
                    products.get(temp).setImgUrl(parser.nextTextValue());
                    products.get(temp).setId();
                    products.get(temp).setShop("Lazada.com");
                }
                if (parser.getCurrentName() != null && parser.getCurrentName().equals("price")) {
                    products.get(temp).setPrice(BigDecimal.valueOf(Double.parseDouble(parser.nextTextValue())));
                    products.get(temp).setCurrency("PHP");
                }
            }
            firstRequest =false;
        }
        return products.values().stream().filter(productEntity -> productEntity.price != null).toList();
    }
}
