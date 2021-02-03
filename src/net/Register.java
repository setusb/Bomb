package net;

import dao.UserImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/2/3 7:35
 */
public class Register extends JDialog {
    private static final long serialVersionUID = 1L;

    public void register() {
        String imagePath = "icon.png";
        Image imageIcon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(imagePath));
        this.setTitle("注册程序");

        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        JLabel label = new JLabel("                                                                                                                                        注册系统                                                                                                                                        ");
        JLabel label1 = new JLabel("账号：");
        JLabel label2 = new JLabel("密码：");
        JTextField text = new JTextField(15);
        JButton register = new JButton("注册");
        JPasswordField password = new JPasswordField(15);

        con.add(BorderLayout.NORTH,label);
        con.add(BorderLayout.CENTER,label1);
        con.add(text);
        con.add(label2);
        con.add(password);
        con.add(register);

        register.addActionListener(actionEvent -> {
            UserImpl user = new UserImpl();
            if (user.register(text.getText(), password.getText())) {
                dispose();
                Login l = new Login();
                l.logins();
            } else {
                text.setText("该账户已存在");
                text.requestFocus();
                password.setText("");
            }
        });
        password.setEchoChar('*');

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Login l = new Login();
                l.logins();
            }
        });

        this.setVisible(true);
        this.setSize(250,150);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(imageIcon);
    }
}
