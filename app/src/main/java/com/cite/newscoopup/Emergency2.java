package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergency2 extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4, txt5, txt6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergency2);

        txt1 = findViewById (R.id.panic);
        txt2 = findViewById (R.id.proper);
        txt3 = findViewById (R.id.medical);
        txt4 = findViewById (R.id.number);
        txt5 = findViewById (R.id.universal);
        txt6 = findViewById (R.id.training);


        txt1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                    startActivity (new Intent (Emergency2.this, Panic.class));
            }
        });

        txt2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency2.this, Proper.class));
            }
        });

        txt3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency2.this, Medicals.class));
            }
        });

        txt4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency2.this, Numbers.class));
            }
        });

        txt5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency2.this, Universal.class));
            }
        });

        txt6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency2.this, Training.class));
            }
        });
    }
}