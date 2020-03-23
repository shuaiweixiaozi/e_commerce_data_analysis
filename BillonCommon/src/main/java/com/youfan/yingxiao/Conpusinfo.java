package com.youfan.yingxiao;

public class Conpusinfo {

    private Integer id;
  private String conpusName;
  private Integer conpusType;// '1、满减劵 2、折扣卷 3、新人卷 4、现金卷 5、免单卷、6、包邮卷 7、指定活动卷',
            private String conpusTime;
    private Integer conpusStatus;// '0申请中 1 审核通过 2 审核失败',
            private Double amount;
    private String approveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConpusName() {
        return conpusName;
    }

    public void setConpusName(String conpusName) {
        this.conpusName = conpusName;
    }

    public Integer getConpusType() {
        return conpusType;
    }

    public void setConpusType(Integer conpusType) {
        this.conpusType = conpusType;
    }

    public String getConpusTime() {
        return conpusTime;
    }

    public void setConpusTime(String conpusTime) {
        this.conpusTime = conpusTime;
    }

    public Integer getConpusStatus() {
        return conpusStatus;
    }

    public void setConpusStatus(Integer conpusStatus) {
        this.conpusStatus = conpusStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(String approveTime) {
        this.approveTime = approveTime;
    }
}
