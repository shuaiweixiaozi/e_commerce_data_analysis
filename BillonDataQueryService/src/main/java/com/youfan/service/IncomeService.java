package com.youfan.service;

import java.util.List;
import java.util.Map;

public interface IncomeService {
    List<Object> getlDailyIncome(String strartTime, String endTime);
    List<Object> getlDailyIncomeByPaytype(String strartTime, String endTime);
    List<Object> getlDailyIncomeByprtype(String strartTime, String endTime);
}
