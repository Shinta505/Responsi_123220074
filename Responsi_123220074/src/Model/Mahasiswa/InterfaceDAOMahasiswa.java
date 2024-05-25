/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Mahasiswa;

import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public interface InterfaceDAOMahasiswa {
    // Method untuk memasukkan suatu data mahasiswa
    public void insert(ModelMahasiswa mahasiswa);
    
    // Method untuk mengupdate (mengedit) suatu data mahasiswa
    public void update(ModelMahasiswa mahasiswa);
    
    // Method untuk menghapus suatu data mahasiswa
    public void delete(int id);
    
    // Method untuk mengambil data mahasiswa
    public List<ModelMahasiswa> getAll();
}
