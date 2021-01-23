package com;

import mysql.DatabaseImpl;
import net.Stop;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/23 19:15
 */
public class updateDetection {
    public void update() {
        //版本号 - 必须和服务器version保持一致
        String version = "21123-1";
        //校验码 - 101是正常 404是停止运营
        String checked = null;
        String deactivate = "404";
        Stop stop = new Stop();
        DatabaseImpl database = new DatabaseImpl();
        database.linkDatabase();
        ResultSet rs = database.inquiryDatabase("select * from versionUpdateDetection where version = " + '"' + version + '"');
        try {
            while (rs.next()) {
                checked = rs.getString("checked");
            }
        } catch (SQLException e) {
            System.out.println("出错");
        }
        database.closeDatabase();

        System.out.println(version);
        System.out.println(checked);

        if ("101".equals(checked)) {
            LoginMain loginMain = new LoginMain();
            loginMain.dl();
        }

        if (deactivate.equals(checked)) {
            stop.stop();
        }

        if (checked == null) {
            stop.stop();
        }
    }
}
