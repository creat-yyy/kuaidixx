package com.kuaidixx.kuaidixx.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class dateUtil {
    //将字符串类型的时间转换成date
    public static final String STANDARD="yyyy-MM-dd HH:mm:ss";
    public static Date String2Date(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD);
        return dateTimeFormatter.parseDateTime(date).toDate();
    }
    public static Date String2Date(String date,String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        return dateTimeFormatter.parseDateTime(date).toDate();
    }
    //将date类型的时间转换成字符串
    public static String Date2String(Date date){
        if(date==null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime =new DateTime(date);
        return dateTime.toString(STANDARD);

    }
    public static String Date2String(Date date,String format){
        if(date==null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime =new DateTime(date);
        return dateTime.toString(format);

    }
}
