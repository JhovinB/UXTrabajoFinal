package com.example.myapplication;

import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

public class PopUpTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_tips);

        DisplayMetrics MedidasVentana=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(MedidasVentana);
        int ancho=MedidasVentana.widthPixels;
        int alto=MedidasVentana.heightPixels;
        getWindow().setLayout((int)(ancho * 0.85),(int)(alto * 0.5));

    }
}
