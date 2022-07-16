package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencys4 extends AppCompatActivity {

    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencys4);

        l1 = findViewById (R.id.fever);
        l2 = findViewById (R.id.febrile);
        l3 = findViewById (R.id.seizures);
        l4 = findViewById (R.id.fainting);
        l5 = findViewById (R.id.soreThroat);
        l6 = findViewById (R.id.croup);
        l7 = findViewById (R.id.blackEyes);
        l8 = findViewById (R.id.brokenNose);
        l9 = findViewById (R.id.noseBleed);
        l10 = findViewById (R.id.motion);
        l11 = findViewById (R.id.highBlood);
        l12 = findViewById (R.id.panicAttack);


        l1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Fever.class));
            }
        });
        l2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Febrile.class));
            }
        });
        l3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Seizures.class));
            }
        });
        l4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Fainting.class));
            }
        });
        l5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, SoreThroat.class));
            }
        });
        l6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Croupss.class));
            }
        });
        l7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, BlackEyes.class));
            }
        });
        l8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, BrokenNose.class));
            }
        });
        l9.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Nosebleed.class));
            }
        });
        l10.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Motionss.class));
            }
        });
        l11.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, Highblood.class));
            }
        });
        l12.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys4.this, PanicAttack.class));
            }
        });
    }
}