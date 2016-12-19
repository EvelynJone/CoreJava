package com.corejava.ch3;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class Name : CalendarTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1316:23<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class CalendarTest {
    public static void main(String[] args) {
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        d.set(Calendar.DAY_OF_MONTH,1);

      int weekday = d.get(Calendar.DAY_OF_WEEK);

        int firstDayOfWeek = d.getFirstDayOfWeek();

      // determine the required indentation for the first line
      int indent = 0;
      while (weekday != firstDayOfWeek)
      {
         indent++;
         d.add(Calendar.DAY_OF_MONTH, -1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }

      // print weekday names
      String[] weekdayNames = new DateFormatSymbols().getShortWeekdays(

      );
      do
      {
         System.out.printf("%4s", weekdayNames[weekday]);
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }
      while (weekday != firstDayOfWeek);
      System.out.println();

      for (int i = 1; i <= indent; i++)
         System.out.print("    ");

        d.set(Calendar.DAY_OF_MONTH,1);
        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d",day);

         // mark current day with *
         if (day == today) System.out.print("*");
         else System.out.print(" ");

         // advance d to the next day
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);

         // start a new line at the start of the week
         if (weekday == firstDayOfWeek) System.out.println();
      }
      while (d.get(Calendar.MONTH) == month);
      // the loop exits when d is day 1 of the next month

      // print final end of line if necessary
      if (weekday != firstDayOfWeek) System.out.println();
   }
}
