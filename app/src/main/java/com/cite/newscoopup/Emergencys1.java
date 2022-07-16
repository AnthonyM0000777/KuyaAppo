package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergencys1 extends AppCompatActivity {

    TextView o1,o2,o3,o4,o5,o6,o7,o8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergencys1);

        o1 = findViewById (R.id.animal);
        o2 = findViewById (R.id.stings);
        o3 = findViewById (R.id.poisonIvy);
        o4 = findViewById (R.id.frostbite);
        o5 = findViewById (R.id.blindness);
        o6 = findViewById (R.id.dehydration);
        o7 = findViewById (R.id.heart);
        o8 = findViewById (R.id.jellyfish);


        o1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, Animal.class));
            }
        });

        o2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, Stings.class));
            }
        });

        o3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, PoisonIvy.class));
            }
        });


        o4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, Frostbite.class));
            }
        });


        o5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, Blindness.class));
            }
        });


        o6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, Dehydration.class));
            }
        });


        o7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, Hearts.class));
            }
        });


        o8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergencys1.this, Jellyfish.class));
            }
        });
    }
}