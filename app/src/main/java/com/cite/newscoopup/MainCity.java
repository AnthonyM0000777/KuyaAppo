package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainCity extends AppCompatActivity {
    EditText citySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main_city);

        citySearch = findViewById (R.id.idSearch);

        citySearch.setOnEditorActionListener (new TextView.OnEditorActionListener () {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String cityName = citySearch.getText ().toString ();
                Intent i = new Intent (getApplicationContext (), MainWeather.class);
                i.putExtra ("CityName", cityName);
                startActivity (i);
                return false;
            }
        });
    }
}