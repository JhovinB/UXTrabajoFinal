package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformeActivity extends AppCompatActivity {

    private Button btnRecomendaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);
        btnRecomendaciones = findViewById(R.id.btn_recomendaciones);
        btnRecomendaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRecomendacion();
            }
        });
    }
    private void callRecomendacion() {
        Intent recomendacion = new Intent(this, RecomendacionActivity.class);
        startActivity(recomendacion);
    }
}