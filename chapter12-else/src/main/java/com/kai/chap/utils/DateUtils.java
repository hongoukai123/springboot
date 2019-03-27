package com.kai.chap.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {


    /**
     * 将日期格式日期转换为字符串格式 自定义格式
     * @param date 日期
     * @param dateformat 格式
     * @return
     */
    public static String format(Date date, String dateformat) {
        String datestr = null;
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        datestr = df.format(date);
        return datestr;
    }

}
