package com.corejava.TDateMaintainUtil;

import com.corejava.httpUtil.HttpUtil;
import com.corejava.httpUtil.JsonUtil;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Name : MaintainData<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2013:08<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class MaintainData {

    public static void main(String[] args) throws Exception {
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //要插入的数据库，表
        String url = "jdbc:mysql://localhost:3306/QZF_TRADING?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "root";
        try {
            //加载驱动程序
            Class.forName(driver);
            //连续MySQL 数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要维护的年份
            maintain(2017,statement);
            statement.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *  维护基础数据
     * @param year  需要维护的年份
     * @param stmt  更新数据库需要用的
     * @throws Exception
     */
    public static  void maintain(int year,Statement stmt) throws Exception {
        try {
/*
//            用来保存数据
            List<TDateDTO> datedto = new ArrayList<TDateDTO>();
            // 计算出一年的天数
            List<Date> lists = dateSplit(DateTimeUtil.parse(year+"0101","yyyyMMdd"), DateTimeUtil.parse(year+"1231","yyyyMMdd"));
            // 先插入周末时间
            if (!lists.isEmpty()) {
                for (Date date : lists) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
                    {
                        // 执行插入语句
                        TDateDTO dto = new TDateDTO();
                        dto.setTheYear(year+"");
                        dto.setTheMonth(cal.get(Calendar.MONTH) +"");
                        dto.setTheDay(cal.get(Calendar.DAY_OF_MONTH)+"");
                        dto.setIsHolid("1");
                        dto.setMemo("周末");
                        datedto.add(dto);
//                        save(dto);
                    }
                }
            }
*/
            // 所有数据
            Set<HolidayDesc> allDesc = new HashSet<>();
            //插入节日时间（补班情况就变成工作日）
            for (int i = 1 ; i <= 12; i=i+2) {
                String month = year+"年"+i+"月";
                Set<HolidayDesc> returnResult = getHoliday(month.toString());
                allDesc.addAll(returnResult);
            }

            System.out.println(Arrays.toString(allDesc.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从api数据中拿取信息
     * @param month
     * @return     一个含有date和status的对象的集合信息
     * @throws Exception
     */
    public static Set<HolidayDesc> getHoliday(String month) throws Exception {
        String results = HttpUtil.sendHttps("https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php","query="+month+"&co=&resource_id=6018&t=1482200324291&ie=utf8&oe=gbk&cb=op_aladdin_callback&format=json&tn=baidu&cb=jQuery110208759018915167704_1482200308653&_=1482200308656","gbk");
        System.out.println(results);

        Set<HolidayDesc> descs = new HashSet<>();
        results = results.substring(results.indexOf("(") + 1,results.length() - 2);
        System.out.println(results);
        Pattern listPattern = Pattern.compile("\"list\":(.*?)\"list#num#baidu\":",Pattern.DOTALL);
        Matcher listMatcher = listPattern.matcher(results);
        while (listMatcher.find()) {
            String group = listMatcher.group(1);
            group = group.substring(0, group.lastIndexOf(",")).replace("[","").replace("]","");

            // '?'  相当于 {0,1} 表示出现0到1次
            Pattern holidayData = Pattern.compile("\\{(.*?)\\},?");
            Matcher holidayDataMather = holidayData.matcher(group);
            while (holidayDataMather.find()){
                String holidayData1 = holidayDataMather.group(1);
                // json
                HolidayDesc holidayDesc =  JsonUtil.toObject("{" + holidayData1 + "}", HolidayDesc.class);
                descs.add(holidayDesc);
                System.out.println("{"+holidayData1+"}");
            }
        }
        return descs;
    }

    public static List<Date> dateSplit(Date start, Date end)
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
}
