package com.youfan.service;

import com.youfan.viewResult.Cartcar;
import com.youfan.viewResult.DeviceEntity;

import java.util.List;

public interface LiuLiangService {
    public List<DeviceEntity> diviceTypeanaly();
    public List<Object> diviceTypedailyanaly();
    public List<Object> diviceTypemonthlyanaly();
    public List<Cartcar>  cartcaranaly();
    public List<Object> cartcardailyanaly();
    public List<Object> cartcarmonthlyanaly();
}
