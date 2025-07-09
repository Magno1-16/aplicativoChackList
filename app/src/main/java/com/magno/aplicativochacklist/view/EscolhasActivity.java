package com.magno.aplicativochacklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.controller.EscolhasController;
import com.magno.aplicativochacklist.model.ChackModel;
import com.magno.aplicativochacklist.model.EscolhasModel;

import java.util.ArrayList;
import java.util.List;

public class EscolhasActivity extends AppCompatActivity {

    private RadioButton escolhaSim1, escolhaNao1;
    private RadioButton escolhaSim2, escolhaNao2;
    private RadioButton escolhaSim3, escolhaNao3;
    private RadioButton escolhaSim4, escolhaNao4;
    private RadioButton escolhaSim5, escolhaNao5;

    private EscolhasController controller;
    private ArrayList<ChackModel> listaChackRecebida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhas);

        controller = new EscolhasController();

        escolhaSim1 = findViewById(R.id.escolhaSim1);
        escolhaNao1 = findViewById(R.id.escolhaNao1);
        escolhaSim2 = findViewById(R.id.escolhaSim2);
        escolhaNao2 = findViewById(R.id.escolhaNao2);
        escolhaSim3 = findViewById(R.id.escolhaSim3);
        escolhaNao3 = findViewById(R.id.escolhaNao3);
        escolhaSim4 = findViewById(R.id.escolhaSim4);
        escolhaNao4 = findViewById(R.id.escolhaNao4);
        escolhaSim5 = findViewById(R.id.escolhaSim5);
        escolhaNao5 = findViewById(R.id.escolhaNao5);

        // Recebe a lista de ChackModel da activity anterior
        listaChackRecebida = (ArrayList<ChackModel>) getIntent().getSerializableExtra("listaChack");
    }

    public void onConfirmar(View view) {
        try {
            // Obtém as escolhas do usuário no segundo grupo
            List<EscolhasModel> listaEscolhas = controller.obterSelecoes2(
                    escolhaSim1, escolhaNao1,
                    escolhaSim2, escolhaNao2,
                    escolhaSim3, escolhaNao3,
                    escolhaSim4, escolhaNao4,
                    escolhaSim5, escolhaNao5
            );

            // Envia as listas para a FinalActivity
            Intent intent = new Intent(this, FinalActivity.class);
            intent.putExtra("listaChack", listaChackRecebida);
            intent.putExtra("listaEscolhas", new ArrayList<>(listaEscolhas));
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao confirmar escolhas: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
