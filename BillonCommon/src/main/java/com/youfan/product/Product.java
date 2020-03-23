package com.youfan.product;

public class Product {
  private Integer id;
  private String productName;
  private Integer productTypeid;
  private Double originalPrice;
  private Double huodongPrice;
  private Integer shopid;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getProductTypeid() {
    return productTypeid;
  }

  public void setProductTypeid(Integer productTypeid) {
    this.productTypeid = productTypeid;
  }

  public Double getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(Double originalPrice) {
    this.originalPrice = originalPrice;
  }

  public Double getHuodongPrice() {
    return huodongPrice;
  }

  public void setHuodongPrice(Double huodongPrice) {
    this.huodongPrice = huodongPrice;
  }

  public Integer getShopid() {
    return shopid;
  }

  public void setShopid(Integer shopid) {
    this.shopid = shopid;
  }
}
