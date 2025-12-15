package id.ac.unpas.modul10.view;

import id.ac.unpas.modul10.controller.MahasiswaController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MahasiswaView extends JFrame {

    // Komponen GUI (Dibuat public agar bisa diakses Controller, atau gunakan Getter)
    private JTextField txtNama, txtNIM, txtJurusan;
    private JTextField txtCari;
    private JButton btnSimpan, btnEdit, btnHapus, btnClear;
    private JButton btnCari;
    private JTable tableMahasiswa;
    private DefaultTableModel model;
    
    private final MahasiswaController controller; // Referensi ke Controller

    public MahasiswaView() {
        // Inisialisasi Controller dan hubungkan ke View ini
        controller = new MahasiswaController(this);
        
        // Setup Frame
        setTitle("Aplikasi CRUD Mahasiswa JDBC (MVC)");
        setSize(700, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- PEMBENTUKAN KOMPONEN GUI ---
        
        // 1. Panel Form (Input Data)
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        // Panel Tombol Aksi (Simpan, Edit, Hapus, Clear)
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        // Panel Pencarian
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtCari = new JTextField(20); 
        btnCari = new JButton("Cari");

        panelCari.add(new JLabel("Cari Nama:"));
        panelCari.add(txtCari);
        panelCari.add(btnCari);
        
        // Gabungkan Panel Form, Tombol, dan Cari di bagian Atas (NORTH)
        JPanel panelInputDanAksi = new JPanel(new BorderLayout());
        panelInputDanAksi.add(panelTombol, BorderLayout.NORTH);
        panelInputDanAksi.add(panelCari, BorderLayout.SOUTH); 
        
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelInputDanAksi, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);

        // 2. Tabel Data (Menampilkan Data)
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");

        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);

        // --- Event Listeners (Memanggil Controller) ---
        
        // Listener Klik Tabel 
        tableMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                controller.isiForm(row); // Panggil Controller untuk mengisi form
            }
        });

        // Aksi Tombol Simpan
        btnSimpan.addActionListener(e -> controller.simpanData());

        // Aksi Tombol Edit
        btnEdit.addActionListener(e -> controller.ubahData());

        // Aksi Tombol Hapus
        btnHapus.addActionListener(e -> controller.hapusData());
        
        // Aksi Tombol Cari
        btnCari.addActionListener(e -> controller.cariData()); 

        // Aksi Tombol Clear
        btnClear.addActionListener(e -> kosongkanForm());

        // Muat data awal melalui Controller
        controller.loadTable();
    }
    
    // --- GETTER dan METHOD PENDUKUNG untuk Controller ---
    
    public JTextField getTxtNama() {
        return txtNama;
    }

    public JTextField getTxtNIM() {
        return txtNIM;
    }

    public JTextField getTxtJurusan() {
        return txtJurusan;
    }
    
    public JTextField getTxtCari() {
        return txtCari;
    }
    
    public DefaultTableModel getModel() {
        return model;
    }

    public void kosongkanForm() {
        txtNama.setText(null);
        txtNIM.setText(null);
        txtJurusan.setText(null);
        txtCari.setText(null);
    }

    public static void main(String[] args) {
        // Menjalankan Aplikasi di View
        SwingUtilities.invokeLater(() -> new MahasiswaView().setVisible(true));
    }
}