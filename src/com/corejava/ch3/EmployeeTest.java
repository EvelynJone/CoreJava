package com.corejava.ch3;

import java.math.BigInteger;
import java.util.Date;

/**
 * Class Name : EmployeeTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1317:03<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("name");
        employee.setAge(12);
        employee.setBirthDay(new Date());


        Date d = employee.getBirthDay();
        double tenyears = 10 * 365.25*24*60*60*1000;
       // 改变的是d的值，但是employee的birthDay也被改变了，因为他们指向的同一个地方
        d.setTime((long) (d.getTime() - tenyears));
        System.out.println(employee.getBirthDay());
        System.out.println(employee.getName());
        System.out.println(employee.getAge());

        Employee parent = new Employee();
        parent.setLost(employee);

        Employee temp = parent.getLost();
        temp.setAge(15);

        System.out.println(parent.getLost().getAge());
    }
}
