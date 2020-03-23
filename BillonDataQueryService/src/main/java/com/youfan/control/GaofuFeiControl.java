package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.youfan.service.GaofuFeiService;
import com.youfan.utils.DateUtils;
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
 * 高付费
 */
@RestController
@RequestMapping("gaofuFei")
@CrossOrigin
public class GaofuFeiControl {

    @Autowired
    private GaofuFeiService gaofuFeiService;

    @RequestMapping(value = "gffbypaytypeusersdaily",method = RequestMethod.POST)
    public String gffbypaytypeusersdaily(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        String dates = DateUtils.getDayBreforeByNow(30,"yyyy-MM-dd");
        String [] temps = dates.split("==");
        String startTime = temps[0];
        String endTime = temps[1];

        List<Object> result =  gaofuFeiService.getGffbypaytypeusers(startTime,endTime);
        List<String> infolist = (List<String>)result.get(0);
        List<Map<String,Object>> resultList = (List<Map<String,Object>>)result.get(1);
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setResultList(resultList);

        String resultFinal = JSONObject.toJSONString(viewResultAnaly);
        return resultFinal;

    }

    @RequestMapping(value = "gffbypaytypeamountdaily",method = RequestMethod.POST)
    public String gffbypaytypeamountdaily(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        String dates = DateUtils.getDayBreforeByNow(30,"yyyy-MM-dd");
        String [] temps = dates.split("==");
        String startTime = temps[0];
        String endTime = temps[1];

        List<Object> result =  gaofuFeiService.getGffbyAmount(startTime,endTime);
        List<String> infolist = (List<String>)result.get(0);
        List<Map<String,Object>> resultList = (List<Map<String,Object>>)result.get(1);
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setResultList(resultList);

        String resultFinal = JSONObject.toJSONString(viewResultAnaly);
        return resultFinal;

    }


    @RequestMapping(value = "gffbypaytypelargeamoutdaily",method = RequestMethod.POST)
    public String gffbypaytypelargeamoutdaily(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        String dates = DateUtils.getDayBreforeByNow(30,"yyyy-MM-dd");
        String [] temps = dates.split("==");
        String startTime = temps[0];
        String endTime = temps[1];

        List<Object> result =  gaofuFeiService.getGffbyLargeamout(startTime,endTime);
        List<String> infolist = (List<String>)result.get(0);
        List<Map<String,Object>> resultList = (List<Map<String,Object>>)result.get(1);
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setResultList(resultList);

        String resultFinal = JSONObject.toJSONString(viewResultAnaly);
        return resultFinal;

    }
}
