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
///**
// * 实时排行
// */
//@RestController
//@RequestMapping("timingTop")
//@CrossOrigin
//public class TimingTopControl {
//    @RequestMapping(value = "tuangouuserstop",method = RequestMethod.POST)
//    public String tuangouuserstop(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> userThemeEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity timingEntity = new KeyValueEntity();
//        timingEntity.setKey("小红");
//        timingEntity.setValue("24");
//        userThemeEntitylist.add(timingEntity);
//        timingEntity = new KeyValueEntity();
//        timingEntity.setKey("小白");
//        timingEntity.setValue("45");
//        userThemeEntitylist.add(timingEntity);
//        viewResultAnaly.setKeyValueEntityList(userThemeEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "producttypetop",method = RequestMethod.POST)
//    public String producttypetop(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> userThemeEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity timingEntity = new KeyValueEntity();
//        timingEntity.setKey("衬衫");
//        timingEntity.setValue("24");
//        userThemeEntitylist.add(timingEntity);
//        timingEntity = new KeyValueEntity();
//        timingEntity.setKey("茶杯");
//        timingEntity.setValue("45");
//        userThemeEntitylist.add(timingEntity);
//        viewResultAnaly.setKeyValueEntityList(userThemeEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "producttop",method = RequestMethod.POST)
//    public String producttop(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> userThemeEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity timingEntity = new KeyValueEntity();
//        timingEntity.setKey("洁白的衬衫");
//        timingEntity.setValue("24");
//        userThemeEntitylist.add(timingEntity);
//        timingEntity = new KeyValueEntity();
//        timingEntity.setKey("好看的茶杯");
//        timingEntity.setValue("45");
//        userThemeEntitylist.add(timingEntity);
//        viewResultAnaly.setKeyValueEntityList(userThemeEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "conpususerstop",method = RequestMethod.POST)
//    public String conpususerstop(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> userThemeEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity timingEntity = new KeyValueEntity();
//        timingEntity.setKey("小红");
//        timingEntity.setValue("24");
//        userThemeEntitylist.add(timingEntity);
//        timingEntity = new KeyValueEntity();
//        timingEntity.setKey("小白");
//        timingEntity.setValue("45");
//        userThemeEntitylist.add(timingEntity);
//        viewResultAnaly.setKeyValueEntityList(userThemeEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//}
