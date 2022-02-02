package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

    public class ViewUpload extends AppCompatActivity {
        private TextView postbtn;
        private FirebaseAuth mAuth;
        private DatabaseReference postRef;
        private String newsIDD;
        private int countPost = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate (savedInstanceState);
            setContentView (R.layout.activity_view_upload);

            postbtn = (TextView) findViewById (R.id.post_news);
            postRef = FirebaseDatabase.getInstance ().getReference ().child ("News");
            mAuth = FirebaseAuth.getInstance ();
            newsIDD = mAuth.getCurrentUser ().getUid ();

            postRef.orderByChild ("uid").startAt (newsIDD)
                    .endAt (newsIDD + "\uf8ff").addValueEventListener (new ValueEventListener () {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists ()){
                        countPost = (int) snapshot.getChildrenCount ();
                        postbtn.setText("You have " +Integer.toString(countPost)+ " news uploads.\n Stay active and just keep uploading different news to make readers more interesting in our apps.\n Thank you for Supporting Us.");
                    }else {
                        postbtn.setText("0 Upload");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

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
                    startActivity (new Intent (ViewUpload.this, MainActivity.class));
                    this.finish ();
                    return true;

                //news headlines
                case R.id.idEdtHeadlines:
                    startActivity (new Intent (ViewUpload.this, ApiMainActivity.class));
                    this.finish ();
                    return true;

                case R.id.idEdtProfile1:
                    //  Toast.makeText (this, "", Toast.LENGTH_SHORT).show ();
                    //startActivity (new Intent (MainActivity.this, EditProfileActivity.class));
                    ///this.finish ();
                    return true;

                case R.id.idEdtProfile:
                    startActivity (new Intent (ViewUpload.this, EditProfileActivity.class));
                    this.finish ();
                    return true;

                case R.id.idEdtSorting:
                    //  Toast.makeText (this, "", Toast.LENGTH_SHORT).show ();
                    //startActivity (new Intent (MainActivity.this, EditProfileActivity.class));
                    ///this.finish ();
                    return true;

                //view upload
                case R.id.idEdtView:
                    startActivity (new Intent (ViewUpload.this, ViewUpload.class));
                    this.finish ();
                    return true;


                case R.id.idEdtAbout:
                    startActivity (new Intent (ViewUpload.this, AboutUsActivity.class));
                    this.finish ();
                    return true;


                case R.id.idEdtLogout:
                    Toast.makeText (ViewUpload.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                    mAuth.signOut();
                    Intent i = new Intent (ViewUpload.this, LoginActivity.class);
                    startActivity (i);
                    this.finish ();
                    return true;
                default:

                    return super.onOptionsItemSelected (item);
            }

        }
    }