package id.ac.unpas.modul5;

/**
 *
 * @author ASUS
 */
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 1. Buat objek JFrame
                JFrame frame = new JFrame("Label dan Tombol");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 200);

                // 2. Atur layout manager (FlowLayout)
                frame.setLayout(new FlowLayout());

                // 3. Buat komponen JLabel dan JButton
                JLabel label = new JLabel("Teks Awal");
                JButton button = new JButton("Klik Saya!");

                // 4. Tambahkan aksi ke tombol (ActionListener)
                button.addActionListener(e -> {
                    label.setText("Tombol berhasil diklik!");
                });

                // 5. Tambahkan komponen ke frame
                frame.add(label);
                frame.add(button);

                // 6. Tampilkan frame
                frame.setVisible(true);
            }
        });
    }
}
