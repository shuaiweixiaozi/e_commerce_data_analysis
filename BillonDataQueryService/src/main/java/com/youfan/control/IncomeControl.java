package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.youfan.service.IncomeService;
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
 * 大盘收入
 */
@RestController
@RequestMapping("income")
@CrossOrigin
public class IncomeControl {

    @Autowired
    private IncomeService incomeService;

    @RequestMapping(value = "totalDailyIncome",method = RequestMethod.POST)
    public String totalDailyIncome(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        String dates = DateUtils.getDayBreforeByNow(30,"yyyy-MM-dd");
        String [] temps = dates.split("==");
        String startTime = temps[0];
        String endTime = temps[1];

        List<Object> result =  incomeService.getlDailyIncome(startTime,endTime);
        List<String> infolist = (List<String>)result.get(0);
        List<Map<String,Object>> resultList = (List<Map<String,Object>>)result.get(1);
        Map<String,Object> map = resultList.get(0);
        List<Object> countlist = (List<Object>)map.get("data");
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setCountlist(countlist);
        String resultFinal = JSONObject.toJSONString(viewResultAnaly);
        return resultFinal;
    }

    @RequestMapping(value = "totalDailyIncomeByPaytype",method = RequestMethod.POST)
    public String totalDailyByPaytypeIncome(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        String dates = DateUtils.getDayBreforeByNow(30,"yyyy-MM-dd");
        String [] temps = dates.split("==");
        String startTime = temps[0];
        String endTime = temps[1];

        List<Object> result =  incomeService.getlDailyIncomeByPaytype(startTime,endTime);
        List<String> infolist = (List<String>)result.get(0);
        List<Map<String,Object>> resultList = (List<Map<String,Object>>)result.get(1);
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setResultList(resultList);

        String resultFinal = JSONObject.toJSONString(viewResultAnaly);
        return resultFinal;

    }


    @RequestMapping(value = "totalDailyByprtypetypeIncome",method = RequestMethod.POST)
    public String totalDailyByprtypetypeIncome(){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        String dates = DateUtils.getDayBreforeByNow(30,"yyyy-MM-dd");
        String [] temps = dates.split("==");
        String startTime = temps[0];
        String endTime = temps[1];

        List<Object> result =  incomeService.getlDailyIncomeByprtype(startTime,endTime);
        List<String> infolist = (List<String>)result.get(0);
        List<Map<String,Object>> resultList = (List<Map<String,Object>>)result.get(1);
        viewResultAnaly.setInfolist(infolist);
        viewResultAnaly.setResultList(resultList);

        String resultFinal = JSONObject.toJSONString(viewResultAnaly);
        return resultFinal;

    }
}
