package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencyss5 extends AppCompatActivity {

    TextView m1,m2,m3,m4,m5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencyss5);

        m1 = findViewById (R.id.overview);
        m2 = findViewById (R.id.familyPlan);
        m3 = findViewById (R.id.stayOrGo);
        m4 = findViewById (R.id.shelter);
        m5 = findViewById (R.id.security);


        m1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss5.this, Overviews.class));
            }
        });
        m2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss5.this, FamilyPlan.class));
            }
        });
        m3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss5.this, StayorGo.class));
            }
        });
        m4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss5.this, Shelter.class));
            }
        });
        m5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss5.this, Securitys.class));
            }
        });
    }
}