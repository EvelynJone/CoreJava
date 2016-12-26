package com.corejava.ch12;

import com.corejava.ch4.Manage;
import com.corejava.ch5.Employee;
import com.corejava.ch5.Manager;

/**
 * Class Name : PairTest3<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2315:31<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy",8000,2003,12,5);
        Manager cfo = new Manager("Sid Senaky",6000,2003,12,5);
        Pair<Manager> buddies = new Pair<>(ceo,cfo);

        printBuddies(buddies);

        ceo.setBonus(1000);
        cfo.setBonus(500);
        Manager[] managers = {ceo,cfo};

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers,result);
        System.out.println("first:" + result.getFirst().getName() + " and second：" + result.getSecond().getName());
        maxminBonus(managers,result);
        System.out.println("first:" + result.getFirst().getName() + " and second：" + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee fitst = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(fitst.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager[] a , Pair<? super Manager> result) {
        if (null == a && a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (Manager temp : a) {
            if (min.getBonus() > temp.getBonus()) min = temp;
            if (max.getBonus() < temp.getBonus()) max = temp;
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a ,Pair<? super  Manager> result) {
        minmaxBonus(a,result);
        PairAlg.swap(result);
        //PairAlg.swapHelper(result);
    }
}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p == null ? null : p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p ) {
        swapHelper(p);
    }

    public static <T> void  swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
