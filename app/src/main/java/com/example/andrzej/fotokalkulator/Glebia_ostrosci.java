package com.example.andrzej.fotokalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Glebia_ostrosci extends AppCompatActivity {

    Double coc;
    Double przyslona;
    Double ogniskowa;
    Double odleglosc;
    Double hiperfok;
    Double wynik_najblizszy_ostry;
    Double wynik_najdalszy_ostry;
    Double wynik_glebia_ostrosci;


    private Button przelicz;
    private EditText cocInput;
    private EditText przyslonaInput;
    private EditText ogniskowaInput;
    private EditText odlegloscInput;
    private TextView najblizszy_ostryOutput;
    private TextView najdalszy_ostryOutput;
    private TextView glebia_ostrosciOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glebia_ostrosci);


        cocInput = (EditText) findViewById(R.id.cocIn);
        ogniskowaInput = (EditText) findViewById(R.id.ogniskowaIn);
        przyslonaInput = (EditText) findViewById(R.id.przyslonaIn);
        odlegloscInput = (EditText) findViewById(R.id.odlegloscIn);
        najblizszy_ostryOutput = (TextView) findViewById(R.id.wynik_najblizszy_ostry);
        najdalszy_ostryOutput = (TextView) findViewById(R.id.wynik_najdalszy_ostry);
        glebia_ostrosciOutput = (TextView) findViewById(R.id.wynik_glebia_ostrosci);

        przelicz = (Button) findViewById(R.id.button_przelicz);
        przelicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coc = Double.valueOf(cocInput.getText().toString());
                przyslona = Double.valueOf(przyslonaInput.getText().toString());
                ogniskowa = Double.valueOf(ogniskowaInput.getText().toString());
                odleglosc = Double.valueOf(odlegloscInput.getText().toString());

                if(coc>0 && przyslona>0 && ogniskowa>0 && odleglosc>0){

                    hiperfok = ((ogniskowa) * (ogniskowa)) / (przyslona * coc);
                    wynik_najblizszy_ostry = (hiperfok * odleglosc) / (hiperfok + ((odleglosc * 1000) - (ogniskowa)));
                    wynik_najdalszy_ostry = (hiperfok * odleglosc) / (hiperfok - ((odleglosc * 1000) - (ogniskowa)));
                    wynik_glebia_ostrosci = (wynik_najdalszy_ostry - wynik_najblizszy_ostry) * 100;


                    Long wynik_l = (Math.round(wynik_najblizszy_ostry * 100));
                    wynik_najblizszy_ostry = wynik_l.doubleValue() / 100;
                    najblizszy_ostryOutput.setText(wynik_najblizszy_ostry.toString());

                    Long wynik_2 = (Math.round(wynik_najdalszy_ostry * 100));
                    wynik_najdalszy_ostry = wynik_2.doubleValue() / 100;
                    najdalszy_ostryOutput.setText(wynik_najdalszy_ostry.toString());

                    Long wynik_3 = (Math.round(wynik_glebia_ostrosci * 100));
                    wynik_glebia_ostrosci = wynik_3.doubleValue() / 100;
                    glebia_ostrosciOutput.setText(wynik_glebia_ostrosci.toString());


                    showToast("gotowe!");
                }
                else{
                    showToast("popraw dane!");

                }

            }
        });

    }

    public void showToast(String text){
        Toast.makeText(Glebia_ostrosci.this, text, Toast.LENGTH_SHORT).show();


    }
}
