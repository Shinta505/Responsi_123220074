/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.Dosen.ViewDosen;
import View.Mahasiswa.ViewMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lab Informatika
 */
public class MenuPage extends JFrame implements ActionListener {
    
    JLabel sambutan = new JLabel();
    JLabel tutor = new JLabel("Silahkan pilih untuk melanjutkan");
    JButton pilihMahasiswa = new JButton("Mahasiswa");
    JButton pilihDosen = new JButton("Dosen");
    JButton logout = new JButton("Logout");

    public MenuPage(String outputUsername) {
        setTitle("Menu Page");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 600);
        
        add(sambutan);
        add(tutor);
        add(pilihDosen);
        add(pilihMahasiswa);
        add(logout);
        
        sambutan.setText("Selamat Datang " + outputUsername);
        
        sambutan.setBounds(20, 8, 440, 24);
        tutor.setBounds(20, 38, 500, 30);
        pilihDosen.setBounds(20, 68, 500, 40);
        pilihMahasiswa.setBounds(20, 128, 500, 40);
        logout.setBounds(20, 188, 500, 40);
        
        
        pilihDosen.addActionListener(this);
        pilihMahasiswa.addActionListener(this);
        logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == pilihDosen) {
            dispose();
            new ViewDosen();
        } else if(e.getSource() == pilihMahasiswa) {
            dispose();
            new ViewMahasiswa();
        } else if(e.getSource() == logout) {
            dispose();
            new LoginPage();
        }
    }
    
}