package com.corejava.ch3;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

/**
 * Class Name : BigIntegerTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1315:26<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.4
 */
public class BigIntegerTest {
    public static void main(String[] args) {
/*
        Scanner scanner =  new Scanner(System.in);
        System.out.println("How many numbers do you need to draw ? ");
        int k = scanner.nextInt();

        System.out.println("What is the gighest number you can draw ?");
        int n = scanner.nextInt();

        BigDecimal lotteryOdds = BigDecimal.valueOf(1);

        for (int i = 1 ; i <= k ; i ++) {
            lotteryOdds = lotteryOdds.multiply(BigDecimal.valueOf(n - i + 1)).divide(BigDecimal.valueOf(i));
        }
        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
*/

//        Locale.setDefault(Locale.FRANCE);

        Date bitrhDay = new Date();
        // 这样的话两个就引用同一段内存数据，荣辱俱损
        Date deadline = bitrhDay;
        System.out.println("bitrh:" + bitrhDay);
        System.out.println("dead:" + deadline);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bitrhDay.setTime(System.currentTimeMillis());
        System.out.println("bitrh:" + bitrhDay);
        System.out.println("dead:" + deadline);


        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(deadline);
        System.out.println(calendar.getTime());

        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat per = NumberFormat.getPercentInstance();
        double x = 0.1;
        System.out.println(curr.format(x));
        System.out.println(per.format(x));
    }
}

