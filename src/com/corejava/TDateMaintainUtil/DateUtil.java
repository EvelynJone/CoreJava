package com.corejava.TDateMaintainUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Name : DateUtil<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2311:37<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class DateUtil {

    public static Date parse(String date,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    public static Date parse(String date) throws ParseException {
        return parse(date,"yyyy-MM-dd");
    }

    public static String formate(Date date,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String formate(Date date) {
        return formate(date,"yyyy-MM-dd");
    }
}
