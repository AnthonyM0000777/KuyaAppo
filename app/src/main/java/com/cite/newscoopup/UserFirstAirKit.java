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

 public class UserFirstAirKit extends AppCompatActivity {

     ImageView s1,s2,s3,s4,s5,
               ss1,ss2,ss3,ss4,ss5,
               sss1,sss2,sss3,sss4,sss5;
     FirebaseAuth mAuth;



     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView (R.layout.activity_user_first_air_kit);

         s1 = findViewById (R.id.s1);
         s2 = findViewById (R.id.s2);
         s3 = findViewById (R.id.s3);
         s4 = findViewById (R.id.s4);
         s5 = findViewById (R.id.s5);

         ss1 = findViewById (R.id.s6);
         ss2 = findViewById (R.id.s7);
         ss3 = findViewById (R.id.s8);
         ss4 = findViewById (R.id.s9);
         ss5 = findViewById (R.id.s10);

         sss1 = findViewById (R.id.s11);
         sss2 = findViewById (R.id.s12);
         sss3 = findViewById (R.id.s13);
         sss4 = findViewById (R.id.s14);
         sss5 = findViewById (R.id.s15);

         mAuth= FirebaseAuth.getInstance ();


         s1.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergency1.class));
             }
         });

         s2.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergency2.class));
             }
         });

         s3.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergency3.class));
             }
         });

         s4.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergency4.class));
             }
         });

         s5.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergency5.class));
             }
         });

         ss1.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencys1.class));
             }
         });

         ss2.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencys2.class));
             }
         });

         ss3.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencys3.class));
             }
         });

         ss4.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencys4.class));
             }
         });

         ss5.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencys5.class));
             }
         });

         sss1.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencyss1.class));
             }
         });

         sss2.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencyss2.class));
             }
         });

         sss3.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencyss3.class));
             }
         });

         sss4.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencyss4.class));
             }
         });

         sss5.setOnClickListener (new View.OnClickListener () {
             @Override
             public void onClick(View v) {
                 startActivity (new Intent (UserFirstAirKit.this, Emergencyss5.class));
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
                 startActivity (new Intent (UserFirstAirKit.this, User_Dashboard.class));
                 return true;

             //news headlines
             case R.id.idEdtUserHeadlines:
                 startActivity (new Intent (UserFirstAirKit.this, ApiUser.class));
                 return true;

             case R.id.idEdtUserProfile1:
                 startActivity (new Intent (UserFirstAirKit.this, UserProfile.class));
                 return true;


             case R.id.idEdtUserAbout:
                 startActivity (new Intent (UserFirstAirKit.this, UserAbout.class));
                 return true;


             case R.id.idEdtUserLogout:
                 Toast.makeText (UserFirstAirKit.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                 mAuth.signOut();
                 Intent i = new Intent (UserFirstAirKit.this, LoginActivity.class);
                 startActivity (i);
                 this.finish ();
                 return true;
             default:


                 return super.onOptionsItemSelected (item);
         }
     }
 }
