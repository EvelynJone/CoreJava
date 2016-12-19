package com.corejava.ch4;


import com.corejava.ch3.Employee;

public class NoMain {
    static {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Manage e = new Manage();
        Employee[] staff = new Employee[3];
        staff[0] = e;
        e.test();
    }


}
