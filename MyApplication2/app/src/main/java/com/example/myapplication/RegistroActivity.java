package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private Button btnRegistrarse;
    private ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btnRegistrarse=findViewById(R.id.btn_registrarse);
        btnBack=findViewById(R.id.btn_back);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegistrarse();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegistrarse();
            }
        });
    }
    private void callRegistrarse(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}