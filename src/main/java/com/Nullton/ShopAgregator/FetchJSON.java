package com.Nullton.ShopAgregator;

import java.io.IOException;

public interface FetchJSON {
    public String fetchData(String vendor,String product) throws IOException;
}