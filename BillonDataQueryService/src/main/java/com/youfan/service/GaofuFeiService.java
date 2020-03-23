package com.youfan.service;

import java.util.List;
import java.util.Map;

public interface GaofuFeiService {
    List<Object> getGffbypaytypeusers(String strartTime, String endTime);
    List<Object> getGffbyAmount(String strartTime, String endTime);
    List<Object> getGffbyLargeamout(String strartTime, String endTime);
}
