package com.magno.aplicativochacklist.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.magno.aplicativochacklist.bancoDBdao.DatabaseHelper;


public class LoginDBController {

    private DatabaseHelper dbHelper;

    public LoginDBController(Context context) {
        this.dbHelper = new DatabaseHelper(context);
    }

    // Registrar usuário
    public boolean registrarUsuario(String usuario, String senha) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Verifica se o usuário já existe
        Cursor cursor = db.rawQuery("SELECT id FROM Usuarios WHERE usuario = ?", new String[]{usuario});
        if (cursor.moveToFirst()) {
            cursor.close();
            db.close();
            return false; // Usuário já existe
        }
        cursor.close();

        ContentValues values = new ContentValues();
        values.put("usuario", usuario);
        values.put("senha", senha);

        long resultado = db.insert("Usuarios", null, values);
        db.close();
        return resultado != -1;
    }

    // Validar login
    public boolean validarLogin(String usuario, String senha) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT id FROM Usuarios WHERE usuario = ? AND senha = ?",
                new String[]{usuario, senha}
        );

        boolean loginValido = cursor.moveToFirst();

        cursor.close();
        db.close();
        return loginValido;
    }
}
