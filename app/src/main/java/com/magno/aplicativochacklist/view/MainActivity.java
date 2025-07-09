package com.magno.aplicativochacklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.bancoDBdao.ChackListDBController;
import com.magno.aplicativochacklist.controller.ChackController;
import com.magno.aplicativochacklist.model.ChackModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioSim1, radioNao1;
    private RadioButton radioSim2, radioNao2;
    private RadioButton radioSim3, radioNao3;
    private RadioButton radioSim4, radioNao4;
    private RadioButton radioSim5, radioNao5;
    private ChackController controller;
    private ChackListDBController controllerDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ChackController();
        controllerDB = new ChackListDBController(this);

        radioSim1 = findViewById(R.id.radioSim1);
        radioNao1 = findViewById(R.id.radioNao1);
        radioSim2 = findViewById(R.id.radioSim2);
        radioNao2 = findViewById(R.id.radioNao2);
        radioSim3 = findViewById(R.id.radioSim3);
        radioNao3 = findViewById(R.id.radioNao3);
        radioSim4 = findViewById(R.id.radioSim4);
        radioNao4 = findViewById(R.id.radioNao4);
        radioSim5 = findViewById(R.id.radioSim5);
        radioNao5 = findViewById(R.id.radioNao5);
    }

    public void onConfirmar(View view) {
        // Verifica se todas as perguntas foram respondidas
        if (!estaSelecionado(radioSim1, radioNao1) ||
                !estaSelecionado(radioSim2, radioNao2) ||
                !estaSelecionado(radioSim3, radioNao3) ||
                !estaSelecionado(radioSim4, radioNao4) ||
                !estaSelecionado(radioSim5, radioNao5)) {

            Toast.makeText(this, "Por favor, responda todas as perguntas.", Toast.LENGTH_SHORT).show();
            return; // Não permite continuar
        }

        List<ChackModel> lista = controller.obterSelecoes(
                radioSim1, radioNao1,
                radioSim2, radioNao2,
                radioSim3, radioNao3,
                radioSim4, radioNao4,
                radioSim5, radioNao5
        );

        // Salvar lista no banco
        boolean todosSucesso = true;
        for (ChackModel c : lista) {
            boolean res = controllerDB.salvarChack(c);
            if (!res) {
                todosSucesso = false;
                break;
            }
        }

        if (todosSucesso) {
            Toast.makeText(this, "Itens salvos com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro ao salvar alguns itens", Toast.LENGTH_SHORT).show();
        }

        // Passar lista para próxima Activity
        Intent intent = new Intent(MainActivity.this, EscolhasActivity.class);
        intent.putExtra("listaChack", new ArrayList<>(lista));
        startActivity(intent);
    }

    // Método para verificar se pelo menos um radio do par está marcado
    private boolean estaSelecionado(RadioButton sim, RadioButton nao) {
        return sim.isChecked() || nao.isChecked();
    }
}
