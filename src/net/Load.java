package net;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/3/23 20:09
 */
public class Load {
    Stop stop = new Stop();

    public Frame loadGui() {
        JFrame frame = new JFrame("正在载入 - loading...");
        frame.setSize(390, 145);
        frame.setResizable(false);
        frame.setVisible(true);
        JTextArea jtf = new JTextArea("\n\n\t                   载入完成后自动关闭\n\t         Automatically Close After Loading", 10, 38);
        stop.ses(frame, jtf);
        frame.getContentPane().setBackground(Color.blue);
        frame.getContentPane().setVisible(true);
        String imagePath = "icon.png";
        Image imageIcon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(imagePath));
        frame.setIconImage(imageIcon);
        return frame;
    }
}
