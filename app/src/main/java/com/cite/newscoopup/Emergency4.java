package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergency4 extends AppCompatActivity {

    TextView q1,q2,q3,q4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergency4);

        q1 = findViewById (R.id.prevention);
        q2 = findViewById (R.id.homes);
        q3 = findViewById (R.id.elderly);
        q4 = findViewById (R.id.clean);

        q1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency4.this, Preventsss.class));
            }
        });

        q2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency4.this, Homes.class));
            }
        });

        q3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency4.this, Elderly.class));
            }
        });

        q4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency4.this, Clean.class));
            }
        });
    }
}