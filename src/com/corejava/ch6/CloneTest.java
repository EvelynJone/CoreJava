package com.corejava.ch6;

import com.corejava.ch5.Employee;

import java.util.Date;

/**
 * Class Name : CloneTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1915:30<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public",5000);
            original.setHireDay(new Date());
            Employee copy = original.clone();
            copy.raiseSalary(10);
            System.out.println("original="+original);
            System.out.println("copy="+copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
