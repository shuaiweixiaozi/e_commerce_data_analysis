package com.youfan.analyEntity.tuangou;

public class TuanGouanalyEntity {
    private String userId;
    private Long Times;
    private Integer id;
    private String  tuangouName = null;
    private Integer tuangouTotalNum = null;
    private Integer tuangouNum = null;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTimes() {
        return Times;
    }

    public void setTimes(Long times) {
        Times = times;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTuangouName() {
        return tuangouName;
    }

    public void setTuangouName(String tuangouName) {
        this.tuangouName = tuangouName;
    }

    public Integer getTuangouTotalNum() {
        return tuangouTotalNum;
    }

    public void setTuangouTotalNum(Integer tuangouTotalNum) {
        this.tuangouTotalNum = tuangouTotalNum;
    }

    public Integer getTuangouNum() {
        return tuangouNum;
    }

    public void setTuangouNum(Integer tuangouNum) {
        this.tuangouNum = tuangouNum;
    }
}
