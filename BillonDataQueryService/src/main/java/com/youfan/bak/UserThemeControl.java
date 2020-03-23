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
//@RequestMapping("userTheme")
//@CrossOrigin
//public class UserThemeControl {
//    @RequestMapping(value = "useranaly",method = RequestMethod.POST)
//    public String useranaly(String userId){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<KeyValueEntity> userThemeEntitylist =new ArrayList<KeyValueEntity>();
//        //概览
//        KeyValueEntity userThemeEntity = new KeyValueEntity();
//        userThemeEntity.setKey("团购次数");
//        userThemeEntity.setValue("35");
//        userThemeEntitylist.add(userThemeEntity);
//        userThemeEntity = new KeyValueEntity();
//        userThemeEntity.setKey("红包次数");
//        userThemeEntity.setValue("45");
//        userThemeEntitylist.add(userThemeEntity);
//        viewResultAnaly.setKeyValueEntityList(userThemeEntitylist);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//}
