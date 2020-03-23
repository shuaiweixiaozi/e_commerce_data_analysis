package com.youfan.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TransferUtil {
    private static Map<String,String> dataDictMap = new HashMap<String,String>();
    static {
        dataDictMap.put("orderinfo","com.youfan.jiaoyi.Orderinfo");
        dataDictMap.put("hongbaoinfo","com.youfan.yingxiao.Hongbaoinfo");
        dataDictMap.put("conpusinfo","com.youfan.yingxiao.Conpusinfo");
        dataDictMap.put("conpuslingquinfo","com.youfan.yingxiao.Conpuslingquinfo");
        dataDictMap.put("huodonginfo","com.youfan.yingxiao.Huodonginfo");
        dataDictMap.put("merchart","com.youfan.product.Merchart");
        dataDictMap.put("miaoshainfo","com.youfan.yingxiao.Miaoshainfo");
        dataDictMap.put("product","com.youfan.product.Product");
        dataDictMap.put("productdetail","com.youfan.product.Productdetail");
        dataDictMap.put("producttype","com.youfan.product.Producttype");
        dataDictMap.put("shopinfo","com.youfan.product.Shopinfo");
        dataDictMap.put("tuangouinfo","com.youfan.yingxiao.Tuangouinfo");
        dataDictMap.put("userinfo","com.youfan.product.Userinfo");
    }
    public static String transferData(String topicName,JSONObject data){
        String resultFinal = "";
        try {
            String className =  dataDictMap.get(topicName);
            Class orderinfo = Class.forName(className);
            Field[] fields = orderinfo.getDeclaredFields();
            for(Field field:fields){
                String name = field.getName();
                String result = data.getString(name)==null?"null":data.getString(name);
                resultFinal += result + ",";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resultFinal = resultFinal.substring(0,resultFinal.length()-1);
        return resultFinal;
    }

    public static void main(String[] args) throws Exception {
        String className = "com.youfan.jiaoyi.Orderinfo";
        Class orderinfo = Class.forName(className);
        Field[] fields = orderinfo.getDeclaredFields();
        for(Field field:fields){
            String name = field.getName();
            System.out.println(name);
        }
    }
}
