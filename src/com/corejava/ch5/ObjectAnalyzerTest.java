package com.corejava.ch5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Name : ObjectAnalyzerTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1911:07<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0 ; i <= 5 ; i++)
            squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
        Employee employee = new Employee("nihao",2000,1993,8,20);
        System.out.println(new ObjectAnalyzer().toString(employee));
    }
}
