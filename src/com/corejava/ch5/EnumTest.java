package com.corejava.ch5;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Class Name : EnumTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/199:16<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class EnumTest {
    public static void main(String[] args) {
        Size s = Enum.valueOf(Size.class,"SMALL");
        System.out.println(s.toString());
        System.out.println(Size.SMALL.getAbbreviation());
        Size[] sizes = Size.values();
        for (Size temp : sizes) {
            System.out.println(temp.getAbbreviation());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size : (SMALL,MEDIUM,LARGE,EXTRA_LAGER)");
        String input = scanner.nextLine().toUpperCase();
        Size inputSize = Enum.valueOf(Size.class,input);
        System.out.println("size:" + inputSize);
        System.out.println("abbreviation:"+inputSize.getAbbreviation());
        System.out.println("ordinal:" + inputSize.ordinal());
        if (inputSize == Size.EXTRA_LAGER) {
            System.out.println("Good job--you paid attention to the _.");
        }
    }
}
