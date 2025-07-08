package com.magno.aplicativochacklist.controller;

import android.widget.RadioButton;
import com.magno.aplicativochacklist.model.EscolhasModel;
import java.util.ArrayList;
import java.util.List;

public class EscolhasController {
    public List<EscolhasModel> obterSelecoes2(
            RadioButton sim1, RadioButton nao1,
            RadioButton sim2, RadioButton nao2,
            RadioButton sim3, RadioButton nao3,
            RadioButton sim4, RadioButton nao4,
            RadioButton sim5, RadioButton nao5
    ) {
        List<EscolhasModel> selecionados = new ArrayList<>();

        Boolean sel1 = sim1.isChecked();
        Boolean sel2 = sim2.isChecked();
        Boolean sel3 = sim3.isChecked();
        Boolean sel4 = sim4.isChecked();
        Boolean sel5 = sim5.isChecked();

        selecionados.add(new EscolhasModel("Banana, Cenoura e batata", "Alimentos", sel1));
        selecionados.add(new EscolhasModel("Coca Cola, Fanta Uva e Suco Del Valle", "Bebidas", sel2));
        selecionados.add(new EscolhasModel("Cadeira de Praia, Mesa de Plastico e Sofá", "Móveis", sel3));
        selecionados.add(new EscolhasModel("Creme de pele, Protetor Solar e Creme Corporal", "Cuidados Pessoais", sel4));
        selecionados.add(new EscolhasModel("Gin, Whisky, Heineken, Amstel", "Bebidas Alcoólicas", sel5));

        return selecionados;
    }
}
