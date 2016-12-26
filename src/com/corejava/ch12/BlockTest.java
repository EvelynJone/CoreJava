package com.corejava.ch12;

import sun.org.mozilla.javascript.internal.ast.WhileLoop;

import java.io.*;
import java.util.Scanner;

/**
 * Class Name : BlockTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2314:20<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class BlockTest {
    public static void main(String[] args) {
        File file = new File("ququqxdafdsd");
        try {
            FileInputStream o = new FileInputStream(file);
            System.out.println(o.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Block() {
            @Override
            public void body() throws Exception {
                Scanner in = new Scanner(new File("ququx"));
                while (in.hasNext())
                    System.out.println(in.next());
            }
        }.toThread().start();
    }
}
