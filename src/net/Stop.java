package net;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/23 18:44
 */
public class Stop {
    public void stop() {
        Frame frame = new Frame("停用告知 - DeactivationNotice");
        frame.setSize(390, 145);
        frame.setResizable(false);
        frame.setVisible(true);
        JTextArea jtf = new JTextArea("\n\t          该版本已停用，请前往GitHub\n\t         https://github.com/setusb/Bomb\n\t                           进行更新\n\t                             Update", 10, 38);
        ses(frame, jtf);
    }

    public void ses(Frame frame, JTextArea jtf) {
        frame.setLocationRelativeTo(null);
        frame.add(jtf);
        jtf.setEditable(false);
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
            }
        });
    }

    public void notConnected() {
        Frame frame = new Frame("未联网 - notConnected");
        frame.setSize(390, 145);
        frame.setResizable(false);
        frame.setVisible(true);
        JTextArea jtf = new JTextArea("\n\t          无法检测更新，请联网后在试\n     Unable to detect updates, please try after connecting to the Internet", 10, 38);
        ses(frame, jtf);
    }
}
