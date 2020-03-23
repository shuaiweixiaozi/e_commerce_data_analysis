package com.youfan.product;

public class Shopinfo {
    private Integer id;
  private String shopname;
  private Integer merchartId;
  private String shopdesrc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public Integer getMerchartId() {
        return merchartId;
    }

    public void setMerchartId(Integer merchartId) {
        this.merchartId = merchartId;
    }

    public String getShopdesrc() {
        return shopdesrc;
    }

    public void setShopdesrc(String shopdesrc) {
        this.shopdesrc = shopdesrc;
    }
}
