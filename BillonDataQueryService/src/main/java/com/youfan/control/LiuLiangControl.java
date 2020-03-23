package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.youfan.service.LiuLiangService;
import com.youfan.viewResult.Cartcar;
import com.youfan.viewResult.DeviceEntity;
import com.youfan.viewResult.ViewResultAnaly;
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
 * 流量域
 */
@RestController
@RequestMapping("liuLiang")
@CrossOrigin
public class LiuLiangControl {

    @Autowired
    private LiuLiangService liuLiangService;

    @RequestMapping(value = "diviceTypeanaly",method = RequestMethod.POST)
    public String diviceTypeanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<DeviceEntity> deviceEntityList = liuLiangService.diviceTypeanaly();
        viewResultAnaly.setDeviceEntityList(deviceEntityList);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "diviceTypedailyanaly",method = RequestMethod.POST)
    public String diviceTypedailyanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<Object> resultList = liuLiangService.diviceTypedailyanaly();
        List<String> infolist = (List<String>)resultList.get(0);
        List<Map<String,Object>> userMaplist = (List<Map<String,Object>>)resultList.get(1);
        List<Map<String,Object>> productMaplist = (List<Map<String,Object>>)resultList.get(2);

        //--模拟构造数据 end
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(userMaplist);
        viewResultAnaly.setProductResultList(productMaplist);

        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }


    @RequestMapping(value = "diviceTypemonthlyanaly",method = RequestMethod.POST)
    public String diviceTypemonthlyanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<Object> resultList = liuLiangService.diviceTypemonthlyanaly();
        List<String> infolist = (List<String>)resultList.get(0);
        List<Map<String,Object>> userMaplist = (List<Map<String,Object>>)resultList.get(1);
        List<Map<String,Object>> productMaplist = (List<Map<String,Object>>)resultList.get(2);

        //--模拟构造数据 end
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(userMaplist);
        viewResultAnaly.setProductResultList(productMaplist);

        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }


    @RequestMapping(value = "cartcaranaly",method = RequestMethod.POST)
    public String cartcaranaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<Cartcar> cartcarList = liuLiangService.cartcaranaly();
        viewResultAnaly.setCartcarList(cartcarList);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "cartcardailyanaly",method = RequestMethod.POST)
    public String cartcardailyanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<Object> resultList = liuLiangService.cartcardailyanaly();
        List<String> infolist = (List<String>)resultList.get(0);
        List<Map<String,Object>> userMaplist = (List<Map<String,Object>>)resultList.get(1);
        List<Map<String,Object>> productMaplist = (List<Map<String,Object>>)resultList.get(2);

        //--模拟构造数据 end
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(userMaplist);
        viewResultAnaly.setProductResultList(productMaplist);

        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }


    @RequestMapping(value = "cartcarmonthlyanaly",method = RequestMethod.POST)
    public String cartcarmonthlyanaly(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<Object> resultList = liuLiangService.cartcarmonthlyanaly();
        List<String> infolist = (List<String>)resultList.get(0);
        List<Map<String,Object>> userMaplist = (List<Map<String,Object>>)resultList.get(1);
        List<Map<String,Object>> productMaplist = (List<Map<String,Object>>)resultList.get(2);

        //--模拟构造数据 end
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setUserResultList(userMaplist);
        viewResultAnaly.setProductResultList(productMaplist);

        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }
}
