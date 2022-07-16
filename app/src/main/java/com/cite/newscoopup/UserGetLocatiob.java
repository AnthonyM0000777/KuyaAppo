package com.cite.newscoopup;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class UserGetLocatiob extends AppCompatActivity {

   private TextView viewLocationLat, textViewLong, textViewAdds, textViewLocs, textViewCitys, nameEdt,userNameEdt;
    private  Button getLocation, sendLocation;
    private  FusedLocationProviderClient fusedLocationProviderClient;
    private final static int REQUEST_CODE=100;
    private  DatabaseReference databaseReference,  reference;
    private FirebaseAuth mAuth;
    private String name, userID, number;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_user_get_locatiob);

        user = FirebaseAuth.getInstance ().getCurrentUser ();
        reference = FirebaseDatabase.getInstance ().getReference ("Users");
        userID = user.getUid ();

        mAuth = FirebaseAuth.getInstance ();
        viewLocationLat = findViewById (R.id.textViewLocationLat);
        textViewLong = findViewById (R.id.textViewLong);
        textViewAdds = findViewById (R.id.textViewAdd);
        textViewLocs = findViewById (R.id.textViewLoc);
        textViewCitys = findViewById (R.id.textViewCity);
        getLocation = findViewById (R.id.getLocation);
        sendLocation = findViewById (R.id.SendActivityButton);
        nameEdt = findViewById (R.id.idEdtName);
        userNameEdt = findViewById (R.id.idEdtUserName);

        databaseReference = FirebaseDatabase.getInstance ().getReference ("Location List");

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient (this);


        reference.child (userID).addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue (User.class);

                if(userProfile != null) {

                    name = userProfile.fullName;
                    number = userProfile.number;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText (UserGetLocatiob.this, "Something wrong", Toast.LENGTH_SHORT).show ();
            }
        });



        getLocation.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                showLocation ();
            }

        });
    }


    private void showLocation() {
        if(ContextCompat.checkSelfPermission (this, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation ().addOnSuccessListener (new OnSuccessListener<Location> () {
                @Override
                public void onSuccess(Location location) {
                    String address = textViewAdds.getText().toString();
                    String city = textViewLocs.getText().toString();
                    String country = textViewCitys.getText().toString();

                    LocationHelper helper = new LocationHelper (location.getLongitude (), location.getLatitude (), name, address,city, country, number);

                    FirebaseDatabase.getInstance ().getReference ("Location List").child (FirebaseAuth.getInstance ().getCurrentUser ().getUid ()).setValue (helper).addOnCompleteListener (new OnCompleteListener<Void> () {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful ()){
                                Toast.makeText (UserGetLocatiob.this, "Location save.", Toast.LENGTH_SHORT).show ();

                            }else
                                Toast.makeText (UserGetLocatiob.this, "Location not saved.", Toast.LENGTH_SHORT).show ();
                            }
                    });
                    if(location != null){
                      Geocoder geocoder = new Geocoder (UserGetLocatiob.this, Locale.getDefault ());
                      List<Address> addresses = null;
                      try {
                          addresses = geocoder.getFromLocation (location.getLatitude (), location.getLongitude (), 1);
                          viewLocationLat.setText ( ""+addresses.get (0).getLatitude ());
                          textViewLong.setText (""+addresses.get (0).getLongitude ());
                          textViewAdds.setText (addresses.get (0).getAddressLine (0));
                          textViewLocs.setText (addresses.get (0).getLocality ());
                          textViewCitys.setText (addresses.get (0).getCountryName ());
                      } catch (IOException e) {
                          e.printStackTrace ();
                      }
                  }
                }
            });
        }else {
            askPermission();
        }

        sendLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lat = viewLocationLat.getText ().toString ();
                String lon = textViewLong.getText ().toString ();
                String add = textViewAdds.getText ().toString ();
                String loc = textViewLocs.getText ().toString ();
                String city = textViewCitys.getText ().toString ();

                Intent intent = new Intent (getApplicationContext (), UserLocation.class);
                intent.putExtra ("Latitude", lat);
                intent.putExtra ("Longitude", lon);
                intent.putExtra ("Address", add);
                intent.putExtra ("Location", loc);
                intent.putExtra ("City", city);
                startActivity(intent);
            }
        });
   }

    private void askPermission() {
        ActivityCompat.requestPermissions (UserGetLocatiob.this, new String[]
                {ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       if(requestCode == REQUEST_CODE){
           if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
               showLocation ();
           }else {
               Toast.makeText (this, "Required Permission!", Toast.LENGTH_SHORT).show ();
           }
       }

        super.onRequestPermissionsResult (requestCode, permissions, grantResults);
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
                startActivity (new Intent (UserGetLocatiob.this, User_Dashboard.class));
                return true;


            //news headlines
            case R.id.idEdtUserHeadlines:
                startActivity (new Intent (UserGetLocatiob.this, ApiUser.class));
                return true;

            case R.id.idEdtUserProfile1:
                startActivity (new Intent (UserGetLocatiob.this, UserProfile.class));
                return true;


            case R.id.idEdtUserAbout:
                startActivity (new Intent (UserGetLocatiob.this, UserAbout.class));
                return true;


            case R.id.idEdtUserLogout:
                Toast.makeText (UserGetLocatiob.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut ();
                Intent i = new Intent (UserGetLocatiob.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:


                return super.onOptionsItemSelected (item);
        }

    }
}
