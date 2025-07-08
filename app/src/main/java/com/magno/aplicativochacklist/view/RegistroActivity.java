package com.magno.aplicativochacklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.controller.LoginController;

public class RegistroActivity extends AppCompatActivity {

    private EditText nomeEditText, emailEditText, senhaEditText;
    private Button registrarButton;
    private LoginController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        controller = new LoginController(this);

        nomeEditText = findViewById(R.id.nomeC);
        emailEditText = findViewById(R.id.emailC);
        senhaEditText = findViewById(R.id.senhaC);
        registrarButton = findViewById(R.id.registrar);

        registrarButton.setOnClickListener(v -> {
            String nome = nomeEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String senha = senhaEditText.getText().toString().trim();

            if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (!emailValido((email))) {
                Toast.makeText(this, "Digite um email válido", Toast.LENGTH_SHORT).show();
            } else {
                controller.salvarLogin(email, senha);
                Toast.makeText(this, "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


public boolean emailValido(String email) {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
}
}
