package id.ac.unpas.modul9;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AplikasiFileIO extends JFrame {
    private JTextArea textArea;

    public AplikasiFileIO() {
        setTitle("Latihan 1 & 4 - File IO");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JButton btnOpen = new JButton("Buka File");
        JButton btnSave = new JButton("Simpan (Overwrite)");
        JButton btnAppend = new JButton("Simpan (Append)"); // Latihan 4

        panel.add(btnOpen);
        panel.add(btnSave);
        panel.add(btnAppend);

        add(panel, BorderLayout.SOUTH);

        btnOpen.addActionListener(e -> bukaFile());
        btnSave.addActionListener(e -> simpanOverwrite());
        btnAppend.addActionListener(e -> simpanAppend()); // Latihan 4
    }

    private void bukaFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void simpanOverwrite() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "Tersimpan (overwrite).");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    // ⭐ LATIHAN 4 — Simpan dengan APPEND
    private void simpanAppend() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (FileWriter fw = new FileWriter(file, true)) { // ← true → append
                fw.write(textArea.getText() + "\n");
                JOptionPane.showMessageDialog(this, "Teks ditambahkan (append).");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new AplikasiFileIO().setVisible(true);
    }
}
