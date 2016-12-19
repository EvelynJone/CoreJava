package com.corejava.ch3;

import com.sun.org.apache.bcel.internal.generic.IFNULL;
import com.sun.org.apache.bcel.internal.generic.InstructionHandle;
import com.sun.xml.internal.ws.api.server.InstanceResolver;

import java.io.*;
import java.math.BigInteger;
import java.util.Map;

/**
 * Class Name : Operator<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1313:44<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class Operator {
    // use strictfp 所有方法必须使用严格的浮点计算
    public static strictfp void main(String[] args) {
        int x = 0;
        // 一般将运算符放在赋值符的左侧
        x += 3;
        x =+ 6;

        System.out.println(x);

        float f = Math.min(0.0f,Float.NaN);
        System.out.println(f);
        System.out.println(Math.min(0.0f,Float.NaN));

        System.out.println(Size.SMALL);
        System.out.println(Size.MEDIUM);
        String s = "s";
        s.equals(s);
        s.compareTo(s);
        Operator o = new Operator();
        o.equals(o);

        Integer i = new Integer(1);
        i.equals(i);

        Long l = new Long(1);
        l.equals(l);

        Double d = new Double(2);
        d.equals(d);

        String greeting = "hello_*&*&^%$$##@!()**&&^&^jfdaHHSJLEUIJHDFKSHSJK";
        int n = greeting.codePointCount(0,greeting.length());
        System.out.println("The greeting pointCount = " + n);
        greeting.startsWith("s");
        greeting.replace("h","s");
        greeting.substring(0);
        System.out.println(greeting.toLowerCase());
        greeting.trim();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.substring(0);
        stringBuffer.toString();
        stringBuffer.append("s");


    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

enum Size {
    SMALL(0,""),
    MEDIUM(1,""),
    LARGER(2,""),
    EXTRA_LARGER(3,"");

    private Size(Integer i , String d) {

    }
}
