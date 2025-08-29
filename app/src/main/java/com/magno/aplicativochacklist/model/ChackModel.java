// app/src/main/java/com/magno/aplicativochacklist/model/ChackModel.java
package com.magno.aplicativochacklist.model;

import java.io.Serializable;

public class ChackModel implements Serializable {
    private String categoria;
    private String nome;
    private Boolean selecionado;

    public ChackModel(String categoria, String nome, Boolean selecionado) {
        this.categoria = categoria;
        this.nome = nome;
        this.selecionado = selecionado;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Boolean getSelecionado() { return selecionado; }
    public void setSelecionado(Boolean selecionado) { this.selecionado = selecionado; }

    @Override public String toString() {
        return "ChackModel{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", selecionado=" + selecionado +
                '}';
    }
}
