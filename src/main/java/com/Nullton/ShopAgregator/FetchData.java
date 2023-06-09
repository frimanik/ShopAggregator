package com.Nullton.ShopAgregator;

import java.io.IOException;
import java.util.Map;

public interface FetchData {
    public Map<String,Entity> Parse(String product, int quantity) throws IOException;
}
