package id.ac.unpas.modul5;

/**
 *
 * @author ASUS
 */
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

/**
 * @author ASUS
 */
public class Latihan1 {
    public static void main(String[] args) {
        // Menjalankan kode GUI di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 1. Buat objek JFrame
                JFrame frame = new JFrame("Jendela Pertamaku");

                // 2. Atur ukuran jendela
                frame.setSize(400, 300);

                // 3. Atur aksi tombol close (X)
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 4. Tampilkan jendela
                frame.setVisible(true);
            }
        });
    }
}

