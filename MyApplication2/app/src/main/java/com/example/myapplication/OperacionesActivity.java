package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OperacionesActivity extends AppCompatActivity {

    private Button btnAgregarOperaciones;
    private Button btnOperacion;
    private Button btnAhorro;
    private Button btnInformes;

    private TextView text_saldo;

    private ImageView btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        text_saldo=findViewById(R.id.text_saldo);
        btnOperacion = findViewById(R.id.btn_operacion);
        btnAgregarOperaciones = findViewById(R.id.btn_operaciones);
        btnAhorro = findViewById(R.id.btn_ahorro);
        btnCerrarSesion= findViewById(R.id.btn_cerrar);
        btnInformes = findViewById(R.id.btn_informes);

        btnAgregarOperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callOperaciones();
            }
        });
        btnAhorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAhorro();
            }
        });
        btnInformes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callInforme();
            }
        });
        btnOperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callOperacion();
            }
        });
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLogin();
            }
        });

        if(getIntent().getExtras()!=null){
            String monto = getIntent().getExtras().getString("monto");
            text_saldo.setText(monto);
        }

    }
    private void callLogin(){
        Intent sesion = new Intent(this,LoginActivity.class);
        startActivity(sesion);
    }
    private void callOperaciones(){
        Intent intent = new Intent(this,IngresosActivity.class);
        startActivity(intent);
    }
    private void callOperacion(){
        Intent intent = new Intent(this,OperacionesActivity.class);
        startActivity(intent);
    }
    private void callAhorro(){
        Intent intent = new Intent(this,AhorroActivity.class);
        startActivity(intent);
    }
    private void callInforme(){
        Intent intent = new Intent(this,InformeActivity.class);
        startActivity(intent);
    }
}