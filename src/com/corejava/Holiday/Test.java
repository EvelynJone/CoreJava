package com.corejava.Holiday;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        System.out.println(getMomo("0"));
    }
    @Override
    public void maintainData(int year) {
        try {
            Date start = DateTimeUtil.parse(year+"0101","yyyyMMdd");
            Date end = DateTimeUtil.parse(year+"1231","yyyyMMdd");
            List<Date> dates = dateSplit(start,end);
            for (Date date : dates) {
                //检查具体日期是否为节假日，工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
                String result = sendHttp("http://www.easybots.cn/api/holiday.php?d="+DateTimeUtil.format(date,"yyyyMMdd"), null, "utf-8");
                result = replaceStr(result, new String[]{"{", "}", "\""});
                String[] results = result.split(":");
                TDateDTO dto = new TDateDTO();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                dto.setTheYear(""+calendar.get(Calendar.YEAR));
                dto.setTheMonth(""+calendar.get(Calendar.MONTH));
                dto.setIsHolid(results[1] == "0" ? "0" : "1");
                dto.setTheDay(""+calendar.get(Calendar.DAY_OF_MONTH));
                dto.setMemo(getMomo(results[1]));
                save(dto);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
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
            dest.replace(temp,"");
        }
        return dest;
    }

    private static List<Date> dateSplit(Date start, Date end)
            throws Exception {
        if (!start.before(end))
            throw new Exception("开始时间应该在结束时间之后");
        Long spi = end.getTime() - start.getTime();
        Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数

        List<Date> dateList = new ArrayList<Date>();
        dateList.add(end);
        for (int i = 1; i <= step; i++) {
            dateList.add(new Date(dateList.get(i - 1).getTime()
                    - (24 * 60 * 60 * 1000)));// 比上一天减一
        }
        return dateList;
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
