package com.corejava.Holiday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class InsertHolidayUtil2 {
  public static void main(String[] args) throws Exception {
      //驱动程序名
      String driver = "com.mysql.jdbc.Driver";
      //要插入的数据库，表
      String url = "jdbc:mysql://127.0.0.1:3306/xx_web?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
      String user = "root";
      String password = "root";
      try {
          //加载驱动程序
          Class.forName(driver);
          //连续MySQL 数据库
          Connection conn = DriverManager.getConnection(url, user, password);
          if (!conn.isClosed())
              System.out.println("Succeeded connecting to the Database!");
          //statement用来执行SQL语句
          Statement statement = conn.createStatement();

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date start = sdf.parse("2016-01-01");//开始时间
          java.util.Date end = sdf.parse("2016-12-31");//结束时间
         for (Date days : get()) {
             String insertSql = "INSERT INTO fn_all_holiday (id,title,holiday_date) VALUES('"+ UUID.randomUUID()+"',"+"'周末','"+sdf.format(days)+"')";
             statement.executeUpdate(insertSql);
         }
          get();
      }catch (SQLException e) {
          e.printStackTrace();
      }
  }

  public static List<Date> get() throws Exception {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      java.util.Date start = sdf.parse("2017-01-01");//开始时间
      java.util.Date end = sdf.parse("2017-12-31");//结束时间
      List<Date> lists = dateSplit(start, end);
      List<Date> holidays = new ArrayList<>();
      //-------------------插入周末时间---------------
      if (!lists.isEmpty()) {
          for (Date date : lists) {
              Calendar cal = Calendar.getInstance();
              cal.setTime(date);
              if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
              {
                  System.out.println("插入日期:" + sdf.format(date) + ",周末");
                  holidays.add(cal.getTime());
              }
          }
          System.out.println("============================weekend size: " + lists.size());
      }

      //---------------插入节假日时间------------------
      List<Days2> holidays1 = new ArrayList<Days2>();
      holidays1.add(new Days2("元旦", sdf.parse("2017-01-01")));
      holidays1.add(new Days2("元旦", sdf.parse("2017-01-02")));

      holidays1.add(new Days2("春节", sdf.parse("2017-01-27")));
      holidays1.add(new Days2("春节", sdf.parse("2017-01-28")));
      holidays1.add(new Days2("春节", sdf.parse("2017-01-29")));
      holidays1.add(new Days2("春节", sdf.parse("2017-01-30")));
      holidays1.add(new Days2("春节", sdf.parse("2017-01-31")));
      holidays1.add(new Days2("春节", sdf.parse("2017-02-01")));
      holidays1.add(new Days2("春节", sdf.parse("2017-02-02")));

      holidays1.add(new Days2("清明节", sdf.parse("2017-04-02")));
      holidays1.add(new Days2("清明节", sdf.parse("2017-04-03")));
      holidays1.add(new Days2("清明节", sdf.parse("2017-04-04")));

      holidays1.add(new Days2("劳动节", sdf.parse("2017-04-29")));
      holidays1.add(new Days2("劳动节", sdf.parse("2017-04-30")));
      holidays1.add(new Days2("劳动节", sdf.parse("2017-05-01")));

      holidays1.add(new Days2("端午节", sdf.parse("2017-05-28")));
      holidays1.add(new Days2("端午节", sdf.parse("2017-05-29")));
      holidays1.add(new Days2("端午节", sdf.parse("2017-05-30")));

      holidays1.add(new Days2("国庆节", sdf.parse("2017-10-01")));
      holidays1.add(new Days2("国庆节", sdf.parse("2017-10-02")));
      holidays1.add(new Days2("国庆节", sdf.parse("2017-10-03")));
      holidays1.add(new Days2("中秋节", sdf.parse("2017-10-04")));
      holidays1.add(new Days2("国庆节", sdf.parse("2017-10-05")));
      holidays1.add(new Days2("国庆节", sdf.parse("2017-10-06")));
      holidays1.add(new Days2("国庆节", sdf.parse("2017-10-07")));
      holidays1.add(new Days2("国庆节", sdf.parse("2017-10-08")));
      int count = 0;
      for(Days2 day:holidays1) {
          //跟周末冲突的，不重复插入
          boolean hasRecord = holidays.contains(day.getDate()) ;

          if(!hasRecord) {
              System.out.println("插入日期：" + sdf.format(day.getDate()) + "," + day.getTitle());
              count++;
              holidays.add(day.getDate());
          }
      }
      System.out.println("====================holidays size : " + count);


      //-------------- 剔除补班时间(周末需要补班的)---------------------
      List<Days2> workDays = new ArrayList<Days2>();
      workDays.add(new Days2("补班", sdf.parse("2017-02-04")));
      workDays.add(new Days2("补班", sdf.parse("2017-04-01")));
      workDays.add(new Days2("补班", sdf.parse("2017-05-27")));
      workDays.add(new Days2("补班", sdf.parse("2017-09-30")));

      for(Days2 day:workDays) {
          System.out.println("剔除日期：" + sdf.format(day.getDate()) + "," + day.getTitle());
          holidays.remove(day.getDate());
      }
      System.out.println("=======================remove size : " + workDays);

      for (Date date : holidays) {
          System.out.println("节假日" + sdf.format(date));
      }


      System.out.println("all :" + holidays.size());
      return holidays;
  }

  public static List<Date> dateSplit(java.util.Date start, Date end)
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