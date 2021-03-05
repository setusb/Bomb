package mysql;

import net.Stop;

import java.sql.*;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/23 17:57
 */
public class DatabaseImpl implements DatabaseDao {
    static Jm jm = new Jm();
    static String url = "jdbc:mysql://chengzhihao.mysql.rds.aliyuncs.com/bomb?useUnicode=true&characterEncoding=utf8";
    static String username = "setusb";
    static String password = jm.XORdecode("200251535352535753515753", "123456");
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    Stop stop = new Stop();

    @Override
    public void linkDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("数据库连接模块出错！");
            stop.notConnected();
        }
    }

    @Override
    public ResultSet inquiryDatabase(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("数据库查询模块出错！");
        }
        return rs;
    }

    @Override
    public int modifyDatabase(String sql) {
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("数据库修改模块出错！");
        }
        return i;
    }

    @Override
    public void closeDatabase() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭模块出错！");
        }
    }
}
