/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lab Informatika
 */
public class LoginPage extends JFrame implements ActionListener {
    
    JLabel sambutan = new JLabel("Selamat Datang!");
    JLabel tutor = new JLabel("Silahkan masuk untuk melanjutkan.");
    JLabel username = new JLabel("Username");
    JTextField inputUsername = new JTextField();
    JLabel password = new JLabel("Password");
    JTextField inputPassword = new JTextField();
    JButton tombolLogin = new JButton("Login");

    public LoginPage() {
         JFrame kotakFrameLogin = new JFrame();

        kotakFrameLogin.setSize(700, 600);
        kotakFrameLogin.setTitle("Login Page");

        kotakFrameLogin.setLayout(null);
        kotakFrameLogin.setLocationRelativeTo(null);

        Font font = sambutan.getFont();
        sambutan.setFont(new Font(font.getName(), Font.PLAIN, 24));

        kotakFrameLogin.add(sambutan);
        kotakFrameLogin.add(tutor);
        kotakFrameLogin.add(username);
        kotakFrameLogin.add(inputUsername);
        kotakFrameLogin.add(password);
        kotakFrameLogin.add(inputPassword);
        kotakFrameLogin.add(tombolLogin);

        sambutan.setBounds(20, 20, 200, 30);
        tutor.setBounds(20, 50, 300, 30);
        username.setBounds(20, 80, 100, 30);
        inputUsername.setBounds(20, 110, 640, 30);
        password.setBounds(20, 150, 100, 30);
        inputPassword.setBounds(20, 180, 640, 30);
        tombolLogin.setBounds(20, 300, 640, 30);
        tombolLogin.setHorizontalAlignment(JButton.CENTER);

        tombolLogin.addActionListener(this);

        kotakFrameLogin.setVisible(true);
        kotakFrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         try {
            String outputUsername = inputUsername.getText();
            String outputPassword = inputPassword.getText();
            
            if (outputUsername.isEmpty() || outputPassword.isEmpty()) {
                throw new Exception("Tolong di isi");
            }
            
            new MenuPage(outputUsername);
            this.dispose();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
    
}
