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
// * 高付费
// */
//@RestController
//@RequestMapping("gaofuFei")
//@CrossOrigin
//public class GaofuFeiControl {
//
//    @RequestMapping(value = "gffbypaytypeusersdaily",method = RequestMethod.POST)
//    public String gffbypaytypeusersdaily(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start, 每日支付类型多少用户
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(50L);
//        countlist.add(200L);
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
//        //--模拟构造数据 end
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setResultList(resultList);
//
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "gffbypaytypeamountdaily",method = RequestMethod.POST)
//    public String gffbypaytypeamountdaily(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start 每日支付金额多少
//        infolist.add("20190806");
//        infolist.add("20190807");
//        infolist.add("20190808");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","支付总额");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        //--模拟构造数据 end
//        viewResultAnaly.setInfolist(infolist);
//        viewResultAnaly.setResultList(resultList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//
//    @RequestMapping(value = "gffbypaytypelargeamoutdaily",method = RequestMethod.POST)
//    public String gffbypaytypelargeamoutdaily(){
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
//        dataMap.put("name","大额次数");
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
