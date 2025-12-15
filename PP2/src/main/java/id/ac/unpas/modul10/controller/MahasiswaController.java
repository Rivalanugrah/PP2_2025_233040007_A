package id.ac.unpas.modul10.controller;

import id.ac.unpas.modul10.model.MahasiswaModel;
import id.ac.unpas.modul10.view.MahasiswaView;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MahasiswaController {
    
    private final MahasiswaModel model;
    private final MahasiswaView view;

    public MahasiswaController(MahasiswaView view) {
        this.view = view;
        this.model = new MahasiswaModel();
    }
    
    public void loadTable() {
        DefaultTableModel tableModel = view.getModel();
        model.loadData(tableModel);
    }

    // Aksi untuk Tombol Simpan (CREATE)
    public void simpanData() {
        String nama = view.getTxtNama().getText();
        String nim = view.getTxtNIM().getText();
        String jurusan = view.getTxtJurusan().getText();

        // VALIDASI INPUT KOSONG
        if (nama.trim().isEmpty() || nim.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // VALIDASI NIM DUPLIKAT
        if (model.isNIMExists(nim)) {
            JOptionPane.showMessageDialog(view, "NIM " + nim + 
            " sudah terdaftar. Gunakan NIM lain.", "NIM Duplikat", 
            JOptionPane.ERROR_MESSAGE);
            view.getTxtNIM().requestFocus();
            return;
        }

        if (model.tambahData(nama, nim, jurusan)) {
            JOptionPane.showMessageDialog(view, "Data Berhasil Disimpan");
            loadTable(); // Muat ulang tabel
            view.kosongkanForm(); // Kosongkan form di View
        }
    }
    
    // Aksi untuk Tombol Edit (UPDATE)
    public void ubahData() {
        String nama = view.getTxtNama().getText();
        String nim = view.getTxtNIM().getText();
        String jurusan = view.getTxtJurusan().getText();
        
        // VALIDASI INPUT KOSONG
        if (nama.trim().isEmpty() || nim.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (model.ubahData(nama, jurusan, nim)) {
            JOptionPane.showMessageDialog(view, "Data Berhasil Diubah");
            loadTable();
            view.kosongkanForm();
        }
    }
    
    // Aksi untuk Tombol Hapus (DELETE)
    public void hapusData() {
        String nim = view.getTxtNIM().getText();
        
        // VALIDASI HAPUS
        if (nim.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan "
                    + "dihapus!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (model.hapusData(nim)) {
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
            loadTable();
            view.kosongkanForm();
        }
    }
    
    // Aksi untuk Tombol Cari (SEARCH)
    public void cariData() {
        String kataKunci = view.getTxtCari().getText();
        DefaultTableModel tableModel = view.getModel();

        if (kataKunci.trim().isEmpty()) {
            loadTable(); // Jika kosong, muat semua data
            return;
        }
        
        model.cariData(tableModel, kataKunci);
    }
    
    // Aksi saat baris tabel diklik
    public void isiForm(int row) {
        view.getTxtNama().setText(view.getModel().getValueAt(row, 1).toString());
        view.getTxtNIM().setText(view.getModel().getValueAt(row, 2).toString());
        view.getTxtJurusan().setText(view.getModel().getValueAt(row, 3).toString());
    }
}