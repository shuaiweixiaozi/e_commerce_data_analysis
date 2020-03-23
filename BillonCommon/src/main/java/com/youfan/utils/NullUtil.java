package com.youfan.utils;

import org.apache.commons.lang3.StringUtils;

public class NullUtil {
    public static String transferNull(String data){
        if(StringUtils.isBlank(data)){
            return "null";
        }else {
            return data;
        }
    }
}
