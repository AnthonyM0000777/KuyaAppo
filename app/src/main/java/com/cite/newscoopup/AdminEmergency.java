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

public class AdminEmergency extends AppCompatActivity {

    ImageView as1, as2, as3, as4, as5,
            ass1, ass2, ass3, ass4, ass5,
            asss1, asss2, asss3, asss4, asss5;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_admin_emergency);

        as1 = findViewById (R.id.as1);
        as2 = findViewById (R.id.as2);
        as3 = findViewById (R.id.as3);
        as4 = findViewById (R.id.as4);
        as5 = findViewById (R.id.as5);

        ass1 = findViewById (R.id.as6);
        ass2 = findViewById (R.id.as7);
        ass3 = findViewById (R.id.as8);
        ass4 = findViewById (R.id.as9);
        ass5 = findViewById (R.id.as10);

        asss1 = findViewById (R.id.as11);
        asss2 = findViewById (R.id.as12);
        asss3 = findViewById (R.id.as13);
        asss4 = findViewById (R.id.as14);
        asss5 = findViewById (R.id.as15);

        mAuth = FirebaseAuth.getInstance ();


        as1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergency1.class));
            }
        });

        as2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergency2.class));
            }
        });

        as3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergency3.class));
            }
        });

        as4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergency4.class));
            }
        });

        as5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergency5.class));
            }
        });

        ass1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencys1.class));
            }
        });

        ass2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencys2.class));
            }
        });

        ass3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencys3.class));
            }
        });

        ass4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencys4.class));
            }
        });

        ass5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencys5.class));
            }
        });

        asss1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencyss1.class));
            }
        });

        asss2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencyss2.class));
            }
        });

        asss3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencyss3.class));
            }
        });

        asss4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencyss4.class));
            }
        });

        asss5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminEmergency.this, Emergencyss5.class));
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
                startActivity (new Intent (AdminEmergency.this, AdminDashboad.class));
                return true;


            //news headlines
            case R.id.idEdtHeadlines:
                startActivity (new Intent (AdminEmergency.this, ApiMainActivity.class));
                return true;

            case R.id.idEdtProfile1:
                startActivity (new Intent (AdminEmergency.this, EditProfileActivity.class));
                return true;


            case R.id.idEdtAbout:
                startActivity (new Intent (AdminEmergency.this, AboutUsActivity.class));
                return true;

            case R.id.idEdtLogout:
                Toast.makeText (AdminEmergency.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut ();
                Intent i = new Intent (AdminEmergency.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }

}