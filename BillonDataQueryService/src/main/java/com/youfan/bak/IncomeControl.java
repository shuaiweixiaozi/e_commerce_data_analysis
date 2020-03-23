//package com.youfan.bak;
//
//import com.alibaba.fastjson.JSONObject;
//import com.youfan.viewResult.ViewResultAnaly;
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
// * 大盘收入
// */
//@RestController
//@RequestMapping("income")
//@CrossOrigin
//public class IncomeControl {
//
//    @RequestMapping(value = "totalDailyIncome",method = RequestMethod.POST)
//    public String totalDailyIncome(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        //--模拟构造数据 start
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(1000L);
//        countlist.add(500L);
//        countlist.add(2000L);
//        //--模拟构造数据 end
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setCountlist(countlist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "totalDailyIncomeByPaytype",method = RequestMethod.POST)
//    public String totalDailyByPaytypeIncome(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
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
//        dataMap.put("name","支付宝");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","微信支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","银联支付");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        //--模拟构造数据 end
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setResultList(resultList);
//
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//
//    @RequestMapping(value = "totalDailyByprtypetypeIncome",method = RequestMethod.POST)
//    public String totalDailyByprtypetypeIncome(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
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
//        dataMap.put("name","日用品");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","电子产品");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","服装用品");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        //--模拟构造数据 end
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setResultList(resultList);
//
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//}
