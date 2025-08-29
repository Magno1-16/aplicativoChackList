package com.magno.aplicativochacklist.model;

public class ItemModel {
    private int id;
    private String nome;
    private String categoria;
    private boolean selecionado;

    public ItemModel() {}

    public ItemModel(int id, String nome, String categoria, boolean selecionado) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.selecionado = selecionado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public boolean isSelecionado() { return selecionado; }
    public void setSelecionado(boolean selecionado) { this.selecionado = selecionado; }
}
