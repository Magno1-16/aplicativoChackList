package com.magno.aplicativochacklist.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.controller.ItemController;
import com.magno.aplicativochacklist.model.ItemModel;

import java.util.List;

public class FinalActivity extends AppCompatActivity {

    private TextView txtResultado;
    private ItemController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        txtResultado = findViewById(R.id.txtResultado);
        controller = new ItemController(this);

        exibirItensSelecionados();
    }

    private void exibirItensSelecionados() {
        List<ItemModel> lista = controller.listarItens();
        StringBuilder builder = new StringBuilder();

        for (ItemModel item : lista) {
            if (item.isSelecionado()) {
                builder.append("- ").append(item.getNome())
                        .append(" (").append(item.getCategoria()).append(")\n");
            }
        }

        if (builder.length() == 0) {
            builder.append("Nenhum item selecionado.");
        }

        txtResultado.setText(builder.toString());
    }
}
