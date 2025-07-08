package com.magno.aplicativochacklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.controller.LoginController;

public class LoginActivity extends AppCompatActivity {

    private EditText boxEmail, boxSenha;
    private Button btnLogin, btnLimpar;
    private LoginController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_login);

        controller = new LoginController(this);

        boxEmail = findViewById(R.id.email);
        boxSenha = findViewById(R.id.senha);
        btnLogin = findViewById(R.id.logar);
        btnLimpar = findViewById(R.id.limpar);

        btnLogin.setOnClickListener(v -> {
            String email = boxEmail.getText().toString().trim();
            String senha = boxSenha.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                String emailSalvo = controller.getEmailSalvo();
                String senhaSalva = controller.getSenhaSalva();

                if (!email.equals(emailSalvo) || !senha.equals(senhaSalva)) {
                    Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainActivity.class));
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnLimpar.setOnClickListener(v -> controller.limparButton(boxEmail, boxSenha));
    }
}
