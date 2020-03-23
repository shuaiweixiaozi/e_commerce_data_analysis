package com.youfan.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateUtils {

    public static String getDayBreforeByNow(int days,String dateFormat){
        long currentTime = new Date().getTime();
        long beforeTime = currentTime - days*24*60*60*1000L;
        DateFormat dateFormat1 = new SimpleDateFormat(dateFormat);
        Date resultDate = new Date(beforeTime);

        String resultDateString = dateFormat1.format(resultDate);
        resultDate = new Date(currentTime);
        resultDateString =resultDateString+ "=="+dateFormat1.format(resultDate);
        return resultDateString;
    }

    public static Date getDateBy(String date,String dateFormat){
        DateFormat dateFormat1 = new SimpleDateFormat(dateFormat);
        Date result = null;
        try {
            result = dateFormat1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getDayBreforeByNow(7,"yyyy-MM-dd"));
    }
}
