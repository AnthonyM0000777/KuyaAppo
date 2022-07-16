package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencyss1 extends AppCompatActivity {

    TextView c1,c2,c3,c4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencyss1);

        c1 = findViewById (R.id.responder);
        c2 = findViewById (R.id.keep);
        c3 = findViewById (R.id.samaritan);
        c4 = findViewById (R.id.howSafe);


        c1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss1.this, Responders.class));
            }
        });
        c2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss1.this, Keeppss.class));
            }
        });
        c3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss1.this, Samaritan.class));
            }
        });
        c4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss1.this, Howsafe.class));
            }
        });


    }
}