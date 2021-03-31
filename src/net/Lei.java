package net;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author setusb
 */
public class Lei {
    //猜数字程序
    public static int[] csz(String sz, int fw) throws Exception {
        InputStream in = Login.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        boolean debug = true;
        try {
            prop.load(in);
            String a1 = prop.getProperty("tio");
            String a2 = prop.getProperty("debug");
            debug = Boolean.parseBoolean(a2);
        } catch (IOException e) {
            System.out.println("读取config.properties出现未知错误，请联系开发者！");
        }
        JFrame jf1 = new JFrame("游戏程序");
        int sz1 = 0;
        int sz2 = fw;
        int sz3 = 0;
        int money = 0;
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
                if (sz1 == value) {
                    JOptionPane.showMessageDialog(jf1,"你猜中了！\n金币+100已到账");
                    sz2 = 100;
                    money = 100;
                    if (debug) {
                        System.out.println("Debug - 猜中了，值是: "+value);
                    }
                } else {
                    if (debug) {
                        System.out.println("Debug - 未猜中，值是: "+value);
                    }
                }
            } else if (sz2 == 20){
                sz2 = 20;
                sz3 = sz1;
                if (sz1 == value) {
                    JOptionPane.showMessageDialog(jf1,"你猜中了！\n金币+50已到账");
                    sz2 = 100;
                    money = 50;
                    if (debug) {
                        System.out.println("Debug - 猜中了，值是: "+value);
                    }
                } else {
                    if (debug) {
                        System.out.println("Debug - 未猜中，值是: "+value);
                    }
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
        Run run = new Run();
        run.mains();
    }
}
