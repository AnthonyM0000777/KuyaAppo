package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencys3 extends AppCompatActivity {

    TextView u1,u2,u3,u4,u5,u6,u7,u8,u9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencys3);

        u1 = findViewById (R.id.bleeding);
        u2 = findViewById (R.id.internals);
        u3 = findViewById (R.id.penetrating);
        u4 = findViewById (R.id.spinal);
        u5 = findViewById (R.id.stroke);
        u6 = findViewById (R.id.poisoning);
        u7 = findViewById (R.id.drug);
        u8 = findViewById (R.id.near);
        u9 = findViewById (R.id.carbon);

        u1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Bleeding.class));
            }
        });

        u2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Internals.class));
            }
        });
        u3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Penetrating.class));
            }
        });
        u4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Spinal.class));
            }
        });
        u5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Strokes.class));
            }
        });
        u6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Poisoning.class));
            }
        });
        u7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Drugs.class));
            }
        });
        u8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Nearss.class));
            }
        });
        u9.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys3.this, Carbon.class));
            }
        });
    }
}