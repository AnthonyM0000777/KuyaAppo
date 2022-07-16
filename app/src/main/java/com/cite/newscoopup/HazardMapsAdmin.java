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


public class HazardMapsAdmin extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private ImageButton next, previous;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_hazard_maps_admin);


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
        getMenuInflater ().inflate (R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId ();
        switch (id) {

            case R.id.idEdtDashboard:
                startActivity (new Intent (HazardMapsAdmin.this, AdminDashboad.class));

                return true;

            //news headlines
            case R.id.idEdtHeadlines:
                startActivity (new Intent (HazardMapsAdmin.this, ApiMainActivity.class));
                return true;

            case R.id.idEdtProfile1:
                startActivity (new Intent (HazardMapsAdmin.this, EditProfileActivity.class));
                return true;


            case R.id.idEdtAbout:
                startActivity (new Intent (HazardMapsAdmin.this, AboutUsActivity.class));
                return true;

            case R.id.idEdtLogout:
                Toast.makeText (HazardMapsAdmin.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut ();
                Intent i = new Intent (HazardMapsAdmin.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }
}