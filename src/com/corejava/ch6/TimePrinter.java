package com.corejava.ch6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Class Name : TimePrinter<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1915:45<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At the tone,the time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
