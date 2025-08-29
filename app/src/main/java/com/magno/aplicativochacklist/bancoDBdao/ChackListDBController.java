package com.magno.aplicativochacklist.bancoDBdao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.magno.aplicativochacklist.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ChackListDBController {

    private DatabaseHelper dbHelper;

    public ChackListDBController(Context context) {
        this.dbHelper = new DatabaseHelper(context);
    }

    // Inserir um item no banco
    public boolean inserirItem(ItemModel item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", item.getNome());
        values.put("categoria", item.getCategoria());
        values.put("selecionado", item.isSelecionado() ? 1 : 0);

        long resultado = db.insert("Itens", null, values);
        db.close();
        return resultado != -1;
    }

    // Listar todos os itens
    public List<ItemModel> listarItens() {
        List<ItemModel> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Itens", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
                String categoria = cursor.getString(cursor.getColumnIndexOrThrow("categoria"));
                boolean selecionado = cursor.getInt(cursor.getColumnIndexOrThrow("selecionado")) == 1;

                lista.add(new ItemModel(id, nome, categoria, selecionado));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return lista;
    }

    // Atualizar seleção do item
    public void atualizarSelecionado(int id, boolean selecionado) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("selecionado", selecionado ? 1 : 0);

        db.update("Itens", values, "id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Deletar um item
    public void deletarItem(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Itens", "id=?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Deletar todos os itens
    public void deletarTodos() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Itens", null, null);
        db.close();
    }
}
