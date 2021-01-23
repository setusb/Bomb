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
}
