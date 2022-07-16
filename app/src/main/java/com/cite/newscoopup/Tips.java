package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Tips extends AppCompatActivity {
    ImageView earthquake, hurricane, landslides, flood, tsunami, first;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_tips);

            mAuth = FirebaseAuth.getInstance ();

            earthquake = findViewById(R.id.earthquake);
            hurricane = findViewById(R.id.hurricane);
            landslides = findViewById(R.id.landslide);
            flood = findViewById(R.id.floods);
            tsunami= findViewById(R.id.tsunami);
            first = findViewById(R.id.firstAidKit);

            earthquake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent int1 = new Intent(Tips.this, UserEarthquake.class);
                    startActivity(int1);
                }
            });

            hurricane.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Tips.this, UserHuricane.class);
                    startActivity(intent);
                }
            });

            landslides.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Tips.this, UserLandslide.class);
                    startActivity(intent);
                }
            });


            flood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Tips.this, UserFloods.class);
                    startActivity(intent);
                }
            });

            tsunami.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Tips.this, UserTsunami.class);
                    startActivity(intent);
                }
            });

            first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Tips.this, MedicalNeeds.class);
                    startActivity(intent);
                }

            });

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId ();
        switch (id) {
            case R.id.idEdtDashboard:
                startActivity (new Intent (Tips.this, AdminDashboad.class));
                return true;


            //news headlines
            case R.id.idEdtHeadlines:
                startActivity (new Intent (Tips.this, ApiMainActivity.class));
                return true;


            case R.id.idEdtProfile1:
                startActivity (new Intent (Tips.this, EditProfileActivity.class));
                return true;


            case R.id.idEdtAbout:
                startActivity (new Intent (Tips.this, AboutUsActivity.class));
                return true;


            case R.id.idEdtLogout:
                Toast.makeText (Tips.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut();
                Intent i = new Intent (Tips.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }

    }
    }
