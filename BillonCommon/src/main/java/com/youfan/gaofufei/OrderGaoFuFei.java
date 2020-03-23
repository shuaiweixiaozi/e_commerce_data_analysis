package com.youfan.gaofufei;

public class OrderGaoFuFei {
    private String userId;
    private String productTypeid;
    private String productTypeName;
    private String payType;
    private String payTime;
    private double payAmount;
    private int paycount;
    private String sharding_id;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(String productTypeid) {
        this.productTypeid = productTypeid;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getSharding_id() {
        return sharding_id;
    }

    public void setSharding_id(String sharding_id) {
        this.sharding_id = sharding_id;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public int getPaycount() {
        return paycount;
    }

    public void setPaycount(int paycount) {
        this.paycount = paycount;
    }
}
