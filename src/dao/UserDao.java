package dao;

import mysql.User;

import java.util.List;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/24 1:55
 */
public interface UserDao {
    /**
     * 登录功能
     * @param name 网页上获取的用户名
     * @param password 网页上获取的密码
     * @return 返回是否登录成功
     */
    boolean login(String name,String password);

    /**
     * 查询金钱
     * @param name 网页上获取的用户名
     * @param password 网页上获取的密码
     * @return 返回金钱
     */
    int money(String name,String password);

    /**
     * 修改金钱
     *
     * @param name 网页上获取的用户名
     * @param password 网页上获取的密码
     * @param money 获取的金钱
     * @return 返回是否成功修改
     */
    int moneyModify(String name, String password, int money);

    /**
     * 注册功能
     * @param name 用户名
     * @param password 密码
     * @return 返回是否注册成功
     */
    boolean register(String name, String password);

    /**
     * 查询单个成员数据
     * @param name 用户名
     * @return 返回单个成员数组
     */
    List<User> querySingleData(String name);
}
