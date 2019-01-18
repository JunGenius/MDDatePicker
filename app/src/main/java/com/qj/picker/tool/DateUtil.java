package com.qj.picker.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * @des 日期工具类
 * @author qujun
 * @time 2018/7/17 10:28
 * Lonely people will pretend to be very busy.
 **/

public class DateUtil {
    /**
     * 获取系统当前时间
     *
     * @return yyyy-MM-dd hh:mm:ss
     */
    public static String getSystemDateTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.US);
        String date = sDateFormat.format(new Date());
        return date;
    }

    public static String getSystemDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.US);
        String date = sDateFormat.format(new Date());
        return date;
    }


    public static String getSystemDateTimeHM() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",
                Locale.US); // 精确到毫秒
        String suffix = fmt.format(new Date());
        return suffix;
    }

    /**
     * + 后几天 ， - 前几天
     *
     * @param day 天数
     * @return
     */
    public static String getNextDateStr(Date currentDate, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.US);
        return sDateFormat.format(date);
    }

    public static Date getNextDate(Date currentDate, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();
        return date;
    }


    public static Date getAppendDateForMin(Date currentDate, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MINUTE, min);
        Date date = calendar.getTime();
        return date;
    }

    public static String getNextDateStr(String currentDate, int day) {
        Date cDate = getStringToData(currentDate);
        if (cDate == null) {
            return currentDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cDate);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.US);
        return sDateFormat.format(date);
    }

    public static String getNextDateStr(String currentDate, String format, int day) {
        Date cDate = getStringToDate(currentDate, format);
        if (cDate == null) {
            return currentDate;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cDate);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                format, Locale.US);
        return sDateFormat.format(date);
    }

    /**
     * 字符串日期 转换 日期类型
     *
     * @param str
     * @return
     */
    public static Date getStringToData(String str) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.US);
        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getStringToDateDay(String str) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            Date date =  df.parse(str);

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(date);

            return calendar.get(Calendar.DAY_OF_MONTH);

        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Date getStringToDate(String str) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getStringToDate(String str, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.US);
        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取系统当前日期
     *
     * @return yyyy-MM-dd
     */
    public static String GetSystemDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd",
                Locale.US);
        String date = sDateFormat.format(new Date());
        return date;
    }

    /**
     * 获取时间差 返回分钟
     */
    public static int getTimeDifference(String bTime, String eTime) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                    Locale.US);
            Date now = df.parse(bTime);
            Date date = df.parse(eTime);
            long l = date.getTime() - now.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            // int hour = (int) (l / (60 * 60 * 1000) - day * 24);
            int min = (int) ((l / (60 * 1000)) - day * 24 * 60);
            // long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min *
            // 60);
            return min;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取时间差 返回分钟
     */
    public static int getTimeDifference(String bTime, String eTime, String formate) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(formate,
                    Locale.US);
            Date now = df.parse(bTime);
            Date date = df.parse(eTime);
            long l = date.getTime() - now.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            // int hour = (int) (l / (60 * 60 * 1000) - day * 24);
            int min = (int) (day * 24 * 60);
            // long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min *
            // 60);
            return min;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    /**
     * 获取两个日期之间的间隔天数
     *
     * @return
     */
    public static int getGapCount(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 获取当前时间戳 (10位)
     *
     * @return 时间戳 1407111111
     */
    public static String getTimestamp() {

        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳

        return String.valueOf(time);

    }

    public static String getTimeStamp(String dateStr, String format) {

        Date date = getStringToDate(dateStr, format);

        if (date == null) {
            return "";
        }

        long time = date.getTime();

        String str = String.valueOf(time);

        return str;

    }

    /**
     * 转换时间格式字符串 yyyy-mm-dd HH:mm:ss
     *
     * @param str
     * @return
     */
    public static String toDateString(String str, String format) {
        SimpleDateFormat formatDate = new SimpleDateFormat(format, Locale.US);
        Date date = getStringToDate(str, format);
        return formatDate.format(date);
    }

    public static String toDateString(Date date, String format) {
        SimpleDateFormat formatDate = new SimpleDateFormat(
                format, Locale.US);
        String dateStr = formatDate.format(date);
        return dateStr;
    }

    /**
     * 比较两个日期大小
     *
     * @param DATE1
     * @param DATE2
     * @return 1：dt1 在dt2前 -1：dt2 在dt1前
     */
    public static int compare_date(String DATE1, String DATE2) {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm", Locale.US);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 比较两个日期大小
     *
     * @param DATE1 yyyy-MM-dd HH:mm:ss
     * @param DATE2 yyyy-MM-dd HH:mm:ss
     * @return 1：dt1 大 -1：dt2 大
     */
    public static int compareDate(String DATE1, String DATE2) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.US);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
