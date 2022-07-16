package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergency3 extends AppCompatActivity {
    TextView a1,a2,a3,a4,a5,a6,a7,a8,a9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergency3);

        a1 = findViewById (R.id.cpr);
        a2 = findViewById (R.id.aid);
        a3 = findViewById (R.id.aed);
        a4 = findViewById (R.id.posit);
        a5 = findViewById (R.id.attack);
        a6 = findViewById (R.id.choking);
        a7 = findViewById (R.id.maneuver);
        a8 = findViewById (R.id.objects);
        a9 = findViewById (R.id.shock);


        a1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Cpr.class));
            }
        });

        a2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Aidas.class));
            }
        });

        a3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Aed.class));
            }
        });

        a4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Posit.class));
            }
        });

        a5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Attack.class));
            }
        });

        a6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Choking.class));
            }
        });

        a7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Maneuver.class));            }
        });

        a8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Objectx.class));
            }
        });

        a9.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency3.this, Shock.class));
            }
        });




    }
}