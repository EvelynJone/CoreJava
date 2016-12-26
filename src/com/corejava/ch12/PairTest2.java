package com.corejava.ch12;

import com.corejava.TDateMaintainUtil.DateUtil;
import com.corejava.ch4.Manage;
import com.corejava.ch5.Manager;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

/**
 * Class Name : PairTest2<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2311:25<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class PairTest2 {
    public static void main(String[] args) {
        GregorianCalendar[] birthdays = {
          new GregorianCalendar(1906, Calendar.DECEMBER,9),
                new GregorianCalendar(1815,Calendar.DECEMBER,10),
                new GregorianCalendar(1903,Calendar.DECEMBER,3),
                new GregorianCalendar(1910,Calendar.JUNE,22)
        };
        Pair<GregorianCalendar> mm = new ArrayAlg2().minmax(birthdays);
        System.out.println("min=" + DateUtil.formate(mm.getFirst().getTime()));
        System.out.println("max=" + DateUtil.formate(mm.getSecond().getTime()));
    }
}
class ArrayAlg2 {
    public static <T extends Comparable> Pair<T> minmax (T[] a) {
        if (null == a && a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 0 ; i < a.length ; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min,max);
    }

    /**
     * There has error when you try to get the things with coll.
     * @param coll
     * @param ts
     * @param <T>
     */
    @SafeVarargs
    public static <T> void addALl(Collection<T> coll,T... ts) {
        for (T t : ts) {
            //coll.addAll(t);
        }
    }

    public static void minmaxBonus(Manager[] a , Pair<? super Manager> result) {
        if (null == a && a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0 ; i < a.length ; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }
}
