package com.corejava.ch6.partInner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Class Name : TalkingClock<BR>
 * Descripe : 使用内部类
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/2114:42<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }


    public void start() {
        // 这是局部内部类，对外部世界完全隐藏起来。
        class TimePrinter implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("At the tone,the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval,listener);
        timer.start();
    }

}
