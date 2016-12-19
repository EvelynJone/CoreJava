package com.corejava.ch3;

import java.util.Date;

/**
 * Class Name : Employee<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1317:02<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Employee {
    private String name;
    private Integer age;

    private Date birthDay;

    public Employee(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee() {
    }

    private Employee lost;

    public Employee getLost() {
        return lost;
    }

    public void setLost(Employee lost) {
        this.lost = lost;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 这种就是基于类的访问权限，Employee类的方法可以访问Employee类的任何一个对象的私有域
    public boolean equals(Employee other) {
        return name.equals(other.name);
    }

    public void raiseSalary(double per) {
        setAge((int) (getAge() * per));
    }
}
