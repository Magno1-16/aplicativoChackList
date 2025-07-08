package com.magno.aplicativochacklist.model;

public class FinalModel {


        private String categoria;
        private String nome;
        private String resposta;

        public FinalModel(String categoria, String nome, String resposta) {
            this.categoria = categoria;
            this.nome = nome;
            this.resposta = resposta;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getNome() {
            return nome;
        }

        public String getResposta() {
            return resposta;
        }
    }


