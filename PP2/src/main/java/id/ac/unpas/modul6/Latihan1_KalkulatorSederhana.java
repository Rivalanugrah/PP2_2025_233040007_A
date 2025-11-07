package id.ac.unpas.modul6;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author ASUS
 */


public class Latihan1_KalkulatorSederhana {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Komponen tampilan layar kalkulator
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField, BorderLayout.NORTH);

        // Panel tombol menggunakan GridLayout (4 baris x 4 kolom)
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4, 5, 5));

        // Tombol angka dan operator
        String[] tombol = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        for (String t : tombol) {
            JButton btn = new JButton(t);
            panelTombol.add(btn);
        }

        frame.add(panelTombol, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
