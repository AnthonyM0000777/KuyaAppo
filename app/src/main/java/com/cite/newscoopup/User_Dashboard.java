package com.cite.newscoopup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class User_Dashboard extends AppCompatActivity {
    private ImageView news, emergency, location, tips, hazard, video;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private FirebaseFirestore fStore;
    private ProgressBar loadingPB;
    private TextView upload;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private CircleImageView  view;
    private StorageReference storageReference;
    long backPress;
    Toast toast;
    private RelativeLayout test;


    @Override
    public void onBackPressed() {
        if(backPress + 2000 > System.currentTimeMillis ()){
            super.onBackPressed ();
            toast.cancel ();
            return;
        }else {
            toast = Toast.makeText (this, "Press Back Again to Exit!", Toast.LENGTH_SHORT);
            toast.show();
        }
        backPress = System.currentTimeMillis ();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
       setContentView (R.layout.activity_user_dashboard);

        video = findViewById (R.id.idWatch);
        hazard = findViewById (R.id.idHazardMap);
        news = findViewById (R.id.idNewss);
        location = findViewById (R.id.idLocation);
        tips = findViewById (R.id.idTipss);
        test = findViewById (R.id.test);
        loadingPB = findViewById (R.id.idPBLoading);
        upload = findViewById (R.id.uploader);
        emergency = findViewById (R.id.idEmergency);
        mAuth = FirebaseAuth.getInstance ();
        database = FirebaseDatabase.getInstance ();
        fStore = FirebaseFirestore.getInstance ();
        loadingPB.setVisibility (View.GONE);


        storageReference = FirebaseStorage.getInstance ().getReference ();

        view = findViewById (R.id.image_view);
        storageReference = FirebaseStorage.getInstance ().getReference ().child ("users/" + mAuth.getCurrentUser ().getUid () + "profile.jpg");

        user = FirebaseAuth.getInstance ().getCurrentUser ();
        reference = FirebaseDatabase.getInstance ().getReference ("Users");
        userID = user.getUid ();

        //retrieve image from firebase storage
        try {
            final File localFile = new File ("users/").createTempFile ("profile", "jpg");
            storageReference.getFile (localFile).addOnSuccessListener (new OnSuccessListener<FileDownloadTask.TaskSnapshot> () {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile (localFile.getAbsolutePath ());
                    ((ImageView) findViewById (R.id.image_view)).setImageBitmap (bitmap);
                }
            }).addOnFailureListener (new OnFailureListener () {
                @Override
                public void onFailure(@NonNull Exception e) {
                }
            });
        } catch (IOException e) {
            e.printStackTrace ();
        }//end


        view.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (User_Dashboard.this, UserProfile.class));
            }
        });

        news.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (User_Dashboard.this, UserMain.class));
            }
        });

        location.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (User_Dashboard.this, UserGetLocatiob.class));
            }
        });


        emergency.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (User_Dashboard.this, UserFirstAirKit.class));
            }
        });

        tips.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (User_Dashboard.this, UserTips.class));
            }
        });

        hazard.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (User_Dashboard.this, HazardMaps.class));
            }
        });
        video.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (User_Dashboard.this, WatchVideo.class));
            }
        });
        test.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (User_Dashboard.this, AppWeather.class));
            }
        });


        reference.child (userID).addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue (User.class);

                if(userProfile != null) {

                    String fullName = userProfile.fullName;

                    upload.setText (fullName);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText (User_Dashboard.this, "Something wrong", Toast.LENGTH_SHORT).show ();
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
                startActivity (new Intent (User_Dashboard.this, User_Dashboard.class));
                return true;


            //news headlines
            case R.id.idEdtUserHeadlines:
                startActivity (new Intent (User_Dashboard.this, ApiUser.class));
                return true;

            case R.id.idEdtUserProfile1:
                startActivity (new Intent (User_Dashboard.this, UserProfile.class));
                return true;


            case R.id.idEdtUserAbout:
                startActivity (new Intent (User_Dashboard.this, UserAbout.class));
                return true;

            case R.id.idEdtUserLogout:
                Toast.makeText (User_Dashboard.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut ();
                Intent i = new Intent (User_Dashboard.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }
}
