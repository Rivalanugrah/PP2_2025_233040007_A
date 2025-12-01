/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul8.view;

/**
 *
 * @author ASUS
 */


import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PersegiPanjangView extends JFrame {

    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblLuas = new JLabel("-");
    private JLabel lblKeliling = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.setLayout(new GridLayout(5, 2, 10, 10));
        this.setTitle("Kalkulator Persegi Panjang");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);

        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);

        this.add(new JLabel("Luas:"));
        this.add(lblLuas);

        this.add(new JLabel("Keliling:"));
        this.add(lblKeliling);

        this.add(btnHitung);
        this.add(btnReset);
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    public void setLuas(double hasil) {
        lblLuas.setText(String.valueOf(hasil));
    }

    public void setKeliling(double hasil) {
        lblKeliling.setText(String.valueOf(hasil));
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    // Listener tombol hitung
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }

    // Listener tombol reset
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }

    // Reset UI
    public void reset() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblLuas.setText("-");
        lblKeliling.setText("-");
    }
}
