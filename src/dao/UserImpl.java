package dao;

import mysql.DatabaseDao;
import mysql.DatabaseImpl;

import java.sql.ResultSet;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/24 1:56
 */
public class UserImpl extends DatabaseImpl implements UserDao {
    @Override
    public boolean login(String name, String password) {
        try {
            linkDatabase();
            ResultSet rs = inquiryDatabase("select * from user where name = '" + name + "' and password = '" + password + "'");
            while (rs.next()) {
                if (rs.getString("name").equals(name) && rs.getString("password").equals(password)) {
                    return true;
                }
            }
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int money(String name, String password) {
        int money = 0;
        try {
            linkDatabase();
            ResultSet rs = inquiryDatabase("select * from user where name = '" + name + "' and password = '" + password + "'");
            while (rs.next()) {
                money = rs.getInt("money");
            }
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public int moneyModify(String name, String password, int money) {
        int i = 0;
        try {
            linkDatabase();
            i = modifyDatabase("update user set money = '" + money + "'where name = '" + name + "' and password = '" + password + "'");
            closeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
