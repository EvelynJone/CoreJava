package com.corejava.ch5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class Name : MethodPointerTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1913:04<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class MethodPointerTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Method square = MethodPointerTest.class.getMethod("square", double.class);


        Method sqrt = Math.class.getMethod("sqrt", double.class);

        printTable(1,10,5,square);
        printTable(1,10,5,sqrt);
    }

    public static double square(double x) {
        return x * x;
    }

    public static void printTable(double from,double to ,int n,Method f) {
        System.out.println(f);

        double dx = (to - from) / (n - 1);
        for (double x = from; x <=to; x += dx) {
            try {
                double y = (double) f.invoke(null,x);
                System.out.printf("%10.4f | %10.4f%n",x,y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
