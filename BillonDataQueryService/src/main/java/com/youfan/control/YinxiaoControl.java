package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.youfan.service.YinxiaoService;
import com.youfan.viewResult.Cartcar;
import com.youfan.viewResult.DeviceEntity;
import com.youfan.viewResult.ViewResultAnaly;
import com.youfan.viewResult.YinxiaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 营销域
 */
@RestController
@RequestMapping("yinxiao")
@CrossOrigin
public class YinxiaoControl {

    @Autowired
    private YinxiaoService yinxiaoService;

    @RequestMapping(value = "hongbaoanaly",method = RequestMethod.POST)
    public String hongbaoanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<YinxiaoEntity> yinxiaoEntityList = yinxiaoService.hongbaoanalyEntity();
        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
        List<Object> list = yinxiaoService.hongbaoanalyList();
        List<String> infolist = (List<String>)list.get(0);
        List<Map<String,Object>> usermaplist = (List<Map<String,Object>>)list.get(1);//用户数量结果
        List<Map<String,Object>> productmaplist = (List<Map<String,Object>>)list.get(2);//商品数量结果
        List<Map<String,Object>> shopsmaplist = (List<Map<String,Object>>)list.get(3);//商铺数量结果
        List<Map<String,Object>> merchantmaplist = (List<Map<String,Object>>)list.get(4);//商家数量结果
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(usermaplist);
        viewResultAnaly.setProductResultList(productmaplist);
        viewResultAnaly.setShopResultList(shopsmaplist);
        viewResultAnaly.setMerchartResultList(merchantmaplist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "miaoshaanaly",method = RequestMethod.POST)
    public String miaoshaanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<YinxiaoEntity> yinxiaoEntityList = yinxiaoService.miaoshaanalyEntity();
        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
        List<Object> list = yinxiaoService.miaoshaanalyList();
        List<String> infolist = (List<String>)list.get(0);
        List<Map<String,Object>> usermaplist = (List<Map<String,Object>>)list.get(1);//用户数量结果
        List<Map<String,Object>> productmaplist = (List<Map<String,Object>>)list.get(2);//商品数量结果
        List<Map<String,Object>> shopsmaplist = (List<Map<String,Object>>)list.get(3);//商铺数量结果
        List<Map<String,Object>> merchantmaplist = (List<Map<String,Object>>)list.get(4);//商家数量结果
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(usermaplist);
        viewResultAnaly.setProductResultList(productmaplist);
        viewResultAnaly.setShopResultList(shopsmaplist);
        viewResultAnaly.setMerchartResultList(merchantmaplist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;


    }


    @RequestMapping(value = "tuangouanaly",method = RequestMethod.POST)
    public String tuangouanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<YinxiaoEntity> yinxiaoEntityList = yinxiaoService.tuangouanalyEntity();
        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
        List<Object> list = yinxiaoService.tuangouanalyList();
        List<String> infolist = (List<String>)list.get(0);
        List<Map<String,Object>> usermaplist = (List<Map<String,Object>>)list.get(1);//用户数量结果
        List<Map<String,Object>> productmaplist = (List<Map<String,Object>>)list.get(2);//商品数量结果
        List<Map<String,Object>> shopsmaplist = (List<Map<String,Object>>)list.get(3);//商铺数量结果
        List<Map<String,Object>> merchantmaplist = (List<Map<String,Object>>)list.get(4);//商家数量结果
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(usermaplist);
        viewResultAnaly.setProductResultList(productmaplist);
        viewResultAnaly.setShopResultList(shopsmaplist);
        viewResultAnaly.setMerchartResultList(merchantmaplist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;


    }


    @RequestMapping(value = "conpusanaly",method = RequestMethod.POST)
    public String conpusanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<YinxiaoEntity> yinxiaoEntityList = yinxiaoService.conpusanalyEntity();
        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
        List<Object> list = yinxiaoService.conpusanalyList();
        List<String> infolist = (List<String>)list.get(0);
        List<Map<String,Object>> usermaplist = (List<Map<String,Object>>)list.get(1);//用户数量结果
        List<Map<String,Object>> productmaplist = (List<Map<String,Object>>)list.get(2);//商品数量结果
        List<Map<String,Object>> shopsmaplist = (List<Map<String,Object>>)list.get(3);//商铺数量结果
        List<Map<String,Object>> merchantmaplist = (List<Map<String,Object>>)list.get(4);//商家数量结果
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(usermaplist);
        viewResultAnaly.setProductResultList(productmaplist);
        viewResultAnaly.setShopResultList(shopsmaplist);
        viewResultAnaly.setMerchartResultList(merchantmaplist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;


    }

    @RequestMapping(value = "zhidinganaly",method = RequestMethod.POST)
    public String zhidinganaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<YinxiaoEntity> yinxiaoEntityList = yinxiaoService.zhidinganalyEntity();
        viewResultAnaly.setYinxiaoEntityList(yinxiaoEntityList);
        List<Object> list = yinxiaoService.zhidinganalyList();
        List<String> infolist = (List<String>)list.get(0);
        List<Map<String,Object>> usermaplist = (List<Map<String,Object>>)list.get(1);//用户数量结果
        List<Map<String,Object>> productmaplist = (List<Map<String,Object>>)list.get(2);//商品数量结果
        List<Map<String,Object>> shopsmaplist = (List<Map<String,Object>>)list.get(3);//商铺数量结果
        List<Map<String,Object>> merchantmaplist = (List<Map<String,Object>>)list.get(4);//商家数量结果
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(usermaplist);
        viewResultAnaly.setProductResultList(productmaplist);
        viewResultAnaly.setShopResultList(shopsmaplist);
        viewResultAnaly.setMerchartResultList(merchantmaplist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }
}
