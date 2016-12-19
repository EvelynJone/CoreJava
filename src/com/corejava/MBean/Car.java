package com.corejava.MBean;

/**
 * Class Name : Car<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1611:03<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Car implements CarMBean{
   private String color = "red";


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void drive() {
        System.out.println("Baby you can drive my car.");
    }
}
