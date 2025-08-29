package com.magno.aplicativochacklist.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.magno.aplicativochacklist.bancoDBdao.DatabaseHelper;
import com.magno.aplicativochacklist.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ItemController {

    private DatabaseHelper dbHelper;

    public ItemController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Inserir item
    public boolean adicionarItem(ItemModel item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOME, item.getNome());
        values.put(DatabaseHelper.COLUMN_CATEGORIA, item.getCategoria());
        values.put(DatabaseHelper.COLUMN_SELECIONADO, item.isSelecionado() ? 1 : 0);

        long resultado = db.insert(DatabaseHelper.TABLE_ITENS, null, values);
        db.close();
        return resultado != -1;
    }

    // Buscar todos
    public List<ItemModel> listarItens() {
        List<ItemModel> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.TABLE_ITENS,
                null, null, null, null, null, DatabaseHelper.COLUMN_ID + " DESC");

        if (cursor.moveToFirst()) {
            do {
                ItemModel item = new ItemModel();
                item.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)));
                item.setNome(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NOME)));
                item.setCategoria(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CATEGORIA)));
                item.setSelecionado(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_SELECIONADO)) == 1);

                lista.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lista;
    }

    // Atualizar seleção
    public void atualizarSelecionado(int id, boolean selecionado) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_SELECIONADO, selecionado ? 1 : 0);
        db.update(DatabaseHelper.TABLE_ITENS, values,
                DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
