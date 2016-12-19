package com.corejava.ch4;

import com.corejava.ch3.Employee;

/**
 * Class Name : ParamTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1410:37<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class ParamTest {
    public static final int i = 1;
    public static void main(String[] args) {

        /*
        test1 : Method can't modify numeric parameters
        */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent = " + percent);
        tripValue(percent);
        System.out.println("After: percent = " + percent);

        /*
        Test2: Methods can chang the state of object parameters
        */
        System.out.println("Testing tripleSalary: ");
        Employee harry = new Employee("Harry",5000);
        System.out.println("Before: salary = " + harry.getAge());
        tripleSalary(harry);
        System.out.println("After: salary = " + harry.getAge());

        /*
        Test3 : Methods can't attach new new objects to object pameters
        */
        System.out.println("Testing swap:");
        Employee a = new Employee("a",700);
        Employee b = new Employee("b",600);
        System.out.println("Before: a =" + a.getName());
        System.out.println("Befote: b = " + b.getName());
        swap(a,b);
        System.out.println("After: a =" + a.getName());
        System.out.println("After: b = " + b.getName());

    }

    /**
     * 使用方法改变参数的值
     * @param x
     */
    public static void tripValue(double x) {
        x = 3 * x;
        System.out.println("End of method : x = " + x);
    }

    /**
     * 使用方法改变引用参数的状态
     * @param e
     */
    public static void tripleSalary(Employee e) {
        e.raiseSalary(200);
        System.out.println("End of method : salary = " + e.getAge());
    }

    /**
     *
     * @param a
     * @param b
     */
    public static void swap(Employee a,Employee b) {
        Employee temp = a;
        a = b;
        b = temp;
        System.out.println("End of method : x = " + a.getName());
        System.out.println("End of method : y = " + b.getName());
    }
}
