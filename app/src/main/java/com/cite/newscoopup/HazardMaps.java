package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HazardMaps extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private ImageButton next, previous;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_hazard_maps);

        viewFlipper = findViewById (R.id.idView_flipper);
        next = findViewById (R.id.idLeft);
        previous = findViewById (R.id.idRight);
        mAuth = FirebaseAuth.getInstance ();

        next.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext ();
            }
        });

        previous.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious ();
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
                startActivity (new Intent (HazardMaps.this, User_Dashboard.class));
                return true;

            //news headlines
            case R.id.idEdtUserHeadlines:
                startActivity (new Intent (HazardMaps.this, ApiUser.class));
                return true;

            case R.id.idEdtUserProfile1:
                startActivity (new Intent (HazardMaps.this, UserProfile.class));
                return true;


            case R.id.idEdtUserAbout:
                startActivity (new Intent (HazardMaps.this, UserAbout.class));
                return true;

            case R.id.idEdtUserLogout:
                Toast.makeText (HazardMaps.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut ();
                Intent i = new Intent (HazardMaps.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }
}