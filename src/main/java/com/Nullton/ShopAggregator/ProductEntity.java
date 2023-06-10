package com.Nullton.ShopAggregator;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class ProductEntity {
    public UUID id;

    public String imgUrl;

    public String title;

    public BigDecimal price;

    public String shop;

    public UUID getId() {
        return id;
    }

    public void setId() {
       this.id = UUID.randomUUID();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
