package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Emergency5 extends AppCompatActivity {

    TextView p1,p2,p3,p4,p5,p6,p7,p8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_emergency5);

        p1 = findViewById (R.id.cuts);
        p2 = findViewById (R.id.puncture);
        p3 = findViewById (R.id.due);
        p4 = findViewById (R.id.toothLoss);
        p5 = findViewById (R.id.diabetic);
        p6 = findViewById (R.id.earache);
        p7 = findViewById (R.id.foodPoison);
        p8 = findViewById (R.id.allergic);



        p1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, Cuuts.class));
            }
        });

        p2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, Puntures.class));
            }
        });


        p3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, Duedue.class));
            }
        });


        p4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, ToothLoss.class));
            }
        });


        p5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, Diabetic.class));
            }
        });


        p6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, Earache.class));
            }
        });


        p7.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, FoodPoison.class));
            }
        });


        p8.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (Emergency5.this, Allegic.class));
            }
        });

    }
}