package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import com.youfan.service.TimingTopService;
import com.youfan.viewResult.Cartcar;
import com.youfan.viewResult.DeviceEntity;
import com.youfan.viewResult.KeyValueEntity;
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
 * 实时排行
 */
@RestController
@RequestMapping("timingTop")
@CrossOrigin
public class TimingTopControl {

    @Autowired
    private TimingTopService timingTopService;

    @RequestMapping(value = "tuangouuserstop",method = RequestMethod.POST)
    public String tuangouuserstop(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyValueEntityList = timingTopService.tuangouuserstop();
        viewResultAnaly.setKeyValueEntityList(keyValueEntityList);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "producttypetop",method = RequestMethod.POST)
    public String producttypetop(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyValueEntityList = timingTopService.producttypetop();
        viewResultAnaly.setKeyValueEntityList(keyValueEntityList);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "producttop",method = RequestMethod.POST)
    public String producttop(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyValueEntityList = timingTopService.producttop();
        viewResultAnaly.setKeyValueEntityList(keyValueEntityList);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }

    @RequestMapping(value = "conpususerstop",method = RequestMethod.POST)
    public String conpususerstop(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyValueEntityList = timingTopService.conpususerstop();
        viewResultAnaly.setKeyValueEntityList(keyValueEntityList);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }
}
