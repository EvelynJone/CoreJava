package com.corejava.ch6;

import javax.swing.*;

/**
 * Class Name : InnerClassTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1916:18<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program ?");
        System.exit(0);
    }
}
