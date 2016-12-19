package com.corejava.ch3;

/**
 * Class Name : Change<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1410:20<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Change {
    public static void main(String[] args) {
        int a = 1,b = 2;
        swap(a,b);
        System.out.println(a+ " " + b);
/*        Employee a = new Employee();
        a.setName("a");
        Employee b = new Employee();
        b.setName("b");
        swap(a,b);
        System.out.println(a.getName() + b.getName());*/
    }

    public static void swap(int a ,int b) {
        int temp = a;
        a = b ;
        b = temp;
    }

    public static void swap(Employee x,Employee y) {
//        Employee temp = x;
        String name = x.getName();
//        x = y;
        x.setName(y.getName());
        y.setName(name);
//        y = temp;
    }
}
