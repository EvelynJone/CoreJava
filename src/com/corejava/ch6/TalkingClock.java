package com.corejava.ch6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Class Name : TalkingClock<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1916:14<BR>
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
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval,listener);
        timer.start();
    }
    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the tone,the time is " + now);
//            if (access$0(outer))
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }
}
