package com.corejava.ch13;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * Class Name : PriorityQueueTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2713:33<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1906, Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815, Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903, Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1910, Calendar.JUNE,22));

        System.out.println("Iterating over elements ... ");
        for (GregorianCalendar date : pq) {
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("Removing elements ... ");
        while (! pq.isEmpty())
            System.out.println(pq.remove().get(Calendar.YEAR));
    }
}
