package com.Nullton.ShopAgregator;

import com.Nullton.ShopAgregator.AliexpressParser.Parser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ShopAgregatorApplication {

    public static void main(String[] args) throws IOException {
//		SpringApplication.run(ShopAgregatorApplication.class, args);
        Parser parser = new Parser();
        parser.Parse(100,"https://www.aliexpress.com/w/wholesale-lamp.html?SearchText=lamp&catId=0&initiative_id=SB_20230609014333&spm=a2g0o.home.1000002.0&trafficChannel=main&g=y&page=1",0);
    }
}
