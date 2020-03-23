package com.youfan.mappers;

import com.youfan.viewResult.YinxiaoResult;

import java.util.List;

public interface YinxiaoMapper {

    public List<YinxiaoResult> tuangouStatistics();

    public List<YinxiaoResult>  tuangouMonthStatistics();

    public List<YinxiaoResult>  conpusStatistics();

    public List<YinxiaoResult>  conpusMonthStatistics();

    public List<YinxiaoResult>  miaoshaStatistics();

    public List<YinxiaoResult>  miaoshaMonthStatistics();

    public List<YinxiaoResult>  huodongStatistics();

    public List<YinxiaoResult>  huodongMonthStatistics();

    public List<YinxiaoResult>  hongbaoStatistics();

    public List<YinxiaoResult>  hongbaoMonthStatistics();
}
