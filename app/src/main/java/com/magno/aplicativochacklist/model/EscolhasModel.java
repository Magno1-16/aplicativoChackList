package com.magno.aplicativochacklist.model;

import java.io.Serializable;

public class EscolhasModel implements Serializable {
    private String categoria2;
    private String nome2;
    private Boolean selecionado2;

    public EscolhasModel(String categoria2, String nome2, Boolean selecionado2) {
        this.categoria2 = categoria2;
        this.nome2 = nome2;
        this.selecionado2 = selecionado2;
    }

    public String getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(String categoria2) {
        this.categoria2 = categoria2;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }

    public Boolean getSelecionado2() {
        return selecionado2;
    }

    public void setSelecionado2(Boolean selecionado2) {
        this.selecionado2 = selecionado2;
    }

    @Override
    public String toString() {
        return "EscolhasModel{" +
                "categoria2='" + categoria2 + '\'' +
                ", nome2='" + nome2 + '\'' +
                ", selecionado2=" + selecionado2 +
                '}';
    }
}
