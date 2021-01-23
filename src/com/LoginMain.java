package com;

import net.Login;

import javax.swing.*;
import java.awt.*;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/1/24 0:54
 */
public class LoginMain extends JDialog {
    public void dl() {
        Login login = new Login();
        login.logins();
    }
}
