package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencys5 extends AppCompatActivity {

    TextView y1,y2,y3,y4,y5,y6,y7,y8,y9,y10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencys5);

        y1 = findViewById (R.id.childbirth);
        y2 = findViewById (R.id.miscarriage);
        y3 = findViewById (R.id.tetanus);
        y4 = findViewById (R.id.rabies);
        y5 = findViewById (R.id.severed);
        y6 = findViewById (R.id.sprains);
        y7 = findViewById (R.id.brokenBones);
        y8 = findViewById (R.id.fractures);
        y9 = findViewById (R.id.dislocation);
        y10 = findViewById (R.id.smoke);

        y1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Childbirth.class));
            }
        });
        y2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Miscarriage.class));
            }
        });
        y3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Tetanus.class));
            }
        });
        y4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Rabies.class));
            }
        });
        y5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Severed.class));
            }
        });
        y6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Sprains.class));
            }
        });
        y7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, BrokenBones.class));
            }
        });
        y8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Fractures.class));
            }
        });
        y9.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Dislocation.class));
            }
        });
        y10.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys5.this, Smoke.class));
            }
        });
    }
}