package com.kq.xxljob.demo.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CronUtil {


    /**
     * 每天执行1次
     * @param timeStr
     * @return
     */
    public static String everyDayCron(String timeStr) {
        LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
        String cronStr = time.format(DateTimeFormatter.ofPattern("ss mm HH * * ?"));
        return cronStr;
    }

}
