/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Dosen;

import Controller.ControllerDosen;
import Main.MenuPage;
import Model.Dosen.ModelDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ViewDosen extends JFrame {
    Integer baris;
    
    ControllerDosen controller;
    
    JLabel header = new JLabel("Selamat Datang!");
    JButton kembali = new JButton("Kembali");
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolHapus = new JButton("Hapus Dosen");
    JButton tombolKembali = new JButton("Kembali");
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    String namaKolom[] = {"ID", "Nama Dosen", "NO HP", "Email"};

    public ViewDosen() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        setTitle("Daftar Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 600);
        
        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);
        add(tombolKembali);
        
        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 456, 512, 40);
        tombolKembali.setBounds(20, 506, 512, 40);
        
        controller = new ControllerDosen(this);
        controller.showAllDosen();
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Mengambil baris ke-n dari tabel
                baris = table.getSelectedRow();
            }
        });
        
        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputDosen();
            }
        });
        
        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    ModelDosen dosenTerpilih = new ModelDosen();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String nohp = table.getValueAt(baris, 2).toString();
                    String email = table.getValueAt(baris, 3).toString();

//                    dosenTerpilih.setId(id);
                    dosenTerpilih.setNama(nama);
                    dosenTerpilih.setNo_hp(nohp);
                    dosenTerpilih.setEmail(email);

                    dispose();
                    new EditDosen(dosenTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
//                new MenuPage();
            }
        });
    }
    
    public JTable getTableDosen() {
        return table;
    }
}
