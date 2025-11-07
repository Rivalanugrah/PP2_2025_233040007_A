package id.ac.unpas.modul6;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author ASUS
 */
public class ContohBoarderLayout {
    public static void main(String[] args) {
        //1. Buat frame 
        JFrame frame =  new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        //JFrame sudah menggunakan BorderLayout secara default
        
        //2. Buat dan tambahkan komponen ke 5 wilayah
        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);
        
        //3. Tampilkan frame
        frame.setVisible(true);
    }
}
