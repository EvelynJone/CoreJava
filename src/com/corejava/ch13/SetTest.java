package com.corejava.ch13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Class Name : SetTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2616:30<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<String>();
        long totalTime = 0;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.equals("exit")) {
                break;
            }
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
        }

        Iterator<String> iterator = words.iterator();
        for (int i = 1 ; i < 20 && iterator.hasNext() ; i++)
            System.out.println(iterator.next());
        System.out.println(".........");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
