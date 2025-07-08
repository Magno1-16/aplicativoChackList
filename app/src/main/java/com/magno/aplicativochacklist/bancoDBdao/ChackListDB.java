package com.magno.aplicativochacklist.bancoDBdao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.magno.aplicativochacklist.model.ChackModel;
import com.magno.aplicativochacklist.model.EscolhasModel;
import com.magno.aplicativochacklist.model.FinalModel;
import com.magno.aplicativochacklist.model.LoginModel;

import java.util.ArrayList;
import java.util.List;

public class ChackListDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "chacklist.db";
    private static final int DB_VERSION = 1;

    // Tabelas
    private static final String TABLE_CHACKS = "Chacks";
    private static final String TABLE_ESCOLHAS = "Escolhas";
    private static final String TABLE_RESULTADOS = "Resultados";
    private static final String TABLE_LOGIN = "Login";

    // Campos comuns
    private static final String KEY_ID = "id";

    // Campos ChackModel e EscolhasModel (mesmos nomes para facilitar)
    private static final String KEY_CATEGORIA = "categoria";
    private static final String KEY_NOME = "nome";
    private static final String KEY_SELECIONADO = "selecionado";

    // Campos FinalModel
    private static final String KEY_RESPOSTA = "resposta";

    // Campos LoginModel
    private static final String KEY_EMAIL = "email";
    private static final String KEY_SENHA = "senha";

    public ChackListDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHACKS_TABLE = "CREATE TABLE " + TABLE_CHACKS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_CATEGORIA + " TEXT," +
                KEY_NOME + " TEXT," +
                KEY_SELECIONADO + " INTEGER" +
                ")";

        String CREATE_ESCOLHAS_TABLE = "CREATE TABLE " + TABLE_ESCOLHAS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_CATEGORIA + " TEXT," +
                KEY_NOME + " TEXT," +
                KEY_SELECIONADO + " INTEGER" +
                ")";

        String CREATE_RESULTADOS_TABLE = "CREATE TABLE " + TABLE_RESULTADOS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_CATEGORIA + " TEXT," +
                KEY_NOME + " TEXT," +
                KEY_RESPOSTA + " TEXT" +
                ")";

        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_EMAIL + " TEXT," +
                KEY_SENHA + " TEXT" +
                ")";

        db.execSQL(CREATE_CHACKS_TABLE);
        db.execSQL(CREATE_ESCOLHAS_TABLE);
        db.execSQL(CREATE_RESULTADOS_TABLE);
        db.execSQL(CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHACKS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ESCOLHAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULTADOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        onCreate(db);
    }

    // --- Métodos para salvar dados em cada tabela ---

    public long salvarChack(ChackModel chack) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORIA, chack.getCategoria());
        values.put(KEY_NOME, chack.getNome());
        values.put(KEY_SELECIONADO, chack.getSelecionado() ? 1 : 0);
        long id = db.insert(TABLE_CHACKS, null, values);
        return id;
    }

    public long salvarEscolha(EscolhasModel escolha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORIA, escolha.getCategoria2());
        values.put(KEY_NOME, escolha.getNome2());
        values.put(KEY_SELECIONADO, escolha.getSelecionado2() ? 1 : 0);
        long id = db.insert(TABLE_ESCOLHAS, null, values);
        return id;
    }

    public long salvarResultado(FinalModel resultado) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORIA, resultado.getCategoria());
        values.put(KEY_NOME, resultado.getNome());
        values.put(KEY_RESPOSTA, resultado.getResposta());
        long id = db.insert(TABLE_RESULTADOS, null, values);
        return id;
    }

    public long salvarLogin(LoginModel login) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, login.getEmail());
        values.put(KEY_SENHA, login.getSenha());
        long id = db.insert(TABLE_LOGIN, null, values);
        return id;
    }

    // --- Métodos para buscar dados ---

    public List<ChackModel> buscarTodosChacks() {
        List<ChackModel> lista = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CHACKS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String categoria = cursor.getString(cursor.getColumnIndexOrThrow(KEY_CATEGORIA));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOME));
                int selecionadoInt = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_SELECIONADO));
                boolean selecionado = selecionadoInt == 1;
                lista.add(new ChackModel(categoria, nome, selecionado));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public List<EscolhasModel> buscarTodasEscolhas() {
        List<EscolhasModel> lista = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ESCOLHAS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String categoria = cursor.getString(cursor.getColumnIndexOrThrow(KEY_CATEGORIA));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOME));
                int selecionadoInt = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_SELECIONADO));
                boolean selecionado = selecionadoInt == 1;
                lista.add(new EscolhasModel(categoria, nome, selecionado));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public List<FinalModel> buscarTodosResultados() {
        List<FinalModel> lista = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_RESULTADOS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String categoria = cursor.getString(cursor.getColumnIndexOrThrow(KEY_CATEGORIA));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOME));
                String resposta = cursor.getString(cursor.getColumnIndexOrThrow(KEY_RESPOSTA));
                lista.add(new FinalModel(categoria, nome, resposta));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public List<LoginModel> buscarTodosLogins() {
        List<LoginModel> lista = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LOGIN, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String email = cursor.getString(cursor.getColumnIndexOrThrow(KEY_EMAIL));
                String senha = cursor.getString(cursor.getColumnIndexOrThrow(KEY_SENHA));
                lista.add(new LoginModel(email, senha));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    // Você pode criar outros métodos, como atualizar e remover, conforme precisar.
}
