package com.corejava.ch6;

import com.corejava.ch5.Employee;

import java.util.Arrays;

/**
 * Class Name : EmployeeTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1914:29<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker",35000);
        staff[1] = new Employee("Carl Cracker",75000);
        staff[2] = new Employee("Tony Tester",38000);

        Arrays.sort(staff);

        for (Employee e : staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary());

    }
}
