//package com.youfan.bak;
//
//import com.alibaba.fastjson.JSONObject;
//import com.youfan.viewResult.ViewResultAnaly;
//import com.youfan.viewResult.YinxiaoEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * 营销域
// */
//@RestController
//@RequestMapping("yinxiao")
//@CrossOrigin
//public class YinxiaoControl {
//
//    @RequestMapping(value = "hongbaoanaly",method = RequestMethod.POST)
//    public String hongbaoanaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();//数量
//        //--模拟构造数据 start
//        //概览
//        YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("未支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("已支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
//
//        //用户数量
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setUserResultList(resultList);
//
//
//        //商品多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//         dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setProductResultList(resultList);
//
//
//        //店铺多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setShopResultList(resultList);
//
//
//        //商家多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setMerchartResultList(resultList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "miaoshaanaly",method = RequestMethod.POST)
//    public String miaoshaanaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();//数量
//        //--模拟构造数据 start
//        //概览
//        YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("未支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("已支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
//
//        //用户数量
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setUserResultList(resultList);
//
//
//        //商品多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setProductResultList(resultList);
//
//
//        //店铺多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setShopResultList(resultList);
//
//
//        //商家多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setMerchartResultList(resultList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//
//    }
//
//
//    @RequestMapping(value = "tuangouanaly",method = RequestMethod.POST)
//    public String tuangouanaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();//数量
//        //--模拟构造数据 start
//        //概览
//        YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("未支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("已支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
//
//        //用户数量
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setUserResultList(resultList);
//
//
//        //商品多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setProductResultList(resultList);
//
//
//        //店铺多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setShopResultList(resultList);
//
//
//        //商家多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setMerchartResultList(resultList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//
//    }
//
//
//    @RequestMapping(value = "conpusanaly",method = RequestMethod.POST)
//    public String conpusanaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();//数量
//        //--模拟构造数据 start
//        //概览
//        YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("未支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("已支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
//
//        //用户数量
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setUserResultList(resultList);
//
//
//        //商品多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setProductResultList(resultList);
//
//
//        //店铺多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setShopResultList(resultList);
//
//
//        //商家多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setMerchartResultList(resultList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//
//    }
//
//    @RequestMapping(value = "zhidinganaly",method = RequestMethod.POST)
//    public String zhidinganaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();//数量
//        //--模拟构造数据 start
//        //概览
//        YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("未支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        yinxiaoEntity = new YinxiaoEntity();
//        yinxiaoEntity.setNumRange("0-10");
//        yinxiaoEntity.setStatus("已支付");
//        yinxiaoEntity.setUsernums("45");
//        yinxiaoEntity.setMerchatnums("55");
//        yinxiaoEntity.setProductnums("65");
//        yinxiaoEntity.setShopnums("67");
//        yinxiaoEntityList.add(yinxiaoEntity);
//        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
//
//        //用户数量
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setUserResultList(resultList);
//
//
//        //商品多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setProductResultList(resultList);
//
//
//        //店铺多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setShopResultList(resultList);
//
//
//        //商家多标签
//        infolist = new ArrayList<String>();//分组list，x轴的值
//        countlist =new ArrayList<Long>();//数量
//        resultList = new ArrayList<Map<String,Object>>();
//        dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","0-10 未支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","0-10 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","10-20 已支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setMerchartResultList(resultList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//}
