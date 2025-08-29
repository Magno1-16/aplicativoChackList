package com.magno.aplicativochacklist.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.magno.aplicativochacklist.bancoDBdao.DatabaseHelper;
import com.magno.aplicativochacklist.model.LoginModel;

public class LoginController {

    private DatabaseHelper dbHelper;

    public LoginController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Inserir usuário
    public boolean registrarUsuario(LoginModel usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());

        long result = db.insert(DatabaseHelper.TABLE_LOGIN, null, values);
        db.close();
        return result != -1;
    }

    // Verificar login
    public boolean autenticar(String email, String senha) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DatabaseHelper.TABLE_LOGIN,
                new String[]{"id"},
                "email=? AND senha=?",
                new String[]{email, senha},
                null, null, null
        );

        boolean autenticado = cursor.moveToFirst();
        cursor.close();
        db.close();
        return autenticado;
    }
}
