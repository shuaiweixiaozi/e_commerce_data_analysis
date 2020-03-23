//package com.youfan.bak;
//
//import com.alibaba.fastjson.JSONObject;
//import com.youfan.viewResult.Cartcar;
//import com.youfan.viewResult.DeviceEntity;
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
// * 流量域
// */
//@RestController
//@RequestMapping("liuLiang")
//@CrossOrigin
//public class LiuLiangControl {
//
//    @RequestMapping(value = "diviceTypeanaly",method = RequestMethod.POST)
//    public String diviceTypeanaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<DeviceEntity> deviceEntityList =new ArrayList<DeviceEntity>();//数量
//        //--模拟构造数据 start
//        DeviceEntity deviceEntity = new DeviceEntity();
//        deviceEntity.setTypename("app端");
//        deviceEntity.setUsernum(100+"");
//        deviceEntity.setProductnum(200+"");
//        deviceEntityList.add(deviceEntity);
//        deviceEntity = new DeviceEntity();
//        deviceEntity.setTypename("pc端");
//        deviceEntity.setUsernum(400+"");
//        deviceEntity.setProductnum(500+"");
//        deviceEntityList.add(deviceEntity);
//        deviceEntity = new DeviceEntity();
//        deviceEntity.setTypename("小程序端");
//        deviceEntity.setUsernum(200+"");
//        deviceEntity.setProductnum(300+"");
//        deviceEntityList.add(deviceEntity);
//        //--模拟构造数据 end
//        viewResultAnaly.setDeviceEntityList(deviceEntityList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "diviceTypedailyanaly",method = RequestMethod.POST)
//    public String diviceTypedailyanaly(){
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
//        dataMap.put("name","app端");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","pc端");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","小程序端");
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
//    @RequestMapping(value = "diviceTypemonthlyanaly",method = RequestMethod.POST)
//    public String diviceTypemonthlyanaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("201909");
//        infolist.add("201910");
//        infolist.add("201911");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","app端");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","pc端");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","小程序端");
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
//    @RequestMapping(value = "cartcaranaly",method = RequestMethod.POST)
//    public String cartcaranaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Cartcar> cartcarList =new ArrayList<Cartcar>();//数量
//        //--模拟构造数据 start
//        Cartcar cartcar = new Cartcar();
//        cartcar.setTypename("添加");
//        cartcar.setOpeterRange("0-10");
//        cartcar.setUsernum(100+"");
//        cartcar.setProductnum(200+"");
//        cartcarList.add(cartcar);
//        cartcar = new Cartcar();
//        cartcar.setTypename("删除");
//        cartcar.setOpeterRange("0-10");
//        cartcar.setUsernum(100+"");
//        cartcar.setProductnum(200+"");
//        cartcarList.add(cartcar);
//
//        //--模拟构造数据 end
//        viewResultAnaly.setCartcarList(cartcarList);
//        String result = JSONObject.toJSONString(viewResultAnaly);
//        return result;
//
//    }
//
//    @RequestMapping(value = "cartcardailyanaly",method = RequestMethod.POST)
//    public String cartcardailyanaly(){
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
//        dataMap.put("name","添加操作次数1-10");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","添加操作次数10-20");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","删除操作次数10-20");
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
//    @RequestMapping(value = "cartcarmonthlyanaly",method = RequestMethod.POST)
//    public String cartcarmonthlyanaly(){
//        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
//        List<String> infolist = new ArrayList<String>();//分组list，x轴的值
//        List<Long> countlist =new ArrayList<Long>();//数量
//        List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
//        Map<String,Object> dataMap = new HashMap<String,Object>();
//        //--模拟构造数据 start
//        infolist.add("201910");
//        infolist.add("201911");
//        infolist.add("201912");
//        countlist.add(100L);
//        countlist.add(500L);
//        countlist.add(1000L);
//        dataMap.put("name","添加操作次数1-10");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(200L);
//        countlist.add(350L);
//        countlist.add(550L);
//        dataMap.put("name","添加操作次数10-20");
//        dataMap.put("data",countlist);
//        resultList.add(dataMap);
//        countlist =new ArrayList<Long>();//数量
//        dataMap = new HashMap<String,Object>();
//        countlist.add(400L);
//        countlist.add(600L);
//        countlist.add(450L);
//        dataMap.put("name","删除操作次数10-20");
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
