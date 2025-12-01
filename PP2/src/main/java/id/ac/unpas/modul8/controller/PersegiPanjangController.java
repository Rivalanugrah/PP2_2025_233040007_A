package id.ac.unpas.modul8.controller;

import id.ac.unpas.modul8.model.PersegiPanjangModel;
import id.ac.unpas.modul8.view.PersegiPanjangView;
import java.awt.event.*;

public class PersegiPanjangController {

    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        view.addHitungListener(new HitungListener());
        view.addResetListener(new ResetListener());
    }

    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungLuas();
                model.hitungKeliling();

                view.setLuas(model.getLuas());
                view.setKeliling(model.getKeliling());

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Input harus berupa angka!");
            }
        }
    }

    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.reset();
        }
    }
}
