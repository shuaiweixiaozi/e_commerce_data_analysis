package com.youfan.service;

import com.youfan.viewResult.KeyValueEntity;

import java.util.List;

public interface ShopThemeService {
    public List<KeyValueEntity> tuangoubytime(String startTime, String endTime);
    public List<KeyValueEntity> productTypebytime(String startTime, String endTime);
    public List<KeyValueEntity> hongbaobytime(String startTime, String endTime);
    public List<KeyValueEntity> cjbytime(String startTime, String endTime);
    public List<KeyValueEntity> userbytime(String startTime, String endTime);
}
