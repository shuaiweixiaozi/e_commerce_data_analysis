package com.youfan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.youfan.dao.LiuLiangDao;
import com.youfan.service.LiuLiangService;
import com.youfan.utils.DateUtils;
import com.youfan.viewResult.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class LiuLiangServiceImpl implements LiuLiangService {
    static Map<Integer,String> devicetypedict = new HashMap<Integer,String>();
    static Map<Integer,String> opertorTypedict = new HashMap<Integer,String>();
    static{
        devicetypedict.put(1,"1种终端设备");
        devicetypedict.put(2,"2种终端设备");
        devicetypedict.put(3,"3种终端设备");
        opertorTypedict.put(1,"添加");
        opertorTypedict.put(2,"删除");
    }

    @Autowired
    private LiuLiangDao liuLiangDao;

    @Override
    public List<DeviceEntity> diviceTypeanaly() {
        List<Syletypestatistics> list = liuLiangDao.syletypestatistics();
        List<DeviceEntity> deviceEntityList =new ArrayList<DeviceEntity>();
        for(Syletypestatistics syletypestatistics:list){
            DeviceEntity deviceEntity = new DeviceEntity();
            deviceEntity.setTypename(devicetypedict.get(syletypestatistics.getStyleTypenum()));
            deviceEntity.setUsernum(syletypestatistics.getUserNum()+"");
            deviceEntity.setProductnum(syletypestatistics.getProductNum()+"");
            deviceEntityList.add(deviceEntity);
        }
        return deviceEntityList;
    }

    @Override
    public List<Object> diviceTypedailyanaly() {
        List<Syletypestatistics> list = liuLiangDao.syletypedaystatistics();
        Set<String> infoSet = new HashSet<String>();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        for(Syletypestatistics syletypestatistics:list){
            String dateInfo = syletypestatistics.getDateInfo();
            String styleTypeName = devicetypedict.get(syletypestatistics.getStyleTypenum());
            Integer userNum = syletypestatistics.getUserNum();
            Integer productNum = syletypestatistics.getProductNum();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(styleTypeName);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(dateInfo,userNum);
            mapusers.put(styleTypeName,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(styleTypeName);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(dateInfo,productNum);
            mapproducts.put(styleTypeName,tempMap);

            infoSet.add(dateInfo);
        }
        List<String> infolist = new ArrayList<String>();
        infolist.addAll(infoSet);
        Collections.sort(infolist, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Date date1 = DateUtils.getDateBy(o1,"yyyy-MM-dd");
                Date date2 = DateUtils.getDateBy(o2,"yyyy-MM-dd");
                return date1.compareTo(date2);
            }
        });
        List<Map<String,Object>> usermaplist = new ArrayList<Map<String,Object>>();//用户数量结果
        List<Map<String,Object>> productmaplist = new ArrayList<Map<String,Object>>();//商品数量结果
        /**
         * 用户
         */
        Set<Map.Entry<String,Map<String,Object>>> entrySet = mapusers.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            usermaplist.add(maptemp);
        }
        /**
         * 商品
         */
        entrySet = mapproducts.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            productmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        return finalResultList;
    }

    @Override
    public List<Object> diviceTypemonthlyanaly() {
        List<Syletypestatistics> list = liuLiangDao.syletypemonthstatistics();
        Set<String> infoSet = new HashSet<String>();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        for(Syletypestatistics syletypestatistics:list){
            String monthTime = syletypestatistics.getMonthTime();
            String styleTypeName = devicetypedict.get(syletypestatistics.getStyleTypenum());
            Integer userNum = syletypestatistics.getUserNum();
            Integer productNum = syletypestatistics.getProductNum();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(styleTypeName);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,userNum);
            mapusers.put(styleTypeName,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(styleTypeName);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,productNum);
            mapproducts.put(styleTypeName,tempMap);

            infoSet.add(monthTime);
        }
        List<String> infolist = new ArrayList<String>();
        infolist.addAll(infoSet);
        Collections.sort(infolist, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Date date1 = DateUtils.getDateBy(o1,"yyyy-MM-dd");
                Date date2 = DateUtils.getDateBy(o2,"yyyy-MM-dd");
                return date1.compareTo(date2);
            }
        });
        List<Map<String,Object>> usermaplist = new ArrayList<Map<String,Object>>();//用户数量结果
        List<Map<String,Object>> productmaplist = new ArrayList<Map<String,Object>>();//商品数量结果
        /**
         * 用户
         */
        Set<Map.Entry<String,Map<String,Object>>> entrySet = mapusers.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            usermaplist.add(maptemp);
        }
        /**
         * 商品
         */
        entrySet = mapproducts.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            productmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        return finalResultList;
    }

    @Override
    public List<Cartcar> cartcaranaly() {
        List<Cartcarstatistics> list = liuLiangDao.cartcarstatistics();
        List<Cartcar> cartcarList =new ArrayList<Cartcar>();
        for(Cartcarstatistics cartcarstatistics:list){
            Cartcar cartcar = new Cartcar();
            //0-10,10-30,30-60,60-
            int oppertorNum = cartcarstatistics.getOpertorNum();
            String oppertorRange = oppertorNum>0 && oppertorNum <10?"0-10"
                    :oppertorNum>=10 && oppertorNum <30?"10-30"
                    :oppertorNum>=30 && oppertorNum <60?"30-60":"60以上";
            String opertorTypeName = opertorTypedict.get(cartcarstatistics.getOpertorType());
            int productNum = cartcarstatistics.getProductNum();
            int userNum = cartcarstatistics.getUserNum();
            cartcar.setOpeterRange(oppertorRange);
            cartcar.setProductnum(productNum+"");
            cartcar.setUsernum(userNum+"");
            cartcar.setTypename(opertorTypeName);
            cartcarList.add(cartcar);
        }
        return cartcarList;
    }

    @Override
    public List<Object> cartcardailyanaly() {
        List<Cartcarstatistics> list = liuLiangDao.cartcardaystatistics();
        Set<String> infoSet = new HashSet<String>();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        for(Cartcarstatistics cartcarstatistics:list){
            String dateInfo = cartcarstatistics.getDateinfo();
            int oppertorNum = cartcarstatistics.getOpertorNum();
            String oppertorRange = oppertorNum>0 && oppertorNum <10?"0-10"
                    :oppertorNum>=10 && oppertorNum <30?"10-30"
                    :oppertorNum>=30 && oppertorNum <60?"30-60":"60以上";
            String opertorTypeName = opertorTypedict.get(cartcarstatistics.getOpertorType());
            int productNum = cartcarstatistics.getProductNum();
            int userNum = cartcarstatistics.getUserNum();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(opertorTypeName+"=="+oppertorRange);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(dateInfo,userNum);
            mapusers.put(opertorTypeName+"=="+oppertorRange,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(opertorTypeName+"=="+oppertorRange);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(dateInfo,productNum);
            mapproducts.put(opertorTypeName+"=="+oppertorRange,tempMap);

            infoSet.add(dateInfo);
        }
        List<String> infolist = new ArrayList<String>();
        infolist.addAll(infoSet);
        Collections.sort(infolist, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Date date1 = DateUtils.getDateBy(o1,"yyyy-MM-dd");
                Date date2 = DateUtils.getDateBy(o2,"yyyy-MM-dd");
                return date1.compareTo(date2);
            }
        });
        List<Map<String,Object>> usermaplist = new ArrayList<Map<String,Object>>();//用户数量结果
        List<Map<String,Object>> productmaplist = new ArrayList<Map<String,Object>>();//商品数量结果
        /**
         * 用户
         */
        Set<Map.Entry<String,Map<String,Object>>> entrySet = mapusers.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            usermaplist.add(maptemp);
        }
        /**
         * 商品
         */
        entrySet = mapproducts.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            productmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        return finalResultList;
    }

    @Override
    public List<Object> cartcarmonthlyanaly() {
        List<Cartcarstatistics> list = liuLiangDao.cartcarmonthstatistics();
        Set<String> infoSet = new HashSet<String>();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        for(Cartcarstatistics cartcarstatistics:list){
            String monthTime = cartcarstatistics.getMonthTime();
            int oppertorNum = cartcarstatistics.getOpertorNum();
            String oppertorRange = oppertorNum>0 && oppertorNum <10?"0-10"
                    :oppertorNum>=10 && oppertorNum <30?"10-30"
                    :oppertorNum>=30 && oppertorNum <60?"30-60":"60以上";
            String opertorTypeName = opertorTypedict.get(cartcarstatistics.getOpertorType());
            int productNum = cartcarstatistics.getProductNum();
            int userNum = cartcarstatistics.getUserNum();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(opertorTypeName+"=="+oppertorRange);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,userNum);
            mapusers.put(opertorTypeName+"=="+oppertorRange,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(opertorTypeName+"=="+oppertorRange);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,productNum);
            mapproducts.put(opertorTypeName+"=="+oppertorRange,tempMap);

            infoSet.add(monthTime);
        }
        List<String> infolist = new ArrayList<String>();
        infolist.addAll(infoSet);
        Collections.sort(infolist, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Date date1 = DateUtils.getDateBy(o1,"yyyy-MM-dd");
                Date date2 = DateUtils.getDateBy(o2,"yyyy-MM-dd");
                return date1.compareTo(date2);
            }
        });
        List<Map<String,Object>> usermaplist = new ArrayList<Map<String,Object>>();//用户数量结果
        List<Map<String,Object>> productmaplist = new ArrayList<Map<String,Object>>();//商品数量结果
        /**
         * 用户
         */
        Set<Map.Entry<String,Map<String,Object>>> entrySet = mapusers.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            usermaplist.add(maptemp);
        }
        /**
         * 商品
         */
        entrySet = mapproducts.entrySet();
        for(Map.Entry<String,Map<String,Object>> entry:entrySet){
            String key = entry.getKey();
            Map<String,Object> maptemp = new HashMap<String,Object>();
            Map<String,Object> map22 = entry.getValue();
            List<Object> datalist = new ArrayList<Object>();
            for(String time :infolist){
                Object o = map22.get(time)==null?0:map22.get(time);
                datalist.add(o);
            }
            maptemp.put("name",key);
            maptemp.put("data",datalist);
            productmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        return finalResultList;
    }
}
