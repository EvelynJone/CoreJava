package com.corejava.ch13;

import com.corejava.ch5.Employee;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Class Name : TreeSetTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2617:14<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //SortedSet 对元素进行排序
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        // 使用内部类实现特定的比较方法
        SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                String descA = a.getDescription();
                String descB = b.getDescription();
                return descA.compareTo(descB);
            }
        });

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
        EnumSet<Weekday> works = EnumSet.range(Weekday.MONDAY,Weekday.FRIDAY);
        EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY,Weekday.WEDENSDAY,Weekday.FRIDAY);

        System.out.println(always);
        System.out.println(never);
        System.out.println(works);
        System.out.println(mwf);
    }
}
