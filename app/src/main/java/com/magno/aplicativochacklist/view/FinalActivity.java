package com.magno.aplicativochacklist.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.model.ChackModel;
import com.magno.aplicativochacklist.model.EscolhasModel;
import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    private TextView resultadoView;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        resultadoView = findViewById(R.id.txtResultado);
        btnFinalizar = findViewById(R.id.btnEncerrar);

        ArrayList<ChackModel> listaChack = (ArrayList<ChackModel>) getIntent().getSerializableExtra("listaChack");
        ArrayList<EscolhasModel> listaEscolhas = (ArrayList<EscolhasModel>) getIntent().getSerializableExtra("listaEscolhas");

        StringBuilder resultado = new StringBuilder("Resumo das escolhas:\n\n");

        for (ChackModel item : listaChack) {
            String status = item.getSelecionado() == null ? "Sem resposta" : (item.getSelecionado() ? "Sim" : "Não");
            resultado.append("Categoria: ").append(item.getCategoria())
                    .append("\nItens: ").append(item.getNome())
                    .append("\nResposta: ").append(status).append("\n\n");
        }

        for (EscolhasModel item : listaEscolhas) {
            String status = item.getSelecionado2() == null ? "Sem resposta" : (item.getSelecionado2() ? "Sim" : "Não");
            resultado.append("Categoria: ").append(item.getCategoria2())
                    .append("\nItens: ").append(item.getNome2())
                    .append("\nResposta: ").append(status).append("\n\n");
        }

        resultado.append("✅ Obrigado por usar nosso checklist de viagem!\nBoa viagem! ✈️🌴");
        resultadoView.setText(resultado.toString());
    }

    public void encerrarAplicacao(View view) {
        finishAffinity();
    }
}
