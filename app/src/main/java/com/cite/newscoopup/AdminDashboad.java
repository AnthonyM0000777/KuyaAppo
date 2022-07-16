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

public class AdminDashboad extends AppCompatActivity {
    private ImageView news, firstAid, tips, history, hazards, send;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private FirebaseFirestore fStore;
    private ProgressBar loadingPB;
    private TextView uploadAdmin;
    private FirebaseUser user;
    private DatabaseReference reference, storage;
    private String userID;

    private CircleImageView imageView;
    StorageReference storageReference;
    long backPress;
    Toast toast;


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
        setContentView (R.layout.activity_admin_dashboad);

        send = findViewById (R.id.idSendUpdate);
        hazards =findViewById (R.id.idHazards);
        news = findViewById (R.id.idNews);
        tips = findViewById (R.id.idTips);
        history = findViewById (R.id.idHistory);
        loadingPB = findViewById (R.id.idPBLoading);
        uploadAdmin = findViewById (R.id.uploaderAdmin);
        firstAid = findViewById (R.id.idEmergencys);

        mAuth = FirebaseAuth.getInstance ();
        database = FirebaseDatabase.getInstance ();
        fStore = FirebaseFirestore.getInstance ();
        loadingPB.setVisibility (View.GONE);

        storageReference = FirebaseStorage.getInstance ().getReference ();

        imageView = findViewById (R.id.image_view);
        storageReference = FirebaseStorage.getInstance ().getReference ().child ("users/"+mAuth.getCurrentUser().getUid()+"profile.jpg");

        user = FirebaseAuth.getInstance ().getCurrentUser ();
        reference = FirebaseDatabase.getInstance ().getReference ("Users");
        userID = user.getUid ();

        //retrieve image from firebase storage
        try {
            final File localFile = new File("users/").createTempFile ("profile", "jpg");
            storageReference.getFile (localFile).addOnSuccessListener (new OnSuccessListener<FileDownloadTask.TaskSnapshot> () {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                  Bitmap bitmap = BitmapFactory.decodeFile (localFile.getAbsolutePath ());
                    ((ImageView)findViewById (R.id.image_view)).setImageBitmap(bitmap);
                }
            }).addOnFailureListener (new OnFailureListener () {
                @Override
                public void onFailure(@NonNull Exception e) {
                }
            });
        }catch (IOException e){
            e.printStackTrace ();
        }//end

        //display name in dashboard
        reference.child (userID).addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue (User.class);

                if(userProfile != null) {

                    String fullName = userProfile.fullName;

                    uploadAdmin.setText (fullName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }); //end

        imageView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminDashboad.this, EditProfileActivity.class));
            }
        });

        hazards.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminDashboad.this, HazardMapsAdmin.class));

            }
        });


        send.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (AdminDashboad.this, SendNotificationToAllDevice.class));

            }
        });



        news.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (AdminDashboad.this, MainActivity.class));
            }
        });

       firstAid.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (AdminDashboad.this, AdminEmergency.class));
            }
        });

        tips.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (AdminDashboad.this, Tips.class));
            }
        });

        history.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.GONE);
                startActivity (new Intent (AdminDashboad.this, History.class));
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
                startActivity (new Intent (AdminDashboad.this, AdminDashboad.class));
                return true;

            //news headlines
            case R.id.idEdtHeadlines:
                startActivity (new Intent (AdminDashboad.this, ApiMainActivity.class));
                return true;

            case R.id.idEdtProfile1:
                startActivity (new Intent (AdminDashboad.this, EditProfileActivity.class));
                return true;


            case R.id.idEdtAbout:
                startActivity (new Intent (AdminDashboad.this, AboutUsActivity.class));
                return true;

            case R.id.idEdtLogout:
                Toast.makeText (AdminDashboad.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut ();
                Intent i = new Intent (AdminDashboad.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }
}