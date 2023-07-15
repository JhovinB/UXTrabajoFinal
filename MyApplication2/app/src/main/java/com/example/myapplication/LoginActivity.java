package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usuarioInput;

    private EditText passwordInput;
    private Button btnLogin;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioInput = findViewById(R.id.username_id);
        passwordInput = findViewById(R.id.password_id);
        btnLogin = findViewById(R.id.btn_login);
        btnRegistro=findViewById(R.id.btn_registrar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLogin();
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegistro();
            }
        });
    }
    private void callLogin(){
        String usuario = usuarioInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(usuario.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this,OperacionesActivity.class);
        intent.putExtra("username",usuario);
        intent.putExtra("password",password);
        startActivity(intent);

        if(usuario.equals("admin") && password.equals("admin") ){
            Intent admin = new Intent(this,AdminActivity.class);
            startActivity(admin);
        }

    }
    private void callRegistro(){
        Intent registro = new Intent(this,RegistroActivity.class);
        startActivity(registro);
    }
}