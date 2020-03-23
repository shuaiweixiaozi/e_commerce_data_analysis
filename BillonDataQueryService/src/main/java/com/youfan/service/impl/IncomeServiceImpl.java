package com.youfan.service.impl;

import com.youfan.service.IncomeService;
import com.youfan.utils.DateUtils;
import com.youfan.utils.MysqlUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.*;

@Service
public class IncomeServiceImpl implements IncomeService {

    private static Connection connection = MysqlUtils.getConnection();

    @Override
    public List<Object> getlDailyIncome(String strartTime, String endTime) {
        String sql="select payTime,sum(payAmount) from dapanorderinfo where payTime >= ? and payTime <= ? group by payTime ";
        List<Object> finalResultList = new ArrayList<Object>();
        List<String> infolist = new ArrayList<String>();
        List<Object> dataList = new ArrayList<Object>();
        List<Map<String,Object>> listmap = new ArrayList<Map<String,Object>>();
        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            ptmt.setString(1, strartTime);
            ptmt.setString(2,endTime);
            ResultSet resultSet = ptmt.executeQuery();//执行给定的SQL语句，该语句可能返回多个结果
            while(resultSet.next()){
                String payTime = resultSet.getString(1);
                double totalAmount = resultSet.getDouble(2);
                infolist.add(payTime);
                dataList.add(totalAmount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","每日收入");
        map.put("data",dataList);
        listmap.add(map);
        finalResultList.add(infolist);
        finalResultList.add(listmap);
        return finalResultList;
    }

    @Override
    public List<Object> getlDailyIncomeByPaytype(String strartTime, String endTime) {
        String sql="select payTime,payType,sum(payAmount) from dapanorderinfo where payTime >= ? and payTime <= ? group by payTime,payType";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Set<String> infoSet = new HashSet<String>();
        Map<String,Map<String,Object>> map = new HashMap<String,Map<String,Object>>();
        try {
            ptmt.setString(1, strartTime);
            ptmt.setString(2,endTime);
            ResultSet resultSet = ptmt.executeQuery();//执行给定的SQL语句，该语句可能返回多个结果

            while(resultSet.next()){
                String payTime = resultSet.getString(1);
                String payType = resultSet.getString(2);
                double totalAmount = resultSet.getDouble(3);
                Map<String,Object> tempMap = map.get(payType);
                tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
                tempMap.put(payTime,totalAmount);
                map.put(payType,tempMap);
                infoSet.add(payTime);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
        Set<Map.Entry<String,Map<String,Object>>> entrySet = map.entrySet();
        List<Map<String,Object>> listmap = new ArrayList<Map<String,Object>>();
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
            listmap.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(listmap);
        return finalResultList;
    }

    @Override
    public List<Object> getlDailyIncomeByprtype(String strartTime, String endTime) {
        String sql="select payTime,productTypeName,sum(payAmount) from dapanorderinfo where payTime >= ? and payTime <= ? group by payTime,productTypeName";

        java.sql.PreparedStatement ptmt = null;
        try {
            ptmt = connection.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Set<String> infoSet = new HashSet<String>();
        Map<String,Map<String,Object>> map = new HashMap<String,Map<String,Object>>();
        try {
            ptmt.setString(1, strartTime);
            ptmt.setString(2,endTime);
            ResultSet resultSet = ptmt.executeQuery();//执行给定的SQL语句，该语句可能返回多个结果

            while(resultSet.next()){
                String payTime = resultSet.getString(1);
                String productTypeName = resultSet.getString(2);
                double totalAmount = resultSet.getDouble(3);
                Map<String,Object> tempMap = map.get(productTypeName);
                tempMap = tempMap==null?new HashMap<String,Object>():tempMap;
                tempMap.put(payTime,totalAmount);
                map.put(productTypeName,tempMap);
                infoSet.add(payTime);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
        Set<Map.Entry<String,Map<String,Object>>> entrySet = map.entrySet();
        List<Map<String,Object>> listmap = new ArrayList<Map<String,Object>>();
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
            listmap.add(maptemp);
        }
        List<Object> finalResultList = new ArrayList<Object>();
        finalResultList.add(infolist);
        finalResultList.add(listmap);
        return finalResultList;
    }

}
