/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dosen;

import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public interface InterfaceDAODosen {
    // Method untuk memasukkan suatu data dosen
    public void insert(ModelDosen dosen);
    
    // Method untuk mengupdate (mengedit) suatu data dosen
    public void update(ModelDosen dosen);
    
    // Method untuk menghapus suatu data dosen
    public void delete(int id);
    
    // Method untuk mengambil data dosen
    public List<ModelDosen> getAll();
}
