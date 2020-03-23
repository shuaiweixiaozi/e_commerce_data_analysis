//package com.youfan.bak;
//
//import com.alibaba.fastjson.JSONObject;
//import com.youfan.viewResult.KeyValueEntity;
//import com.youfan.viewResult.ViewResultAnaly;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("shopTheme")
//@CrossOrigin
//public class ShopThemeControl {
//    @RequestMapping(value = "tuangoubytimeanaly",method = RequestMethod.POST)
//    public String tuangoubytimeanaly(String startTime,String endTime){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("猪肉店");
//        keyvalueEntity.setValue("45");
//        keyvalueEntitylist.add(keyvalueEntity);
//        keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("茶几店");
//        keyvalueEntity.setValue("35");
//        keyvalueEntitylist.add(keyvalueEntity);
//        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "productTypebytimeanaly",method = RequestMethod.POST)
//    public String productTypebytimeanaly(String startTime,String endTime){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("猪肉店");
//        keyvalueEntity.setValue("35");
//        keyvalueEntitylist.add(keyvalueEntity);
//        keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("茶几店");
//        keyvalueEntity.setValue("45");
//        keyvalueEntitylist.add(keyvalueEntity);
//        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "hongbaobytimeanaly",method = RequestMethod.POST)
//    public String hongbaobytimeanaly(String startTime,String endTime){
//        System.out.println(startTime+"=="+endTime);
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("猪肉店");
//        keyvalueEntity.setValue("35");
//        keyvalueEntitylist.add(keyvalueEntity);
//        keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("茶几店");
//        keyvalueEntity.setValue("45");
//        keyvalueEntitylist.add(keyvalueEntity);
//        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "cjbytimeanaly",method = RequestMethod.POST)
//    public String cjbytimeanaly(String startTime,String endTime){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("猪肉店");
//        keyvalueEntity.setValue("35");
//        keyvalueEntitylist.add(keyvalueEntity);
//        keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("茶几店");
//        keyvalueEntity.setValue("45");
//        keyvalueEntitylist.add(keyvalueEntity);
//        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "userbytimeanaly",method = RequestMethod.POST)
//    public String userbytimeanaly(String startTime,String endTime){
//        System.out.println(startTime+"=="+endTime);
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("猪肉店");
//        keyvalueEntity.setValue("35");
//        keyvalueEntitylist.add(keyvalueEntity);
//        keyvalueEntity = new KeyValueEntity();
//        keyvalueEntity.setKey("茶几店");
//        keyvalueEntity.setValue("45");
//        keyvalueEntitylist.add(keyvalueEntity);
//        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//}