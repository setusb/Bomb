package net;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lei {
    //猜数字程序
    public static int[] csz(String sz, int fw) {
        JFrame jf1 = new JFrame("游戏程序");
        int sz1 = 0;
        int sz2 = fw;
        int sz3 = 0;
        int money = 0;
        //(int) (Math.random() * fw);
        int value = (int) (Math.random() * fw);
        int [] arr = new int[3];
        String zzbds = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])";
        Pattern patt = Pattern.compile(zzbds);
        Matcher match = patt.matcher(sz);
        if (match.find()) {
            sz1 = Integer.parseInt(match.group(0));
        }
        if (sz1 < fw) {
            if (sz2 > 20) {
                sz2 -= 20;
                sz3 = sz1;
                System.out.println(value);
                if (sz1 == value) {
                    JOptionPane.showMessageDialog(jf1,"你猜中了！\n金币+100已到账");
                    sz2 = 100;
                    money = 100;
                } else {
                    System.out.println("no");
                }
            } else if (sz2 == 20){
                sz2 = 20;
                sz3 = sz1;
                System.out.println(value);
                if (sz1 == value) {
                    JOptionPane.showMessageDialog(jf1,"你猜中了！\n金币+50已到账");
                    sz2 = 100;
                    money = 50;
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }else {
            JOptionPane.showMessageDialog(jf1, "输入正确范围的值");
            sz2 = fw;
        }
        arr[0] = sz2;
        arr[1] = sz3;
        arr[2] = money;
        return arr;
    }
    //惩罚程序
    public static void cf(){
        while (true) {
            JFrame jFrame = new JFrame("惩罚程序");
            jFrame.setVisible(true);
            jFrame.setSize(0, 0);
            jFrame.setLocation(10000,10000);
        }
    }
}
