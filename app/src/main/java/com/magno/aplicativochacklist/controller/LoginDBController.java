package com.magno.aplicativochacklist.controller;

import android.content.Context;

import com.magno.aplicativochacklist.bancoDBdao.ChackListDB;
import com.magno.aplicativochacklist.model.LoginModel;

import java.util.List;

public class LoginDBController {

    private ChackListDB db;

    public LoginDBController(Context context) {
        db = new ChackListDB(context);
    }

    // Salvar login no banco
    public boolean salvarLoginBanco(String email, String senha) {
        LoginModel login = new LoginModel(email, senha);
        long id = db.salvarLogin(login);
        return id != -1;
    }

    // Verificar se o login existe no banco
    public boolean verificarLogin(String email, String senha) {
        List<LoginModel> listaLogins = db.buscarTodosLogins();
        for (LoginModel login : listaLogins) {
            if (login.getEmail().equals(email) && login.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
