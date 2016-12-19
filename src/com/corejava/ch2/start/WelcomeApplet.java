package com.corejava.ch2.start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class Name : WelcomeApplet<BR>
 * Descripe : TODO(这里用一句话描述这个类的作用)<BR>
 * Create by : zhaoxl<BR>
 * DATE: 2016/12/1311:08<BR>
 * Version: V1.0<BR>
 * <p/>
 * copyright 轻重府.
 */
public class WelcomeApplet extends JApplet {

    @Override
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLayout(new BorderLayout());
                JLabel label = new JLabel("Welcome to Core Java",SwingConstants.CENTER);
                label.setFont(new Font("宋体",Font.BOLD,18));
                add(label,BorderLayout.CENTER);

                JPanel panel = new JPanel();

                JButton button = new JButton("Cay Horstmann");
                button.addActionListener(makeAction("http://www.horstmann.com"));
                panel.add(button);

                JButton garyButton = new JButton("Gary Cornell");
                button.addActionListener(makeAction("mailto:gary_cornell@apress.com"));
                panel.add(garyButton);

                add(panel,BorderLayout.SOUTH);
            }
        });
    }

    private ActionListener makeAction(final String urlString) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getAppletContext().showDocument(new URL(urlString));
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
}
