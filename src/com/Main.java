package com;

import mysql.Jm;
import net.Login;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author setusb
 */
public class Main {
    public static void main(String[] args) {

        boolean standAloneMode = false;

        InputStream in = Login.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            String a1 = prop.getProperty("standAloneMode");
            standAloneMode = Boolean.parseBoolean(a1);
        } catch (IOException e) {
            System.out.println("读取config.properties出现未知错误，请联系开发者！");
        }

        updateDetection ud = new updateDetection();
        Tio tio = new Tio();
        if (standAloneMode) {
            tio.test(standAloneMode);
        } else {
            ud.update();
        }
    }
}