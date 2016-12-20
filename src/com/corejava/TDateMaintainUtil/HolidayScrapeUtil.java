package com.corejava.TDateMaintainUtil;

import com.corejava.httpUtil.HttpUtil;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Name : HolidayScrapeUtil<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2014:31<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public abstract class HolidayScrapeUtil {

    public static BaiduApi getHoliday(String month) throws Exception {
        String results = HttpUtil.sendHttps("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php","query="+month+"&co=&resource_id=6018&t=1482200324291&ie=utf8&oe=gbk&cb=op_aladdin_callback&format=json&tn=baidu&cb=jQuery110208759018915167704_1482200308653&_=1482200308656","gbk");
        System.out.println(results);
        results = results.substring(results.indexOf("(") + 1,results.length() - 2);
        System.out.println(results);
//        ObjectMapper objectMapper = new ObjectMapper();

//        BaiduApi api = JsonUtil.toObject(results,BaiduApi.class);
        String pattern = "\"holiday\":(.*?)\"almanac\":";
        Pattern r = Pattern.compile(pattern,Pattern.DOTALL);



        Matcher matcher = r.matcher(results);
        if (matcher.find()) {
            String holidays = matcher.group(1);
            System.out.println(holidays);

            Pattern listPattern = Pattern.compile("\"list\":(.*?)\"list#num#baidu\":",Pattern.DOTALL);
            Matcher listMatcher = listPattern.matcher(holidays);
            while (listMatcher.find()) {
                //System.out.println("listMatcher.group(1)------------------>");
                String group = listMatcher.group(1);
                group = group.substring(0, group.lastIndexOf(",")).replace("[","").replace("]","");

                Pattern holidayData = Pattern.compile("\\{(.*?)\\},+");
                Matcher holidayDataMather = holidayData.matcher(group);
                while (holidayDataMather.find()){
                    String holidayData1 = holidayDataMather.group(1);
//                    HolidayDesc holidayDesc = JsonUtil.toObject("{" + holidayData1 + "}", HolidayDesc.class);


                    System.out.println("{"+holidayData1+"}");
                }

            }
        }

//        System.out.println(api);
        return null;
    }
}
