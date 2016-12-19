package com.corejava.ch5;

/**
 * Class Name : Person<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1514:08<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public abstract String getDescrip();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
