package com.corejava.ch5;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Name : PersonTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1514:22<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] persons = new Person[2];

        persons[0] = new Employee("Harry Hacker",5000,1989,10,1);
        persons[1] = new Student("Maria Morris","computer science");

        for (Person p : persons)
            System.out.println(p.getDescrip());

        String s = "s";

        StringBuffer sb = new StringBuffer(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());

        Method[] methods = persons[0].getClass().getMethods();
        for (Method method : methods)
            System.out.println(method.getName());

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Student("",""));

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        Integer.parseInt("s");
        Integer i = new Integer(1);
        i.intValue();
        i.toString();
        Integer.valueOf(2);

    }
}

