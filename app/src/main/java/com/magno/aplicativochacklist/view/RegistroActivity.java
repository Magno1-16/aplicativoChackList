package com.magno.aplicativochacklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.bancoDBdao.ChackListDBController;
import com.magno.aplicativochacklist.model.LoginModel;

public class RegistroActivity extends AppCompatActivity {

    private EditText nomeEditText, emailEditText, senhaEditText;
    private Button registrarButton;
    private TextView tvJaTenhoConta;
    private ChackListDBController db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = new ChackListDBController(this);

        nomeEditText = findViewById(R.id.nomeC);
        emailEditText = findViewById(R.id.emailC);
        senhaEditText = findViewById(R.id.senhaC);
        registrarButton = findViewById(R.id.registrar);
        tvJaTenhoConta = findViewById(R.id.tvJaTenhoConta);

        registrarButton.setOnClickListener(v -> {
            String nome = nomeEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String senha = senhaEditText.getText().toString().trim();

            if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Digite um email válido", Toast.LENGTH_SHORT).show();
            } else {
                boolean ok = db.salvarLogin(new LoginModel(email, senha));
                if (ok) {
                    Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Falha ao cadastrar (email já existe?)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvJaTenhoConta.setOnClickListener(v -> {
            startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
            finish();
        });
    }
}
