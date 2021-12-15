package com.ffl.wanandroidkt.utils

import android.annotation.SuppressLint
import android.text.TextUtils
import android.text.format.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * 时间转换
 */
object TimeConvertUtils {

    val formatString = "yyyy-MM-dd HH:mm:ss"
    val formatString12 = "yyyy-MM-dd HH:mm"
    val formatString1 = "yyyy-MM-dd 00:00:00"
    val formatString2 = "yyyyMMddHHmmss"
    val formatString3 = "yyyyMMdd.HHmmss"
    val formatString4 = "yyyy.MM.dd"
    val formatString5 = "yyyyMMdd"
    val formatString6 = "yyyyMMddHHmm"
    val formatString7 = "yyyy.MM.dd HH:mm:ss"
    val formatString8 = "yyyy.MM.dd.HH.mm.ss"
    val formatString9 = "yyyy.MM.dd HH:mm"
    val formatString10 = "yyyy-MM-dd"
    val formatString11 = "HH:mm:ss"

    val currentDateAndTime: String
        get() = longToString(System.currentTimeMillis())

    val currentDate: String
        get() = longToString(formatString6, System.currentTimeMillis())

    val detailDate: String
        get() = longToString(formatString2, System.currentTimeMillis())

    /**
     * 获取年月日时分秒的字符串
     * 输入: time, 表示毫秒数
     * 输出: 由 yyyy-MM-dd HH:mm:ss 表示的字符串
     */
    fun longToString(time: Long): String {
        return DateFormat.format(formatString, time) as String
    }

    /**
     * 获取年月日时分秒的字符串
     *
     * @param inFormat 指明显示的字符串格式
     * @param time
     * @return
     */
    fun longToString(inFormat: String, time: Long): String {
        return DateFormat.format(inFormat, time) as String
    }

    /**
     * 将"yyyy-MM-dd HH:mm:ss"字符串转换毫秒时间
     * 输入：str 例如 2016-11-07 09:23:18
     * 输出：时间的毫秒数 millisSecond
     */
    @SuppressLint("SimpleDateFormat")
    fun stringToLong(str: String): Long {
        var result: Long = 0
        try {
            val simpleDateFormat = SimpleDateFormat(formatString)
            val parse = simpleDateFormat.parse(str)
            result = parse.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return result
    }

    /**
     * 指定String的格式化字符，返回long型时间
     *
     * @param inFormat
     * @param str
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    fun stringToLong(inFormat: String, str: String): Long {
        var result: Long = 0
        if (!TextUtils.isEmpty(str)) {
            val simpleDateFormat = SimpleDateFormat(inFormat)
            try {
                val parse = simpleDateFormat.parse(str)
                result = parse.time
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return result
    }

    /**
     * 将 date 表示的时间转换成指定格式的字符串
     * 输入：Date表示日期时间
     * 输出："yyyy-MM-dd HH:mm:ss"格式的时间字符串
     */
    fun dateToString(inFormat: String, data: Date): String {
        return SimpleDateFormat(inFormat).format(data)
    }

    fun getDetailSecondMs(dateTime: String): Long {
        return stringToLong(formatString2, dateTime)
    }
}

