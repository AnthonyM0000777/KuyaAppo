package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencyss4 extends AppCompatActivity {

    TextView g1,g2,g3,g4,g5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencyss4);

        g1 = findViewById (R.id.depression);
        g2 = findViewById (R.id.suicide);
        g3 = findViewById (R.id.preventSuicide);
        g4 = findViewById (R.id.talkKids);
        g5 = findViewById (R.id.aboutDrugs);

        g1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss4.this, Depression.class));
            }
        });

        g2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss4.this, Suicide.class));
            }
        });
        g3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss4.this, PreventSuicide.class));
            }
        });
        g4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss4.this, TalkKids.class));
            }
        });
        g5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencyss4.this, AboutDrugs.class));
            }
        });
    }
}