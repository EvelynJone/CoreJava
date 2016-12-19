package com.corejava.ch5;

/**
 * Class Name : Student<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1514:15<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Student extends Person {
    private String major;

    public Student(String name,String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescrip() {
        return "a student majoring in "+ major;
    }
}
