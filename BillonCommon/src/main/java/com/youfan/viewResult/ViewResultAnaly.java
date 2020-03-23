package com.youfan.viewResult;

import java.util.List;
import java.util.Map;

public class ViewResultAnaly {
    private List<String> infolist;//分组list，x轴的值
    private List<Object> countlist;//数量list
    private String result;
    private String typename;//标签类型名称
    private String lablevalue;//标签类型对应的值

    private  List<ViewResultAnaly> list;//所有标签信息

    private List<Map<String,Object>> resultList;//多标签

    private List<DeviceEntity> deviceEntityList;//设备终端类型list

    private List<Cartcar> cartcarList;

    private List<YinxiaoEntity> yinxiaoEntityList;


    private List<Map<String,Object>> userResultList;//用户多标签

    private List<Map<String,Object>> productResultList;//商品多标签

    private List<Map<String,Object>> shopResultList;//店铺多标签

    private List<Map<String,Object>> merchartResultList;//商家多标签

    private List<KeyValueEntity> KeyValueEntityList;

    public List<KeyValueEntity> getKeyValueEntityList() {
        return KeyValueEntityList;
    }

    public void setKeyValueEntityList(List<KeyValueEntity> keyValueEntityList) {
        KeyValueEntityList = keyValueEntityList;
    }

    public List<YinxiaoEntity> getYinxiaoEntityList() {
        return yinxiaoEntityList;
    }



    public void setYinxiaoEntityList(List<YinxiaoEntity> yinxiaoEntityList) {
        this.yinxiaoEntityList = yinxiaoEntityList;
    }

    public List<String> getInfolist() {
        return infolist;
    }

    public void setInfolist(List<String> infolist) {
        this.infolist = infolist;
    }

    public List<Object> getCountlist() {
        return countlist;
    }

    public void setCountlist(List<Object> countlist) {
        this.countlist = countlist;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getLablevalue() {
        return lablevalue;
    }

    public void setLablevalue(String lablevalue) {
        this.lablevalue = lablevalue;
    }

    public List<ViewResultAnaly> getList() {
        return list;
    }

    public void setList(List<ViewResultAnaly> list) {
        this.list = list;
    }

    public List<Map<String, Object>> getResultList() {
        return resultList;
    }

    public void setResultList(List<Map<String, Object>> resultList) {
        this.resultList = resultList;
    }

    public List<Cartcar> getCartcarList() {
        return cartcarList;
    }

    public void setCartcarList(List<Cartcar> cartcarList) {
        this.cartcarList = cartcarList;
    }

    public List<DeviceEntity> getDeviceEntityList() {
        return deviceEntityList;
    }

    public void setDeviceEntityList(List<DeviceEntity> deviceEntityList) {
        this.deviceEntityList = deviceEntityList;
    }

    public List<Map<String, Object>> getUserResultList() {
        return userResultList;
    }

    public void setUserResultList(List<Map<String, Object>> userResultList) {
        this.userResultList = userResultList;
    }

    public List<Map<String, Object>> getProductResultList() {
        return productResultList;
    }

    public void setProductResultList(List<Map<String, Object>> productResultList) {
        this.productResultList = productResultList;
    }

    public List<Map<String, Object>> getShopResultList() {
        return shopResultList;
    }

    public void setShopResultList(List<Map<String, Object>> shopResultList) {
        this.shopResultList = shopResultList;
    }

    public List<Map<String, Object>> getMerchartResultList() {
        return merchartResultList;
    }

    public void setMerchartResultList(List<Map<String, Object>> merchartResultList) {
        this.merchartResultList = merchartResultList;
    }
}
