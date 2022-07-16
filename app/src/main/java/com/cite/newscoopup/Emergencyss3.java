package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencyss3 extends AppCompatActivity {

    TextView h1,h2,h3,h4,h5,h6,h7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencyss3);

        h1 = findViewById (R.id.pack);
        h2 = findViewById (R.id.whatToAsk);
        h3 = findViewById (R.id.whenYouGet);
        h4 = findViewById (R.id.foreign);
        h5 = findViewById (R.id.stayingHotel);
        h6 = findViewById (R.id.tent);
        h7 = findViewById (R.id.concerning);

        h1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss3.this, Packss.class));
            }
        });
        h2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss3.this, WhatToAsk.class));
            }
        });
        h3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss3.this, WhenYouGet.class));
            }
        });
        h4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss3.this, Foreign.class));
            }
        });
        h5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss3.this, StayingHotel.class));
            }
        });
        h6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss3.this, Tentss.class));
            }
        });
        h7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss3.this, Concerning.class));
            }
        });
    }
}