package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IngresosActivity extends AppCompatActivity {

    private EditText montoInput;
    private EditText billeteraInput;
    private EditText categoriaInput;
    private EditText DetalleInput;
    private EditText fechaInput;
    private Button btnGuardarIngreso;
    private Button btnCancelarIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);
        montoInput = findViewById(R.id.monto_income);
        billeteraInput = findViewById(R.id.billetera_income);
        categoriaInput = findViewById(R.id.categoria_income);
        DetalleInput = findViewById(R.id.detalle_income);
        fechaInput = findViewById(R.id.fecha_income);
        btnGuardarIngreso = findViewById(R.id.btn_guardar_income);
        btnCancelarIngreso = findViewById(R.id.btn_cancelar_income);

        btnGuardarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callIngreso();
            }
        });

        btnCancelarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callCancelarIngreso();
            }
        });
    }
    private void callIngreso(){
        String monto = montoInput.getText().toString();
        String billetera = billeteraInput.getText().toString();
        String categoria = categoriaInput.getText().toString();
        String detalle = DetalleInput.getText().toString();
        String fecha = fechaInput.getText().toString();

        if(monto.isEmpty() || billetera.isEmpty() || categoria.isEmpty() || detalle.isEmpty() || fecha.isEmpty()){
            Toast.makeText(this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this,OperacionesActivity.class);
        intent.putExtra("monto",monto);
        intent.putExtra("billetera",billetera);
        intent.putExtra("categoria",categoria);
        intent.putExtra("detalle",detalle);
        intent.putExtra("fecha",fecha);
        startActivity(intent);
    }
    private void callCancelarIngreso(){
        Intent cancelar = new Intent(this,OperacionesActivity.class);
        startActivity(cancelar);
    }
}