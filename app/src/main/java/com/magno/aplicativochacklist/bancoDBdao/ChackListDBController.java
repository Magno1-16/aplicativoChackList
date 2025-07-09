package com.magno.aplicativochacklist.bancoDBdao;

import android.content.Context;

import com.magno.aplicativochacklist.model.ChackModel;
import com.magno.aplicativochacklist.model.EscolhasModel;
import com.magno.aplicativochacklist.model.FinalModel;
import com.magno.aplicativochacklist.model.LoginModel;

import java.util.List;

public class ChackListDBController {

    private ChackListDB db;

    public ChackListDBController(Context context) {
        db = new ChackListDB(context);
    }

    // Salvar métodos
    public boolean salvarChack(ChackModel chack) {
        long id = db.salvarChack(chack);
        return id != -1;
    }

    public boolean salvarEscolha(EscolhasModel escolha) {
        long id = db.salvarEscolha(escolha);
        return id != -1;
    }

    public boolean salvarResultado(FinalModel resultado) {
        long id = db.salvarResultado(resultado);
        return id != -1;
    }

    public boolean salvarLogin(LoginModel login) {
        long id = db.salvarLogin(login);
        return id != -1;
    }

    // Buscar métodos
    public List<ChackModel> buscarTodosChacks() {
        return db.buscarTodosChacks();
    }

    public List<EscolhasModel> buscarTodasEscolhas() {
        return db.buscarTodasEscolhas();
    }

    public List<FinalModel> buscarTodosResultados() {
        return db.buscarTodosResultados();
    }

    public List<LoginModel> buscarTodosLogins() {
        return db.buscarTodosLogins();
    }

    public boolean validarLogin(String email, String senha) {
        List<LoginModel> lista = buscarTodosLogins();
        for (LoginModel login : lista) {
            if (login.getEmail().equals(email) && login.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

}
