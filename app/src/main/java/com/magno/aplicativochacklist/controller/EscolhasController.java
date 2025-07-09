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
            RadioButton sim5, RadioButton nao5) {

        List<EscolhasModel> escolhas = new ArrayList<>();

        // Atenção: aqui você coloca a categoria e nome corretos para cada item,
        // com categoria no primeiro parâmetro e nome no segundo, sempre nesta ordem.

        escolhas.add(new EscolhasModel(
                "Alimentos",                   // categoria2
                "Banana, Cenoura e batata",   // nome2
                sim1.isChecked() ? true : nao1.isChecked() ? false : null));

        escolhas.add(new EscolhasModel(
                "Bebidas",
                "Coca Cola, Fanta Uva e Suco Del Valle",
                sim2.isChecked() ? true : nao2.isChecked() ? false : null));

        escolhas.add(new EscolhasModel(
                "Moveis",
                "Cadeira de Praia, Mesa de Plástico e Sofá",
                sim3.isChecked() ? true : nao3.isChecked() ? false : null));

        escolhas.add(new EscolhasModel(
                "Cuidados Pessoais",
                "Creme de pele, Protetor Solar e Creme Corporal",
                sim4.isChecked() ? true : nao4.isChecked() ? false : null));

        escolhas.add(new EscolhasModel(
                "Bebidas Alcoólicas",
                "Gin, Whisky, Heiniken, Amstel",
                sim5.isChecked() ? true : nao5.isChecked() ? false : null));

        return escolhas;
    }
}
