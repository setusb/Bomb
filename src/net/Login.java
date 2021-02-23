package net;

import com.Test;
import com.Tio;
import dao.UserImpl;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/24 0:29
 */
public class Login extends JDialog {
    private static final long serialVersionUID = 1L;
    boolean tios = true;
    {
        InputStream in = Login.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            String a1 = prop.getProperty("tio");
            tios = Boolean.parseBoolean(a1);
        } catch (IOException e) {
            System.out.println("读取config.properties出现未知错误，请联系开发者！");
        }
    }

    public void logins(){
        String imagePath = "icon.png";
        Image imageIcon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(imagePath));
        this.setTitle("登录程序");

        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        JLabel label = new JLabel("                                                                                                                                        登录系统                                                                                                                                        ");
        JLabel label1 = new JLabel("账号：");
        JLabel label2 = new JLabel("密码：");
        JTextField text = new JTextField(15);
/*        JTextArea area = new JTextArea(10,20);*/
        JButton register = new JButton("注册");
        JButton button = new JButton("试玩");
        JPasswordField password = new JPasswordField(15);
        JButton jButton = new JButton("登录");
/*        area.setText(areaStr);*/

        con.add(BorderLayout.NORTH,label);
        con.add(BorderLayout.CENTER,label1);
        con.add(text);
        con.add(label2);
        con.add(password);
        if (tios) {
            con.add(button);
        }
        con.add(jButton);
        con.add(register);
/*        con.add(area);*/

        password.setEchoChar('*');
        jButton.addActionListener(actionEvent -> {

/*            System.out.println(text.getText());*/
            UserImpl user = new UserImpl();
            if (user.login(text.getText(), password.getText())) {
                dispose();
                Test test = new Test();
                test.test(text.getText(), password.getText(),user.money(text.getText(), password.getText()));
            } else {
                JOptionPane.showMessageDialog(this, "账号或密码错误");
                text.setText("");
                text.requestFocus();
                password.setText("");
            }
        });

        register.addActionListener(actionEvent -> {
            dispose();
            Register reg = new Register();
            reg.register();
        });
        text.addActionListener(arg0 -> {
            JOptionPane.showMessageDialog(this, "请输入密码");
        });
        password.addActionListener(arg0 -> {
            UserImpl user = new UserImpl();
            if (user.login(text.getText(), password.getText())) {
                dispose();
                Test test = new Test();
                test.test(text.getText(), password.getText(),user.money(text.getText(), password.getText()));
            } else {
                JOptionPane.showMessageDialog(this, "账号或密码错误");
                text.setText("");
                text.requestFocus();
                password.setText("");
            }
        });
        button.addActionListener(e -> {
/*            text.setText("");
            text.requestFocus();
            password.setText("");*/
            dispose();
            Tio tio = new Tio();
            tio.test();

        });
/*        area.setEditable(false);*/
        this.setVisible(true);
        this.setSize(250,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(imageIcon);
    }
}
