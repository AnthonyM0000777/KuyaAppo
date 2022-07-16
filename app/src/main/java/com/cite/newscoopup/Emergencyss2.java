package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencyss2 extends AppCompatActivity {

    TextView k1,k2,k3,k4,k5,k6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencyss2);

        k1 = findViewById (R.id.workplace);
        k2 = findViewById (R.id.preventing);
        k3 = findViewById (R.id.stress);
        k4 = findViewById (R.id.station);
        k5 = findViewById (R.id.emergencyKit);
        k6 = findViewById (R.id.calling);

        k1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss2.this, Workplace.class));
            }
        });
        k2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss2.this, Preventing.class));
            }
        });
        k3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss2.this, Stressss.class));
            }
        });
        k4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss2.this, Stations.class));
            }
        });
        k5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss2.this, EmergencyKit.class));
            }
        });
        k6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss2.this, Callings.class));
            }
        });
    }
}