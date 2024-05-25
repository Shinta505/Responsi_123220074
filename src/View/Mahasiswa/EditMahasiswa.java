/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Model.Mahasiswa.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Lab Informatika
 */
public class EditMahasiswa extends JFrame {
    ControllerMahasiswa controller;
    
    JLabel header = new JLabel("Edit Mahasiswa");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputNIM = new JLabel("NIM");
    JTextField inputNama = new JTextField();
    JTextField inputNIM = new JTextField();
    JLabel labelInputEmail = new JLabel("Email");
    JLabel labelInputPassword = new JLabel("Password");
    JLabel labelInputAngkatan = new JLabel("Angkatan");
    JTextField inputEmail = new JTextField();
    JTextField inputPassword = new JTextField();
    JTextField inputAngkatan = new JTextField();
    JButton tombolEdit = new JButton("Edit Mahasiswa");
    JButton tombolKembali = new JButton("Kembali");

    public EditMahasiswa(ModelMahasiswa mahasiswa) {
        setTitle("Edit Mahasiswa");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480,240);

        add(header);
        add(labelInputNama);
        add(labelInputNIM);
        add(labelInputEmail);
        add(labelInputPassword);
        add(labelInputAngkatan);
        add(inputNama);
        add(inputNIM);
        add(inputEmail);
        add(inputPassword);
        add(inputAngkatan);
        add(tombolEdit);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputNIM.setBounds(20, 96, 440, 24);
        inputNIM.setBounds(18, 120, 440, 36);
        labelInputEmail.setBounds(20, 160, 440, 24);
        inputEmail.setBounds(18, 184, 440,36);
        labelInputPassword.setBounds(20, 224, 440, 24);
        inputPassword.setBounds(18, 248, 440, 36);
        labelInputAngkatan.setBounds(20, 288, 440, 24);
        inputAngkatan.setBounds(18, 312, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolEdit.setBounds(240, 160, 215, 40);
        inputNama.setText(mahasiswa.getNama());
        inputNIM.setText(mahasiswa.getNim());
        inputEmail.setText(mahasiswa.getEmail());
        inputPassword.setText(mahasiswa.getPassword());
        inputAngkatan.setText(mahasiswa.getAngkatan());
        
        controller = new ControllerMahasiswa(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewMahasiswa();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editMahasiswa(mahasiswa.getId());
            }
        });
    }
    
    public String getInputNama() {
        return inputNama.getText();
    }
    
    public String getInputNIM() {
        return inputNIM.getText();
    }
    
    public String getInputEmail() {
        return inputEmail.getText();
    }
    
    public String getInputPassword() {
        return inputPassword.getText();
    }
    
    public String getInputAngkatan() {
        return inputAngkatan.getText();
    }
}
