package net;

import com.Test;
import dao.UserImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/24 0:29
 */
public class Login extends JDialog {
    private static final long serialVersionUID = 1L;
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
        JButton button = new JButton("清除");
        JPasswordField password = new JPasswordField(15);
        JButton jButton = new JButton("登录");
/*        area.setText(areaStr);*/

        con.add(BorderLayout.NORTH,label);
        con.add(BorderLayout.CENTER,label1);
        con.add(text);
        con.add(label2);
        con.add(password);
        con.add(button);
        con.add(jButton);
/*        con.add(area);*/

        password.setEchoChar('*');
        jButton.addActionListener(actionEvent -> {

/*            System.out.println(text.getText());*/
            UserImpl user = new UserImpl();
            if (user.login(text.getText(), password.getText())) {
                dispose();
                Test test = new Test();
                test.test();
            } else {
                text.setText("账号错误");
                text.requestFocus();
                password.setText("");
            }
        });
        text.addActionListener(arg0 -> {
            // TODO Auto-generated method stub
            text.setText("triggerEvent");
        });
        button.addActionListener(e -> {
            // TODO Auto-generated method stub
            text.setText("");
            text.requestFocus();
            password.setText("");
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
