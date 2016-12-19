package com.corejava.ch6;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Class Name : TimePrinterTest<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1915:47<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class TimePrinterTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(1000,listener);
        timer.start();
        // 显示一个包含一条消息和OK按钮的对话框，这个对话框位于其parent组件的中央。如果parent为null，对话框将显示在屏幕的中央
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
