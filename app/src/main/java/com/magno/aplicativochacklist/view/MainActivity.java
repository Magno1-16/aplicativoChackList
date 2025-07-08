package com.magno.aplicativochacklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplicativochacklist.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ChackController();

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
        List<ChackModel> lista = controller.obterSelecoes(
                radioSim1, radioNao1,
                radioSim2, radioNao2,
                radioSim3, radioNao3,
                radioSim4, radioNao4,
                radioSim5, radioNao5
        );
        Intent intent = new Intent(MainActivity.this, EscolhasActivity.class);
        intent.putExtra("listaChack", new ArrayList<>(lista));
        startActivity(intent);
    }
}
