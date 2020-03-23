package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.youfan.service.UserThemeService;
import com.youfan.viewResult.KeyValueEntity;
import com.youfan.viewResult.ViewResultAnaly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 团购次数
 * 最大团购名称和团购人数
 * 优惠劵次数
 * 红包次数
 * 浏览商品次数
 * 浏览最多次商品名称
 * 最常使用终端
 */
@RestController
@RequestMapping("userTheme")
@CrossOrigin
public class UserThemeControl {
    @Autowired
    private UserThemeService userThemeService;

    @RequestMapping(value = "useranaly",method = RequestMethod.POST)
    public String useranaly(String userId){
        ViewResultAnaly viewResultAnaly = new ViewResultAnaly();
        List<KeyValueEntity> keyValueEntityList = userThemeService.useranaly(userId);
        viewResultAnaly.setKeyValueEntityList(keyValueEntityList);
        String result = JSONObject.toJSONString(viewResultAnaly);
        return result;

    }
}
