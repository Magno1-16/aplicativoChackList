// LoginActivity.java
package com.magno.aplicativochacklist.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.aplicativochacklist.R;
import com.magno.aplicativochacklist.controller.LoginController;

public class LoginActivity extends AppCompatActivity {

    private EditText boxEmail, boxSenha;
    private Button btnLogin, btnLimpar;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializa Controller
        loginController = new LoginController(this);

        // Referência dos campos
        boxEmail = findViewById(R.id.email);
        boxSenha = findViewById(R.id.senha);
        btnLogin = findViewById(R.id.logar);
        btnLimpar = findViewById(R.id.limpar);

        // Evento botão Login
        btnLogin.setOnClickListener(v -> {
            String email = boxEmail.getText().toString().trim();
            String senha = boxSenha.getText().toString().trim();

            if(email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean valido = loginController.autenticar(email, senha);
            if(valido){
                Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Email ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        });

        // Evento botão Limpar
        btnLimpar.setOnClickListener(v -> {
            boxEmail.setText("");
            boxSenha.setText("");
        });
    }
}
