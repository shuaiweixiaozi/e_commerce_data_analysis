package com.youfan.service;

import com.youfan.viewResult.YinxiaoEntity;
import com.youfan.viewResult.YinxiaoResult;

import java.util.List;

public interface YinxiaoService {
    public List<YinxiaoEntity> hongbaoanalyEntity();
    public List<Object> hongbaoanalyList();
    public List<YinxiaoEntity> miaoshaanalyEntity();
    public List<Object> miaoshaanalyList();
    public List<YinxiaoEntity> tuangouanalyEntity();
    public List<Object> tuangouanalyList();
    public List<YinxiaoEntity> conpusanalyEntity();
    public List<Object> conpusanalyList();
    public List<YinxiaoEntity> zhidinganalyEntity();
    public List<Object> zhidinganalyList();
}
