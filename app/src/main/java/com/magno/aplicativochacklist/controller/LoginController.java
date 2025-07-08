package com.magno.aplicativochacklist.controller;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;

public class LoginController {

    private static final String NOME_PREFERENCES = "pref_listaVip";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public LoginController(Activity activity) {
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        editor = preferences.edit();
    }

    public void salvarLogin(String email, String senha) {
        editor.putString("email", email);
        editor.putString("senha", senha);
        editor.apply();
        Log.d("LoginController", "Dados salvos: " + email);
    }

    public String getEmailSalvo() {
        return preferences.getString("email", "");
    }

    public String getSenhaSalva() {
        return preferences.getString("senha", "");
    }

    public void limparButton(EditText email, EditText senha) {
        email.setText("");
        senha.setText("");
        editor.clear();
        editor.apply();
        Log.d("LoginController", "Dados limpos");
    }
}