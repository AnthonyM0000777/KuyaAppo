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

public class UserTips extends AppCompatActivity {

    ImageView earthquake, hurricane, landslides, flood, tsunami, first;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tips);

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
                Intent int1 = new Intent(UserTips.this, UserEarthquake.class);
                startActivity(int1);
            }
        });

        hurricane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserTips.this, UserHuricane.class);
                startActivity(intent);
            }
        });

        landslides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserTips.this, UserLandslide.class);
                startActivity(intent);
            }
        });


        flood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserTips.this, UserFloods.class);
                startActivity(intent);
            }
        });

        tsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserTips.this, UserTsunami.class);
                startActivity(intent);
            }
        });

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(UserTips.this, MedicalNeeds.class);
                startActivity(intent);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId ();
        switch (id) {
            case R.id.idEdtUserDashboard:
                startActivity (new Intent (UserTips.this, User_Dashboard.class));
                return true;

            //news headlines
            case R.id.idEdtUserHeadlines:
                startActivity (new Intent (UserTips.this, ApiUser.class));
                return true;

            case R.id.idEdtUserProfile1:
                startActivity (new Intent (UserTips.this, UserProfile.class));
                return true;


            case R.id.idEdtUserAbout:
                startActivity (new Intent (UserTips.this, UserAbout.class));
                return true;


            case R.id.idEdtUserLogout:
                Toast.makeText (UserTips.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut();
                Intent i = new Intent (UserTips.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:


                return super.onOptionsItemSelected (item);
        }



    }

}
