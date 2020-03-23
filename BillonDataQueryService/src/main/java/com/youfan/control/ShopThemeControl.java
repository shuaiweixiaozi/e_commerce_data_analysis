package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.youfan.service.ShopThemeService;
import com.youfan.viewResult.KeyValueEntity;
import com.youfan.viewResult.ViewResultAnaly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("shopTheme")
@CrossOrigin
public class ShopThemeControl {

    @Autowired
    private ShopThemeService shopThemeService;

    @RequestMapping(value = "tuangoubytimeanaly",method = RequestMethod.POST)
    public String tuangoubytimeanaly(String startTime,String endTime){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyvalueEntitylist = shopThemeService.tuangoubytime(startTime,endTime);
        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "productTypebytimeanaly",method = RequestMethod.POST)
    public String productTypebytimeanaly(String startTime,String endTime){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyvalueEntitylist = shopThemeService.productTypebytime(startTime,endTime);
        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "hongbaobytimeanaly",method = RequestMethod.POST)
    public String hongbaobytimeanaly(String startTime,String endTime){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyvalueEntitylist = shopThemeService.hongbaobytime(startTime,endTime);
        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "cjbytimeanaly",method = RequestMethod.POST)
    public String cjbytimeanaly(String startTime,String endTime){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyvalueEntitylist = shopThemeService.cjbytime(startTime,endTime);
        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "userbytimeanaly",method = RequestMethod.POST)
    public String userbytimeanaly(String startTime,String endTime){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyvalueEntitylist = shopThemeService.userbytime(startTime,endTime);
        viewResultAnaly.setKeyValueEntityList(keyvalueEntitylist);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }
}