package id.ac.unpas.modul10.model;

import id.ac.unpas.modul10.KoneksiDB; // Import KoneksiDB
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class MahasiswaModel {

    // 1. READ (Menampilkan Data)
    public DefaultTableModel loadData(DefaultTableModel model) {
        model.setRowCount(0); // Reset tabel
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM mahasiswa");

            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Load Data: " + e.getMessage());
        }
        return model;
    }
    
    // 2. CHECK NIM (Pengecekan apakah NIM sudah ada)
    public boolean isNIMExists(String nim) {
        try {
            String sql = "SELECT COUNT(*) FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            
            ResultSet res = pst.executeQuery();
            
            if (res.next()) {
                return res.getInt(1) > 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Cek NIM: " + e.getMessage());
            return true; 
        }
        return false;
    }

    // 3. CREATE (Menambah Data)
    public boolean tambahData(String nama, String nim, String jurusan) {
        try {
            String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, nama);
            pst.setString(2, nim);
            pst.setString(3, jurusan);

            pst.execute();
            return true; // Berhasil
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
            return false; // Gagal
        }
    }

    // 4. UPDATE (Mengubah Data)
    public boolean ubahData(String nama, String jurusan, String nim) {
        try {
            String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, nama);
            pst.setString(2, jurusan);
            pst.setString(3, nim);

            pst.executeUpdate();
            return true; // Berhasil
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Edit: " + e.getMessage());
            return false; // Gagal
        }
    }

    // 5. DELETE (Menghapus Data)
    public boolean hapusData(String nim) {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, nim);

            pst.execute();
            return true; // Berhasil
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
            return false; // Gagal
        }
    }
    
    // 6. SEARCH (Mencari Data berdasarkan Nama)
    public DefaultTableModel cariData(DefaultTableModel model, String kataKunci) {
        model.setRowCount(0); // Reset tabel
        
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?"; 
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, "%" + kataKunci + "%");
            
            ResultSet res = pst.executeQuery();

            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari Data: " + e.getMessage());
        }
        return model;
    }
}