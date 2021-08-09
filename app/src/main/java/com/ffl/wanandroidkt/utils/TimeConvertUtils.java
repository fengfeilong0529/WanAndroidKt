package com.ffl.wanandroidkt.utils;

import android.text.TextUtils;
import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换
 */
public class TimeConvertUtils {
    public static final String formatString = "yyyy-MM-dd HH:mm:ss";
    public static final String formatString1 = "yyyy-MM-dd 00:00:00";
    public static final String formatString2 = "yyyyMMddHHmmss";
    public static final String formatString3 = "yyyyMMdd.HHmmss";
    public static final String formatString4 = "yyyy.MM.dd";
    public static final String formatString5 = "yyyyMMdd";
    public static final String formatString6 = "yyyyMMddHHmm";
    public static final String formatString7 = "yyyy.MM.dd HH:mm:ss";
    public static final String formatString8 = "yyyy.MM.dd.HH.mm.ss";
    public static final String formatString9 = "yyyy.MM.dd HH:mm";
    public static final String formatString10 = "yyyy-MM-dd";
    public static final String formatString11 = "HH:mm:ss";


    /**
     * 获取年月日时分秒的字符串
     * 输入: time, 表示毫秒数
     * 输出: 由 yyyy-MM-dd HH:mm:ss 表示的字符串
     */
    public static String longToString(long time) {
        return (String) DateFormat.format(formatString, time);
    }

    /**
     * 获取年月日时分秒的字符串
     *
     * @param inFormat 指明显示的字符串格式
     * @param time
     * @return
     */
    public static String longToString(String inFormat, long time) {
        return (String) DateFormat.format(inFormat, time);
    }

    /**
     * 将"yyyy-MM-dd HH:mm:ss"字符串转换毫秒时间
     * 输入：str 例如 2016-11-07 09:23:18
     * 输出：时间的毫秒数 millisSecond
     */
    public static long stringToLong(String str) {
        long result = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
            Date parse = simpleDateFormat.parse(str);
            result = parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 指定String的格式化字符，返回long型时间
     *
     * @param inFormat
     * @param str
     * @return
     */
    public static long stringToLong(String inFormat, String str) {
        long result = 0;
        if (!TextUtils.isEmpty(str)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inFormat);
            try {
                Date parse = simpleDateFormat.parse(str);
                result = parse.getTime();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 将 date 表示的时间转换成指定格式的字符串
     * 输入：Date表示日期时间
     * 输出："yyyy-MM-dd HH:mm:ss"格式的时间字符串
     */
    public static String dateToString(String inFormat, Date data) {
        return new SimpleDateFormat(inFormat).format(data);
    }

    public static String getCurrentDateAndTime() {
        return longToString(System.currentTimeMillis());
    }

    public static String getCurrentDate() {
        return longToString(formatString6, System.currentTimeMillis());
    }

    public static String getDetailDate() {
        return longToString(formatString2, System.currentTimeMillis());
    }

    public static long getDetailSecondMs(String dateTime) {
        return stringToLong(formatString2, dateTime);
    }
}

