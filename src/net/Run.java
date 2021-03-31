package net;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author {星子}
 * @Date: 2021/03/31/ 15:05
 * @Description
 */
public class Run {
    private static final JFrame jFrame = new JFrame("");
    private static final JButton jButton = new JButton("");
    private static int count;

    public void mains() {
        count = 0;
        window_initialization();
        button_initialization();
    }

    public static void window_initialization() {

        jFrame.setBounds(450, 30, 1000, 1000);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setLayout(null);
    }

    public static int[] random_coordinates() {
        int x = (int) (0 + Math.random() * (900 - 0 + 0));
        int y = (int) (0 + Math.random() * (900 - 0 + 0));
        int[] random = new int[2];
        random[0] = x;
        random[1] = y;
        return random;
    }

    public static void button_initialization() {
        jFrame.add(jButton);
        button_position();
    }

    public static void button_position() {
        int[] coordinate = random_coordinates();
        jButton.setBounds(coordinate[0], coordinate[1], 100, 30);
        while (true) {
            click_the_close_button();
        }
    }

    public static void click_the_close_button() {

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                button_position();
                count++;
            }
        });
    }
}
