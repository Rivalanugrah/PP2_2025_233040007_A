package id.ac.unpas.modul5;

/**
 *
 * @author ASUS
 */
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //1. Atur layout Manager ke BorderLayout
                //Sebenarnya ini tidak perlu
                //karena BorderLayout adalah Layout Manager default
                frame.setLayout(new BorderLayout());

                //2. Buat Komponen
                JLabel label = new JLabel("Label ada di Atas (NORTH)");
                JButton button = new JButton("Tombol ada di Bawah (SOUTH)");

                //3. Tambahkan Aksi (ActionListener) ke tombol
                button.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });
                
                // Tombol WEST
                 JButton buttonWest = new JButton("WEST");
                buttonWest.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });
                
                     // Tombol EAST
                JButton buttonEast = new JButton("EAST");
                buttonEast.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });
                
                   // Tombol CENTER
                JButton buttonCenter = new JButton("CENTER");
                buttonCenter.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });
                
                //4. Tambahkan komponen ke frame DENGAN POSISI
                frame.add(label, BorderLayout.NORTH);
                frame.add(button, BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);

                // Tampilkan frame
                frame.setVisible(true);
            }
        });
    }
}
