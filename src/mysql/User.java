package mysql;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/24 0:46
 */
public class User {
    private int id;
    private String name;
    private String password;
    private int money;

    public User() {
    }

    public User(int id, String name, String password, int money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
