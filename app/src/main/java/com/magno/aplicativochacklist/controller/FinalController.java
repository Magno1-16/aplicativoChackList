package com.magno.aplicativochacklist.controller;

import com.magno.aplicativochacklist.model.ChackModel;
import com.magno.aplicativochacklist.model.FinalModel;

import java.util.ArrayList;
import java.util.List;

public class FinalController {

        public List<FinalModel> gerarResultados(List<ChackModel> chackList) {
            List<FinalModel> resultado = new ArrayList<>();

            for (ChackModel item : chackList) {
                String resposta;
                if (item.getSelecionado() == null) {
                    resposta = "Sem resposta";
                } else if (item.getSelecionado()) {
                    resposta = "Sim";
                } else {
                    resposta = "Não";
                }

                resultado.add(new FinalModel(item.getCategoria(), item.getNome(), resposta));
            }

            return resultado;
        }
    }


