package com.corejava.ch11;

import java.util.Scanner;

/**
 * Class Name : StackTraceTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2214:05<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class StackTraceTest {

    public static int factorial(int n ) {
        System.out.println("factorial("+n+"):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement frame : frames) {
            System.out.println("frame:"+frame);
        }
        int r ;
        if (n <= 1) r = 1;
        else  r = n * factorial(n-1);

        System.out.println("return " + r);
        return r;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n : " );
        int n = in.nextInt();
        factorial(n);
    }
}
