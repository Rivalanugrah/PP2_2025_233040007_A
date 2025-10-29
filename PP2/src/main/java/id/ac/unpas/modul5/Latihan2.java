package id.ac.unpas.modul5;

/**
 *
 * @author ASUS
 */ 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 1. Buat objek JFrame
                JFrame frame = new JFrame("Jendela Pertamaku");

                // 2. Buat JLabel untuk menampilkan teks
                JLabel label = new JLabel("ini adalah JLabel!");

                // 3. Tambahkan label ke dalam frame
                frame.add(label);

                // 4. Atur ukuran jendela
                frame.setSize(400, 300);

                // 5. Atur aksi tombol close (X)
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // 6. Tampilkan jendela
                frame.setVisible(true);
            }
        });
    }
}

    