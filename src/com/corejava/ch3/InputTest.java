package com.corejava.ch3;

import java.io.Console;
import java.util.Scanner;

/**
 * Class Name : InputTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1314:55<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Your name :" + name);

        // Console 只能用于没有被重定向过的原始控制台使用
        Console console = System.console();
        char[] password = console.readPassword();
        System.out.println("password:" + password);
    }
}
