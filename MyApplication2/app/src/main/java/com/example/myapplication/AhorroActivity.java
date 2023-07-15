package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AhorroActivity extends AppCompatActivity {

    private Button btn_atras;
    private Button btn_calcular;
    private Button btn_inicio;
    private ImageButton btn_Fecha_Inicio;
    private ImageButton btn_Fecha_Fin;
    //Cuadro de respuesta
    private TextView MontoCal;

    private EditText MontoAhorro;
    private EditText FechaInicio;
    private EditText FechaFin;
    private EditText MontoDisponible;
    private TextView Tips;

    private int diaI,mesI,anoI,diaF,mesF,anoF;
    private float res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorro);

        Tips=findViewById(R.id.tipsPopUp);
//Botones
        btn_atras = findViewById(R.id.button_atras);
        btn_calcular = findViewById(R.id.button_calcular);
        btn_inicio = findViewById(R.id.button_inicio);
        btn_Fecha_Fin=findViewById(R.id.Fecha_Fin);
        btn_Fecha_Inicio=findViewById(R.id.Fecha_Inicio);


//Datos
        MontoAhorro=findViewById(R.id.MontoProyeccion);
        FechaInicio=findViewById(R.id.FechaInicio);
        FechaInicio.setEnabled(false);
        FechaFin=findViewById(R.id.FechaFin);
        FechaFin.setEnabled(false);
        MontoDisponible=findViewById(R.id.MontoDisponible);

//Respuesta
        MontoCal= findViewById(R.id.Respuesta);

//Habilitacion y deshabilitacion para el
        FechaInicio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length()<=0){
                    MontoDisponible.setEnabled(false);
                }else{
                    MontoDisponible.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().length()>0){
                    MontoDisponible.setEnabled(false);
                }else{
                    MontoDisponible.setEnabled(true);
                }

            }
        });

        btn_Fecha_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c=Calendar.getInstance();
                diaI=c.get(Calendar.DAY_OF_MONTH);
                mesI=c.get(Calendar.MONTH);
                anoI=c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(btn_Fecha_Fin.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mesI=monthOfYear+1;
                        anoI=year;
                        FechaInicio.setText((monthOfYear+1)+"/"+year);


                    }
                },diaI,mesI,anoI);
                datePickerDialog.show();


            }
        });
        btn_Fecha_Fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c= Calendar.getInstance();
                diaF=c.get(Calendar.DAY_OF_MONTH);
                mesF=c.get(Calendar.MONTH);
                anoF=c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(btn_Fecha_Inicio.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mesF=monthOfYear+1;
                        anoF=year;
                        FechaFin.setText((monthOfYear+1)+"/"+year);


                    }
                },diaF,mesF,anoF);
                datePickerDialog.show();


            }
        });

        Tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AhorroActivity.this, PopUpTips.class));
            }
        });

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MontoAhorro.getText().toString().length()!=0 && FechaInicio.getText().toString().length()!=0){
                    if (anoF==anoI && (mesI>6 || mesF-mesI<6)) {
                        MontoCal.setText("El rango minimo en fechas con el mismo año es de 6 meses");
                    }
                    else if(anoF==anoI) {
                        res = Float.parseFloat(MontoAhorro.getText().toString())/(mesF - mesI);
                        MontoCal.setText("Requieres de:  s/."+res+" para ahorrar "+MontoAhorro.getText().toString()+" en "+(mesF - mesI)+" meses");
                    } else if(anoF>anoI) {
                        res=Float.parseFloat(MontoAhorro.getText().toString())/(((12-mesI)+mesF)+((anoF-anoI-1)*12));
                        MontoCal.setText("Requieres de:  s/."+res+" para ahorrar "+MontoAhorro.getText().toString()+" en "+(((12-mesI)+mesF)+((anoF-anoI-1)*12))+" meses");
                    }  else{
                        MontoCal.setText("Error el año final debe ser mayor al año inicial");
                    }


                }
                else if(MontoAhorro.getText().toString().length()!=0 && MontoDisponible.getText().toString().length()!=0){
                    MontoCal.setText("Requieres de: "+(int)Math.ceil(Float.parseFloat(MontoAhorro.getText().toString())/(Float.parseFloat(MontoDisponible.getText().toString())))+ " meses para llegar al monto de "+MontoAhorro.getText().toString());
                }else{
                    MontoCal.setText("Error en el ingreso de datos");
                }

            }
        });


        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MontoCal.setText("");
                MontoAhorro.setText("");
                MontoDisponible.setText("");

                FechaFin.setText("");
                FechaInicio.setText("");
            }
        });
        btn_atras = findViewById(R.id.button_atras);
        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAtras();
            }
        });
    }
    private void callAtras(){
        Intent atras = new Intent(this,OperacionesActivity.class);
        startActivity(atras);
    }
}