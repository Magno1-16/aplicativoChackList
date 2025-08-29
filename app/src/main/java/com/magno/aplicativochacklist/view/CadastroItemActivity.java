package com.magno.aplicativochacklist.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.controller.ItemController;
import com.magno.aplicativochacklist.model.ItemModel;


public class CadastroItemActivity extends AppCompatActivity {

    private EditText editNome, editCategoria;
    private Button btnSalvar;
    private ItemController itemController;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_item);

        editNome = findViewById(R.id.editNome);
        editCategoria = findViewById(R.id.editCategoria);
        btnSalvar = findViewById(R.id.btnSalvar);

        itemController = new ItemController(this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarItem();
            }
        });
    }

    private void salvarItem() {
        String nome = editNome.getText().toString().trim();
        String categoria = editCategoria.getText().toString().trim();

        if (nome.isEmpty()) {
            Toast.makeText(this, "Digite o nome do item", Toast.LENGTH_SHORT).show();
            return;
        }

        ItemModel item = new ItemModel();
        item.setNome(nome);
        item.setCategoria(categoria);
        item.setSelecionado(false);

        boolean resultado = itemController.adicionarItem(item);

        if (resultado) {
            Toast.makeText(this, "Item cadastrado!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }
    }
}
