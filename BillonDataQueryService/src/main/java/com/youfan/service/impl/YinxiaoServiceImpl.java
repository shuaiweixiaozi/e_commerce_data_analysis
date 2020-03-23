package com.youfan.service.impl;

import com.youfan.dao.YinxiaoDao;
import com.youfan.service.YinxiaoService;
import com.youfan.utils.DateUtils;
import com.youfan.viewResult.Syletypestatistics;
import com.youfan.viewResult.ViewResultAnaly;
import com.youfan.viewResult.YinxiaoEntity;
import com.youfan.viewResult.YinxiaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class YinxiaoServiceImpl implements YinxiaoService {
    static Map<Integer,String> yingxiaoflagdict = new HashMap<Integer,String>();
    static Map<Integer,String> statusflagdict = new HashMap<Integer,String>();
    static{
        yingxiaoflagdict.put(1,"0-10次");
        yingxiaoflagdict.put(2,"10-30次");
        yingxiaoflagdict.put(3,"30-60次");
        yingxiaoflagdict.put(4,"60-次");
        statusflagdict.put(0,"未支付");
        statusflagdict.put(1,"已支付");
    }

    @Autowired
    private YinxiaoDao yinxiaoDao;


    @Override
    public List<YinxiaoEntity> hongbaoanalyEntity() {
        List<YinxiaoResult> list = yinxiaoDao.hongbaoStatistics();
        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();
        for(YinxiaoResult yinxiaoResult:list){
            int hongbaoflag = yinxiaoResult.getHongbaoflag();
            int statusflag = yinxiaoResult.getStatusflag();
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
            yinxiaoEntity.setNumRange(yingxiaoflagdict.get(hongbaoflag));
            yinxiaoEntity.setStatus(statusflagdict.get(statusflag));
            yinxiaoEntity.setUsernums(usernums+"");
            yinxiaoEntity.setProductnums(productnums+"");
            yinxiaoEntity.setShopnums(shopnums+"");
            yinxiaoEntity.setMerchatnums(merchartnums+"");
            yinxiaoEntityList.add(yinxiaoEntity);
        }
        return yinxiaoEntityList;
    }

    @Override
    public List<Object> hongbaoanalyList() {
        List<YinxiaoResult> list = yinxiaoDao.hongbaoMonthStatistics();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapshops = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapmerchant = new HashMap<String,Map<String,Object>>();
        Set<String> infoSet = new HashSet<String>();
        for(YinxiaoResult yinxiaoResult:list){
            int hongbaoflag = yinxiaoResult.getHongbaoflag();
            String monthTime = yinxiaoResult.getMonthTime();
            String numRange = yingxiaoflagdict.get(hongbaoflag);
            int statusflag = yinxiaoResult.getStatusflag();
            String statusflagString = statusflagdict.get(statusflag);
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,usernums);
            mapusers.put(numRange+"=="+statusflagString,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,productnums);
            mapproducts.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 店铺
             */
            tempMap = mapshops.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,shopnums);
            mapshops.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 商家
             */
            tempMap = mapmerchant.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,merchartnums);
            mapmerchant.put(numRange+"=="+statusflagString,tempMap);
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
        List<Map<String,Object>> shopsmaplist = new ArrayList<Map<String,Object>>();//商铺数量结果
        List<Map<String,Object>> merchantmaplist = new ArrayList<Map<String,Object>>();//商家数量结果
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
        /**
         * 商铺
         */
        entrySet = mapshops.entrySet();
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
            shopsmaplist.add(maptemp);
        }
        /**
         * 商家
         */
        entrySet = mapmerchant.entrySet();
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
            merchantmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        finalResultList.add(shopsmaplist);
        finalResultList.add(merchantmaplist);
        return finalResultList;
    }

    @Override
    public List<YinxiaoEntity> miaoshaanalyEntity() {
        List<YinxiaoResult> list = yinxiaoDao.miaoshaStatistics();
        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();
        for(YinxiaoResult yinxiaoResult:list){
            int miaoshaflag = yinxiaoResult.getMiaoshaflag();
            int statusflag = yinxiaoResult.getStatusflag();
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
            yinxiaoEntity.setNumRange(yingxiaoflagdict.get(miaoshaflag));
            yinxiaoEntity.setStatus(statusflagdict.get(statusflag));
            yinxiaoEntity.setUsernums(usernums+"");
            yinxiaoEntity.setProductnums(productnums+"");
            yinxiaoEntity.setShopnums(shopnums+"");
            yinxiaoEntity.setMerchatnums(merchartnums+"");
            yinxiaoEntityList.add(yinxiaoEntity);
        }
        return yinxiaoEntityList;
    }

    @Override
    public List<Object> miaoshaanalyList() {
        List<YinxiaoResult> list = yinxiaoDao.miaoshaMonthStatistics();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapshops = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapmerchant = new HashMap<String,Map<String,Object>>();
        Set<String> infoSet = new HashSet<String>();
        for(YinxiaoResult yinxiaoResult:list){
            int miaoshaflag = yinxiaoResult.getMiaoshaflag();
            String monthTime = yinxiaoResult.getMonthTime();
            String numRange = yingxiaoflagdict.get(miaoshaflag);
            int statusflag = yinxiaoResult.getStatusflag();
            String statusflagString = statusflagdict.get(statusflag);
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,usernums);
            mapusers.put(numRange+"=="+statusflagString,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,productnums);
            mapproducts.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 店铺
             */
            tempMap = mapshops.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,shopnums);
            mapshops.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 商家
             */
            tempMap = mapmerchant.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,merchartnums);
            mapmerchant.put(numRange+"=="+statusflagString,tempMap);
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
        List<Map<String,Object>> shopsmaplist = new ArrayList<Map<String,Object>>();//商铺数量结果
        List<Map<String,Object>> merchantmaplist = new ArrayList<Map<String,Object>>();//商家数量结果
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
        /**
         * 商铺
         */
        entrySet = mapshops.entrySet();
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
            shopsmaplist.add(maptemp);
        }
        /**
         * 商家
         */
        entrySet = mapmerchant.entrySet();
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
            merchantmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        finalResultList.add(shopsmaplist);
        finalResultList.add(merchantmaplist);
        return finalResultList;
    }

    @Override
    public List<YinxiaoEntity> tuangouanalyEntity() {
        List<YinxiaoResult> list = yinxiaoDao.tuangouStatistics();
        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();
        for(YinxiaoResult yinxiaoResult:list){
            int tuangouflag = yinxiaoResult.getTuangouflag();
            int statusflag = yinxiaoResult.getStatusflag();
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
            yinxiaoEntity.setNumRange(yingxiaoflagdict.get(tuangouflag));
            yinxiaoEntity.setStatus(statusflagdict.get(statusflag));
            yinxiaoEntity.setUsernums(usernums+"");
            yinxiaoEntity.setProductnums(productnums+"");
            yinxiaoEntity.setShopnums(shopnums+"");
            yinxiaoEntity.setMerchatnums(merchartnums+"");
            yinxiaoEntityList.add(yinxiaoEntity);
        }
        return yinxiaoEntityList;
    }

    @Override
    public List<Object> tuangouanalyList() {
        List<YinxiaoResult> list = yinxiaoDao.tuangouMonthStatistics();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapshops = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapmerchant = new HashMap<String,Map<String,Object>>();
        Set<String> infoSet = new HashSet<String>();
        for(YinxiaoResult yinxiaoResult:list){
            int tuangouflag = yinxiaoResult.getTuangouflag();
            String monthTime = yinxiaoResult.getMonthTime();
            String numRange = yingxiaoflagdict.get(tuangouflag);
            int statusflag = yinxiaoResult.getStatusflag();
            String statusflagString = statusflagdict.get(statusflag);
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,usernums);
            mapusers.put(numRange+"=="+statusflagString,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,productnums);
            mapproducts.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 店铺
             */
            tempMap = mapshops.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,shopnums);
            mapshops.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 商家
             */
            tempMap = mapmerchant.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,merchartnums);
            mapmerchant.put(numRange+"=="+statusflagString,tempMap);
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
        List<Map<String,Object>> shopsmaplist = new ArrayList<Map<String,Object>>();//商铺数量结果
        List<Map<String,Object>> merchantmaplist = new ArrayList<Map<String,Object>>();//商家数量结果
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
        /**
         * 商铺
         */
        entrySet = mapshops.entrySet();
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
            shopsmaplist.add(maptemp);
        }
        /**
         * 商家
         */
        entrySet = mapmerchant.entrySet();
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
            merchantmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        finalResultList.add(shopsmaplist);
        finalResultList.add(merchantmaplist);
        return finalResultList;
    }

    @Override
    public List<YinxiaoEntity> conpusanalyEntity() {
        List<YinxiaoResult> list = yinxiaoDao.conpusStatistics();
        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();
        for(YinxiaoResult yinxiaoResult:list){
            int conpusflag = yinxiaoResult.getConpusflag();
            int statusflag = yinxiaoResult.getStatusflag();
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
            yinxiaoEntity.setNumRange(yingxiaoflagdict.get(conpusflag));
            yinxiaoEntity.setStatus(statusflagdict.get(statusflag));
            yinxiaoEntity.setUsernums(usernums+"");
            yinxiaoEntity.setProductnums(productnums+"");
            yinxiaoEntity.setShopnums(shopnums+"");
            yinxiaoEntity.setMerchatnums(merchartnums+"");
            yinxiaoEntityList.add(yinxiaoEntity);
        }
        return yinxiaoEntityList;
    }

    @Override
    public List<Object> conpusanalyList() {
        List<YinxiaoResult> list = yinxiaoDao.conpusMonthStatistics();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapshops = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapmerchant = new HashMap<String,Map<String,Object>>();
        Set<String> infoSet = new HashSet<String>();
        for(YinxiaoResult yinxiaoResult:list){
            int conpusflag = yinxiaoResult.getConpusflag();
            String monthTime = yinxiaoResult.getMonthTime();
            String numRange = yingxiaoflagdict.get(conpusflag);
            int statusflag = yinxiaoResult.getStatusflag();
            String statusflagString = statusflagdict.get(statusflag);
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,usernums);
            mapusers.put(numRange+"=="+statusflagString,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,productnums);
            mapproducts.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 店铺
             */
            tempMap = mapshops.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,shopnums);
            mapshops.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 商家
             */
            tempMap = mapmerchant.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,merchartnums);
            mapmerchant.put(numRange+"=="+statusflagString,tempMap);
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
        List<Map<String,Object>> shopsmaplist = new ArrayList<Map<String,Object>>();//商铺数量结果
        List<Map<String,Object>> merchantmaplist = new ArrayList<Map<String,Object>>();//商家数量结果
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
        /**
         * 商铺
         */
        entrySet = mapshops.entrySet();
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
            shopsmaplist.add(maptemp);
        }
        /**
         * 商家
         */
        entrySet = mapmerchant.entrySet();
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
            merchantmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        finalResultList.add(shopsmaplist);
        finalResultList.add(merchantmaplist);
        return finalResultList;
    }

    @Override
    public List<YinxiaoEntity> zhidinganalyEntity() {
        List<YinxiaoResult> list = yinxiaoDao.huodongStatistics();
        List<YinxiaoEntity> yinxiaoEntityList =new ArrayList<YinxiaoEntity>();
        for(YinxiaoResult yinxiaoResult:list){
            int huodongflag = yinxiaoResult.getHuodongflag();
            int statusflag = yinxiaoResult.getStatusflag();
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            YinxiaoEntity yinxiaoEntity = new YinxiaoEntity();
            yinxiaoEntity.setNumRange(yingxiaoflagdict.get(huodongflag));
            yinxiaoEntity.setStatus(statusflagdict.get(statusflag));
            yinxiaoEntity.setUsernums(usernums+"");
            yinxiaoEntity.setProductnums(productnums+"");
            yinxiaoEntity.setShopnums(shopnums+"");
            yinxiaoEntity.setMerchatnums(merchartnums+"");
            yinxiaoEntityList.add(yinxiaoEntity);
        }
        return yinxiaoEntityList;
    }

    @Override
    public List<Object> zhidinganalyList() {
        List<YinxiaoResult> list = yinxiaoDao.huodongMonthStatistics();
        Map<String,Map<String,Object>> mapusers = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapproducts = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapshops = new HashMap<String,Map<String,Object>>();
        Map<String,Map<String,Object>> mapmerchant = new HashMap<String,Map<String,Object>>();
        Set<String> infoSet = new HashSet<String>();
        for(YinxiaoResult yinxiaoResult:list){
            int huodongflag = yinxiaoResult.getHuodongflag();
            String monthTime = yinxiaoResult.getMonthTime();
            String numRange = yingxiaoflagdict.get(huodongflag);
            int statusflag = yinxiaoResult.getStatusflag();
            String statusflagString = statusflagdict.get(statusflag);
            int usernums = yinxiaoResult.getUsernums();
            int productnums = yinxiaoResult.getProductnums();
            int shopnums = yinxiaoResult.getShopnums();
            int merchartnums = yinxiaoResult.getMerchartnums();
            /**
             * 用户
             */
            Map<String,Object> tempMap = mapusers.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,usernums);
            mapusers.put(numRange+"=="+statusflagString,tempMap);
            /**
             * 商品
             */
            tempMap = mapproducts.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,productnums);
            mapproducts.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 店铺
             */
            tempMap = mapshops.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,shopnums);
            mapshops.put(numRange+"=="+statusflagString,tempMap);

            /**
             * 商家
             */
            tempMap = mapmerchant.get(numRange+"=="+statusflagString);
            tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
            tempMap.put(monthTime,merchartnums);
            mapmerchant.put(numRange+"=="+statusflagString,tempMap);
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
        List<Map<String,Object>> shopsmaplist = new ArrayList<Map<String,Object>>();//商铺数量结果
        List<Map<String,Object>> merchantmaplist = new ArrayList<Map<String,Object>>();//商家数量结果
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
        /**
         * 商铺
         */
        entrySet = mapshops.entrySet();
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
            shopsmaplist.add(maptemp);
        }
        /**
         * 商家
         */
        entrySet = mapmerchant.entrySet();
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
            merchantmaplist.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(usermaplist);
        finalResultList.add(productmaplist);
        finalResultList.add(shopsmaplist);
        finalResultList.add(merchantmaplist);
        return finalResultList;
    }
}
