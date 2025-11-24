/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul7;

/**
 *
 * @author ASUS
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Tugas_ManajemenNilaiSiswaApp extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // ================= TAB INPUT PANEL =================
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label + Input Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Label + Input Mata Pelajaran
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {
                "Matematika Dasar", "Bahasa Indonesia",
                "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"
        };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // Label + Input Nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);

        // Tombol Reset
        JButton btnReset = new JButton("Reset");
        panel.add(btnReset);

        // Event Simpan
        btnSimpan.addActionListener(e -> prosesSimpan());

        // Event Reset
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
        });

        return panel;
    }

    // ================= TAB TABEL PANEL =================
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Tabel
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel bawah untuk tombol hapus
        JButton btnHapus = new JButton("Hapus Data");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnHapus);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Event hapus baris
        btnHapus.addActionListener(e -> {
            int selectedRow = tableData.getSelectedRow();
            if (selectedRow > -1) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
            }
        });

        return panel;
    }

    // ================= LOGIKA SIMPAN =================
    private void prosesSimpan() {
        String nama = txtNama.getText().trim();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText().trim();

        // Validasi Nama (minimal 3 karakter)
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama minimal harus 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi angka
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Logika Grade dengan SWITCH
        String grade;
        int grup = nilai / 10;
        switch (grup) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }

        // Masukkan ke tabel
        tableModel.addRow(new Object[]{nama, matkul, nilai, grade});
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");

        // Reset input
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        // Pindah tab
        tabbedPane.setSelectedIndex(1);
    }

    // ================= CONSTRUCTOR =================
    public Tugas_ManajemenNilaiSiswaApp() {

        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Input Data", createInputPanel());
        tabbedPane.addTab("Daftar Nilai", createTablePanel());

        add(tabbedPane);
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Tugas_ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}

