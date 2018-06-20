package com.example.andrzej.fotokalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Odleglosc_hiperfokalna extends AppCompatActivity {

    Double ogniskowa = 0.0;
    Double przyslona = 0.0;
    Double wynik = 0.0;


    private Button oblicz_hiperfokalna;
    private EditText ogniskowaInput;
    private EditText przyslonaInput;
    private TextView wynikOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odleglosc_hiperfokalna);

        ogniskowaInput = (EditText) findViewById(R.id.ogniskowaIn);
        przyslonaInput = (EditText) findViewById(R.id.przyslonaIn);
        wynikOutput = (TextView) findViewById(R.id.wynikOutput);

        oblicz_hiperfokalna = (Button) findViewById(R.id.oblicz_hiperfokalna);
        oblicz_hiperfokalna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ogniskowa = Double.valueOf(ogniskowaInput.getText().toString());
                przyslona = Double.valueOf(przyslonaInput.getText().toString());

                if(ogniskowa > 0 && przyslona > 0) {
                    wynik = ((ogniskowa / 1000) * (ogniskowa / 1000)) / (przyslona * (ogniskowa / 3000000));
                    Long wynik_l = (Math.round(wynik * 100));
                    wynik = wynik_l.doubleValue() / 100;
                    wynikOutput.setText(wynik.toString());

                    showToast(String.valueOf(wynik));
                }
                else{
                    showToast("popraw dane");
                }


            }
        });



    }

    public void showToast(String text){
        Toast.makeText(Odleglosc_hiperfokalna.this, text, Toast.LENGTH_SHORT).show();


    }

}
