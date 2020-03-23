package com.youfan.jiaoyi;

/**
 * 订单信息
 */
public class Orderinfo {
  private Integer id;
  private Integer userId;
  private Integer productId;
  private Integer shopId;
  private Integer merchartId;
  private Double orderAmount;
   private Double payAmount;
  private String createTime;
  private Integer payType;//'1 微信支付 2 支付宝支付 3 银联支付 4 京东支付',
  private String payTime;
  private Integer status;// '0未支付 1 已支付 2 已退款 3 未支付已失效',
  private Integer number;
  private Integer hongbaoId;
  private Double hongbaoAmount;
  private Integer conpusId;
  private Double conpusAmount;
  private Integer huodongId;
  private Integer miaoshaId;
  private Integer tuangouId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getShopId() {
    return shopId;
  }

  public void setShopId(Integer shopId) {
    this.shopId = shopId;
  }

  public Integer getMerchartId() {
    return merchartId;
  }

  public void setMerchartId(Integer merchartId) {
    this.merchartId = merchartId;
  }

  public Double getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(Double orderAmount) {
    this.orderAmount = orderAmount;
  }

  public Double getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(Double payAmount) {
    this.payAmount = payAmount;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public Integer getPayType() {
    return payType;
  }

  public void setPayType(Integer payType) {
    this.payType = payType;
  }

  public String getPayTime() {
    return payTime;
  }

  public void setPayTime(String payTime) {
    this.payTime = payTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Integer getHongbaoId() {
    return hongbaoId;
  }

  public void setHongbaoId(Integer hongbaoId) {
    this.hongbaoId = hongbaoId;
  }

  public Double getHongbaoAmount() {
    return hongbaoAmount;
  }

  public void setHongbaoAmount(Double hongbaoAmount) {
    this.hongbaoAmount = hongbaoAmount;
  }

  public Integer getConpusId() {
    return conpusId;
  }

  public void setConpusId(Integer conpusId) {
    this.conpusId = conpusId;
  }

  public Double getConpusAmount() {
    return conpusAmount;
  }

  public void setConpusAmount(Double conpusAmount) {
    this.conpusAmount = conpusAmount;
  }

  public Integer getHuodongId() {
    return huodongId;
  }

  public void setHuodongId(Integer huodongId) {
    this.huodongId = huodongId;
  }

  public Integer getMiaoshaId() {
    return miaoshaId;
  }

  public void setMiaoshaId(Integer miaoshaId) {
    this.miaoshaId = miaoshaId;
  }

  public Integer getTuangouId() {
    return tuangouId;
  }

  public void setTuangouId(Integer tuangouId) {
    this.tuangouId = tuangouId;
  }
}
