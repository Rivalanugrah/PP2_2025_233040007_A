/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.modul8;

/**
 *
 * @author ASUS
 */

import id.ac.unpas.modul8.controller.PersegiPanjangController;
import id.ac.unpas.modul8.model.PersegiPanjangModel;
import id.ac.unpas.modul8.view.PersegiPanjangView;

public class Main {
    public static void main(String[] args) {
        //1. Instalasi Model
        PersegiPanjangModel model = new PersegiPanjangModel();
        
        //2. Instalasi View
        PersegiPanjangView view = new PersegiPanjangView();
        
        //3. Instalasi Controller (Hubungkan Model & View)
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        //4. Tampilkan View
        view.setVisible(true);
    }
    
}
