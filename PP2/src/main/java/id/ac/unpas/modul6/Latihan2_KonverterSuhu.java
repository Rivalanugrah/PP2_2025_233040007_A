package id.ac.unpas.modul6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ASUS
 */

public class Latihan2_KonverterSuhu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lblC = new JLabel("Celcius:");
        JTextField txtC = new JTextField(10);
        JButton btnKonversi = new JButton("Konversi");
        JLabel lblF = new JLabel("Fahrenheit:");
        JLabel lblHasil = new JLabel("...");

        frame.add(lblC);
        frame.add(txtC);
        frame.add(btnKonversi);
        frame.add(lblF);
        frame.add(lblHasil);

        // Event handling dengan ActionListener
        btnKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(txtC.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    lblHasil.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, 
                        "Input harus berupa angka!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
