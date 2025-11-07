package id.ac.unpas.modul6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author ASUS
 */
public class ContohActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh AcrionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        
        //1. Buat komponen (Event Source dan komponen lain)
        JLabel label = new JLabel("Hallo, klik tombol dibawah!");
        JButton button = new JButton("Klik saya");
        
        //2. Buat Event Listener
        //Kita menggunakan "anonymous inner class" di sini
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //3. Logiika yang dieksekusi saat event terjadi
                label.setText("Tombol telah diklik!");
            }
        };
        
        //4. Daftarkan listener ke source
        button.addActionListener(listener);
        
        //Tambahkan komponen ke frame
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}
