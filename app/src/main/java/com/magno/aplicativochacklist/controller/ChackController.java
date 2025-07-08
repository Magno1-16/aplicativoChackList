package com.magno.aplicativochacklist.controller;

import android.widget.RadioButton;
import com.magno.aplicativochacklist.model.ChackModel;
import java.util.ArrayList;
import java.util.List;

public class ChackController {


    public List<ChackModel> obterSelecoes(
            RadioButton sim1, RadioButton nao1,
            RadioButton sim2, RadioButton nao2,
            RadioButton sim3, RadioButton nao3,
            RadioButton sim4, RadioButton nao4,
            RadioButton sim5, RadioButton nao5
    ) {
        List<ChackModel> selecionados = new ArrayList<>();

        Boolean sel1 = sim1.isChecked();
        Boolean sel2 = sim2.isChecked();
        Boolean sel3 = sim3.isChecked();
        Boolean sel4 = sim4.isChecked();
        Boolean sel5 = sim5.isChecked();

        selecionados.add(new ChackModel("Tecnologia", "Placa de Vídeo", sel1));
        selecionados.add(new ChackModel("Decoração", "Vaso de Flor", sel2));
        selecionados.add(new ChackModel("Higiene Pessoal", "Shampoo, Condicionador e Sabonete", sel3));
        selecionados.add(new ChackModel("Roupas", "Camisetas, Calças e Sapatos", sel4));
        selecionados.add(new ChackModel("Acessórios", "Corrente, Pulseira, Anel e Brinco", sel5));

        return selecionados;
    }
}
