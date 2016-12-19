package com.corejava.Holiday;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InsertHolidayUtil {
  public static void main(String[] args) throws Exception {
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               java.util.Date start = sdf.parse("2016-01-01");//开始时间
               java.util.Date end = sdf.parse("2016-12-31");//结束时间
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
               List<Days> holidays1 = new ArrayList<Days>();
               holidays1.add(new Days("元旦", sdf.parse("2016-01-01")));
               holidays1.add(new Days("元旦", sdf.parse("2016-01-02")));
               holidays1.add(new Days("元旦", sdf.parse("2016-01-03")));

               holidays1.add(new Days("春节", sdf.parse("2016-02-07")));
               holidays1.add(new Days("春节", sdf.parse("2016-02-08")));
               holidays1.add(new Days("春节", sdf.parse("2016-02-09")));
               holidays1.add(new Days("春节", sdf.parse("2016-02-10")));
               holidays1.add(new Days("春节", sdf.parse("2016-02-11")));
               holidays1.add(new Days("春节", sdf.parse("2016-02-12")));
               holidays1.add(new Days("春节", sdf.parse("2016-02-13")));

               holidays1.add(new Days("清明节", sdf.parse("2016-04-02")));
               holidays1.add(new Days("清明节", sdf.parse("2016-04-03")));
               holidays1.add(new Days("清明节", sdf.parse("2016-04-04")));

               holidays1.add(new Days("劳动节", sdf.parse("2016-04-30")));
               holidays1.add(new Days("劳动节", sdf.parse("2016-05-01")));
               holidays1.add(new Days("劳动节", sdf.parse("2016-05-02")));

               holidays1.add(new Days("端午节", sdf.parse("2016-06-09")));
               holidays1.add(new Days("端午节", sdf.parse("2016-06-10")));
               holidays1.add(new Days("端午节", sdf.parse("2016-06-11")));

               holidays1.add(new Days("中秋节", sdf.parse("2016-09-15")));
               holidays1.add(new Days("中秋节", sdf.parse("2016-09-16")));
               holidays1.add(new Days("中秋节", sdf.parse("2016-09-17")));

               holidays1.add(new Days("国庆节", sdf.parse("2016-10-01")));
               holidays1.add(new Days("国庆节", sdf.parse("2016-10-02")));
               holidays1.add(new Days("国庆节", sdf.parse("2016-10-03")));
               holidays1.add(new Days("国庆节", sdf.parse("2016-10-04")));
               holidays1.add(new Days("国庆节", sdf.parse("2016-10-05")));
               holidays1.add(new Days("国庆节", sdf.parse("2016-10-06")));
               holidays1.add(new Days("国庆节", sdf.parse("2016-10-07")));
      int count = 0;
               for(Days day:holidays1) {
            	   //跟周末冲突的，不重复插入
                   boolean hasRecord = holidays.contains(sdf.format(day.getDate())) ;

                   if(!hasRecord) {
                	   System.out.println("插入日期：" + sdf.format(day.getDate()) + "," + day.getTitle());
                       count++;
                	   holidays.add(day.getDate());
                   }
               }
      System.out.println("====================holiday size : " + count);
               
               
               //-------------- 剔除补班时间(周末需要补班的)---------------------
               List<Days> workDays = new ArrayList<Days>();
               workDays.add(new Days("补班", sdf.parse("2016-02-06")));
               workDays.add(new Days("补班", sdf.parse("2016-02-14")));
               workDays.add(new Days("补班", sdf.parse("2016-05-02")));
               workDays.add(new Days("补班", sdf.parse("2016-06-12")));
               workDays.add(new Days("补班", sdf.parse("2016-09-18")));
               workDays.add(new Days("补班", sdf.parse("2016-10-08")));
               workDays.add(new Days("补班", sdf.parse("2016-10-09")));
               
               for(Days day:workDays) {
            	   System.out.println("剔除日期：" + sdf.format(day.getDate()) + "," + day.getTitle());
            	  holidays.remove(day.getDate());
               }
      System.out.println("=======================remove size : " + workDays);

                for (Date date : holidays) {
                    System.out.println("节假日" + sdf.format(date));
                }
      System.out.println("all :" + holidays.size());
  }
  
  private static List<Date> dateSplit(java.util.Date start, Date end)
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