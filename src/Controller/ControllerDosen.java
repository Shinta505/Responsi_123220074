/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dosen.*;
import View.Dosen.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class ControllerDosen {
    ViewDosen halamanTable;
    InputDosen halamanInput;
    EditDosen halamanEdit;
    
    InterfaceDAODosen daoDosen;
    
    List<ModelDosen> daftarDosen;

    public ControllerDosen(ViewDosen halamanTable) {
        this.halamanTable = halamanTable;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(InputDosen halamanInput) {
        this.halamanInput = halamanInput;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(EditDosen halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoDosen = new DAODosen();
    }

    public void showAllDosen() {
        daftarDosen = daoDosen.getAll();
        
        ModelTable table = new ModelTable(daftarDosen);

        halamanTable.getTableDosen().setModel(table);
    }
    
    public void insertDosen() {
        try {
            ModelDosen dosenBaru = new ModelDosen();
            
            String nama = halamanInput.getInputNama();
            String nohp = halamanInput.getInputNoHP();

            if ("".equals(nama) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            dosenBaru.setNama(nama);
            dosenBaru.setNidn(nidn);
            
            daoDosen.insert(dosenBaru);
            
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");
            
            halamanInput.dispose();
            new ViewDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
     public void editDosen(int id) {
        try {
            ModelDosen dosenYangMauDiedit = new ModelDosen();

            String nama = halamanEdit.getInputNama();
            String nidn = halamanEdit.getInputNIDN();

            if ("".equals(nama) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }

            dosenYangMauDiedit.setId(id);
            dosenYangMauDiedit.setNama(nama);
            dosenYangMauDiedit.setNidn(nidn);

            daoDosen.update(dosenYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Dosen dosen berhasil diubah.");

            halamanEdit.dispose();
            new ViewDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
     
     public void deleteDosen(Integer baris) {
//        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoDosen.delete(id);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            showAllDosen();
        }
    }
}