package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencys2 extends AppCompatActivity {
    TextView i1,i2,i3,i4,i5,i6,i7,i8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencys2);

        i1 = findViewById (R.id.burns);
        i2 = findViewById (R.id.sunburn);
        i3 = findViewById (R.id.electrical);
        i4 = findViewById (R.id.headTrauma);
        i5 = findViewById (R.id.headache);
        i6 = findViewById (R.id.abdominal);
        i7 = findViewById (R.id.nausea);
        i8 = findViewById (R.id.asthma);


        i1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, Burns.class));
            }
        });

        i2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, Sunburn.class));
            }
        });

        i3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, Electrical.class));
            }
        });

        i4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, HeadTrauma.class));
            }
        });

        i5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, Headache.class));
            }
        });
        i6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, Abdominal.class));
            }
        });
        i7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, Nausea.class));
            }
        });
        i8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys2.this, Asthmas.class));
            }
        });
    }
}