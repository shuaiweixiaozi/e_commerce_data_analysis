package com.youfan.yingxiao;

public class Hongbaoinfo {





  private Integer id;
   private String hongbaoName;
  private Double amount;
  private Integer userid;
   private String startTime;
   private String endTime;
  private Integer status;// '0未使用 1已使用 2 已失效'

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHongbaoName() {
    return hongbaoName;
  }

  public void setHongbaoName(String hongbaoName) {
    this.hongbaoName = hongbaoName;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
