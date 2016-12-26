package com.corejava.ch6;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Class Name : AnonymousInnerClassTest<BR>
 * Descripe : 匿名内部类
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2115:38<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClockA clock = new TalkingClockA();
        clock.start(1000,true);

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

    }
}
class TalkingClockA {

    public void start(int interval , final  boolean beep) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone,the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer timer = new Timer(interval,listener);
        timer.start();
    }
}
