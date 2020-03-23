package com.youfan.dao.impl;

import com.youfan.dao.YinxiaoDao;
import com.youfan.mappers.YinxiaoMapper;
import com.youfan.viewResult.YinxiaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class YinxiaoDaoImpl implements YinxiaoDao {
    @Autowired
    private YinxiaoMapper yinxiaoMapper;

    @Override
    public List<YinxiaoResult> tuangouStatistics() {
        return yinxiaoMapper.tuangouStatistics();
    }

    @Override
    public List<YinxiaoResult> tuangouMonthStatistics() {
        return yinxiaoMapper.tuangouMonthStatistics();
    }

    @Override
    public List<YinxiaoResult> conpusStatistics() {
        return yinxiaoMapper.conpusStatistics();
    }

    @Override
    public List<YinxiaoResult> conpusMonthStatistics() {
        return yinxiaoMapper.conpusMonthStatistics();
    }

    @Override
    public List<YinxiaoResult> miaoshaStatistics() {
        return yinxiaoMapper.miaoshaStatistics();
    }

    @Override
    public List<YinxiaoResult> miaoshaMonthStatistics() {
        return yinxiaoMapper.miaoshaMonthStatistics();
    }

    @Override
    public List<YinxiaoResult> huodongStatistics() {
        return yinxiaoMapper.huodongStatistics();
    }

    @Override
    public List<YinxiaoResult> huodongMonthStatistics() {
        return yinxiaoMapper.huodongMonthStatistics();
    }

    @Override
    public List<YinxiaoResult> hongbaoStatistics() {
        return yinxiaoMapper.hongbaoStatistics();
    }

    @Override
    public List<YinxiaoResult> hongbaoMonthStatistics() {
        return yinxiaoMapper.hongbaoMonthStatistics();
    }
}
