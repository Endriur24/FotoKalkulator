package com.example.andrzej.fotokalkulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //deklaracja przycisków
    private Button button_odleglosc_hiperfokalna;
    private Button button_glebia_ostrosci;
    private Button button_przelicznik_ev;
    private Button button_przelicznik_ogniskowych;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //podpiecie przyciskow
        //wybór buttona, działanie po kliknięciu


        //odleglość hiperfokalna
        button_odleglosc_hiperfokalna = (Button) findViewById(R.id.odl_hiper);
        button_odleglosc_hiperfokalna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOdleglosc_hiperfokalna();
            }
        });

        //głębia ostrości
        button_glebia_ostrosci = (Button) findViewById(R.id.dof);
        button_glebia_ostrosci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGlebia_ostrosci();
            }
        });

        //przelicznik ev
        button_przelicznik_ev = (Button) findViewById(R.id.ev);
        button_przelicznik_ev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrzelicznik_ev();
            }
        });

        //przelicznik ogniskowych
        button_przelicznik_ogniskowych = (Button) findViewById(R.id.ogniskowych);
        button_przelicznik_ogniskowych.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrzelicznik_ogniskowcyh();
            }
        });




    }


    //funkcje, działania po kliknięciu buttonów

    //odległość hiperfokalna
    public void openOdleglosc_hiperfokalna() {
            Intent intent = new Intent(this, Odleglosc_hiperfokalna.class);
            startActivity(intent);
    }
    //głęboa ostrości
    public void openGlebia_ostrosci() {
        Intent intent = new Intent(this, Glebia_ostrosci.class);
        startActivity(intent);
    }
    //przelicznik ev
    public void openPrzelicznik_ev() {
        Intent intent = new Intent(this, Przelicznik_ev.class);
        startActivity(intent);
    }
    //przelicznik ogniskowych
    public void openPrzelicznik_ogniskowcyh() {
        Intent intent = new Intent(this, Przelicznik_ogniskowych.class);
        startActivity(intent);
    }

}
