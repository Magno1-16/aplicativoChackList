package com.magno.aplicativochacklist.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.magno.aplicativochacklist.R;
import com.magno.aplicativochacklist.bancoDBdao.ChackListDB;
import com.magno.aplicativochacklist.model.ChackModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutItens;
    private Button btnResumo;
    private ChackListDB db;
    private List<ChackModel> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhas);

        layoutItens = findViewById(R.id.layoutContainer);
        btnResumo = findViewById(R.id.confirmarEscolhas);

        db = new ChackListDB(this);

        carregarItens();

        btnResumo.setOnClickListener(v -> {
            // Aqui você pode enviar os dados para a FinalActivity
        });
    }

    private void carregarItens() {
        layoutItens.removeAllViews(); // Limpa o layout antes de preencher
        itens = db.buscarTodosChacks(); // Busca do banco

        for (ChackModel item : itens) {
            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.VERTICAL);
            itemLayout.setPadding(16, 16, 16, 16);

            TextView tvCategoria = new TextView(this);
            tvCategoria.setText("Categoria: " + item.getCategoria());
            tvCategoria.setTextColor(getResources().getColor(android.R.color.white));

            TextView tvNome = new TextView(this);
            tvNome.setText("Item: " + item.getNome());
            tvNome.setTextColor(getResources().getColor(android.R.color.white));

            RadioGroup radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(RadioGroup.HORIZONTAL);

            RadioButton rbSim = new RadioButton(this);
            rbSim.setText("Sim");
            RadioButton rbNao = new RadioButton(this);
            rbNao.setText("Não");

            radioGroup.addView(rbSim);
            radioGroup.addView(rbNao);

            // Seta o valor inicial do item
            if (item.getSelecionado() != null && item.getSelecionado()) {
                rbSim.setChecked(true);
            } else if (item.getSelecionado() != null) {
                rbNao.setChecked(true);
            }

            // Listener para atualizar no banco ao mudar
            radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
                boolean selecionado = checkedId == rbSim.getId();
                db.atualizarSelecionado(item.getCategoria(), item.getNome(), selecionado);
                item.setSelecionado(selecionado);
            });

            itemLayout.addView(tvCategoria);
            itemLayout.addView(tvNome);
            itemLayout.addView(radioGroup);

            layoutItens.addView(itemLayout);
        }
    }
}
