package com.cite.newscoopup;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfile extends AppCompatActivity {
    private TextView userNameEdt, numberEdt, nameEdt, latt;
    private ProgressBar loadingPBS;
    private TextView loginTV;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID, newsIDD;
    private int countPost = 0;
    private Button uploadBtn;
    double latitude;

    private CircleImageView imageView;
    private ImageView view;
    StorageReference storageReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_user_profile);

        userNameEdt = findViewById (R.id.idEdtUserName);
        numberEdt = findViewById (R.id.idEdtNumber);
        nameEdt = findViewById (R.id.idEdtName);
        //logoutBtn = findViewById (R.id.idBtnLogout);
        loadingPBS = findViewById (R.id.idPBLoading);
        loginTV = findViewById (R.id.idTVLogin);
        //uploadBtn = findViewById (R.id.ViewUpload);


        mAuth = FirebaseAuth.getInstance ();


        // postRef = FirebaseDatabase.getInstance ().getReference ().child ("News");
        //  mAuth = FirebaseAuth.getInstance ();
        // newsIDD = mAuth.getCurrentUser ().getUid ();

        // postRef = FirebaseDatabase.getInstance ().getReference ("Location List");

        user = FirebaseAuth.getInstance ().getCurrentUser ();
        reference = FirebaseDatabase.getInstance ().getReference ("Users");
        userID = user.getUid ();

        view = findViewById (R.id.chooseBtn);
        imageView = findViewById (R.id.image_view);
        storageReference = FirebaseStorage.getInstance ().getReference ();

        StorageReference profileRef = storageReference.child ("users/"+mAuth.getCurrentUser().getUid()+"profile.jpg");
        profileRef.getDownloadUrl ().addOnSuccessListener (new OnSuccessListener<Uri> () {
            @Override
            public void onSuccess(Uri uri) {
                loadingPBS.setVisibility (View.GONE);
                Picasso.get ().load (uri).into (imageView);
            }
        });

        view.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                loadingPBS.setVisibility (View.GONE);
                Intent openDeviceIntent = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult (openDeviceIntent, 1000);

            }
        });


        reference.child (userID).addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue (User.class);
                
                if(userProfile != null) {
                    String userName = userProfile.userName;
                    String fullName = userProfile.fullName;
                    String number = userProfile.number;

                    userNameEdt.setText (userName);
                    nameEdt.setText (fullName);
                    numberEdt.setText (number);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText (UserProfile.this, "Something wrong", Toast.LENGTH_SHORT).show ();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult (requestCode, resultCode, data);
        if(requestCode == 1000 ){
            if(resultCode == Activity.RESULT_OK){
                loadingPBS.setVisibility (View.GONE);
                Uri imageUri = data.getData ();
                uploadToStorage(imageUri);
            }
        }
    }

    private void uploadToStorage(Uri imageUri) {
        StorageReference fileRef = storageReference.child ("users/"+mAuth.getCurrentUser().getUid()+"profile.jpg");
        fileRef.putFile (imageUri).addOnSuccessListener (new OnSuccessListener<UploadTask.TaskSnapshot> () {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                loadingPBS.setVisibility (View.GONE);
                fileRef.getDownloadUrl ().addOnSuccessListener (new OnSuccessListener<Uri> () {
                    @Override
                    public void onSuccess(Uri uri) {
                        loadingPBS.setVisibility (View.GONE);
                        Picasso.get ().load (uri).into (imageView);
                        Toast.makeText (UserProfile.this, "Profile Uploaded.", Toast.LENGTH_SHORT).show ();
                    }
                });
            }
        }).addOnFailureListener (new OnFailureListener () {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingPBS.setVisibility (View.GONE);
                Toast.makeText (UserProfile.this, "Failed!", Toast.LENGTH_SHORT).show ();
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
                startActivity (new Intent (UserProfile.this, User_Dashboard.class));
                return true;


            //news headlines
            case R.id.idEdtUserHeadlines:
                startActivity (new Intent (UserProfile.this, ApiUser.class));
                return true;

            case R.id.idEdtUserProfile1:
                startActivity (new Intent (UserProfile.this, UserProfile.class));
                return true;


            case R.id.idEdtUserAbout:
                startActivity (new Intent (UserProfile.this, UserAbout.class));
                return true;


            case R.id.idEdtUserLogout:
                Toast.makeText (UserProfile.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut();
                Intent i = new Intent (UserProfile.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:


                return super.onOptionsItemSelected (item);
        }



    }
}