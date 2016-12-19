package com.corejava.Holiday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Class Name : Test<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1918:43<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Test {
    public static void main(String[] args) {
        int year = 2016;
        try {
            Date start = DateTimeUtil.parse(year+"0101","yyyyMMdd");
            Date end = DateTimeUtil.parse(year+"1231","yyyyMMdd");
            List<Date> dates = InsertHolidayUtil.dateSplit(start,end);
            for (Date date : dates) {
                //检查具体日期是否为节假日，工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
                String result = sendHttp("http://www.easybots.cn/api/holiday.php?d="+DateTimeUtil.format(date,"yyyyMMdd"), null, "utf-8");
                result = replaceStr(result, new String[]{"{", "}", "\""});
                String[] results = result.split(":");
                System.out.println(Arrays.toString(results));
                System.out.println(getMomo(results[1]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String getMomo(String type) {
        String memo = "";
        switch (type.trim()) {
            case "0" : memo = "工作日"; break;
            case "1" : memo = "周末"; break;
            case "2" : memo = "法定节日"; break;
            default:break;
        }
        return memo;
    }
    private static String replaceStr(String dest,String[] str) {
        for (String temp : str) {
            dest = dest.replace(temp,"");
        }
        return dest;
    }


    public static String sendHttp(String url, String xmlStr, String readerEncoding) throws Exception {
        StringBuffer retu = new StringBuffer("");
        URL httpUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection)httpUrl.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
//        con.setRequestProperty("Content-Length", String.valueOf(xmlStr.getBytes().length));
        con.setRequestProperty("Content-Type","application/json");
        OutputStream os = con.getOutputStream();
//        os.write(xmlStr.getBytes());
        os.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), readerEncoding));

        String line;
        while((line = reader.readLine()) != null) {
            retu.append(line);
        }

        os.close();
        reader.close();
        con.disconnect();
        return retu.toString();
    }

}
