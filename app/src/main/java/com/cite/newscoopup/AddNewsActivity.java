package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNewsActivity extends AppCompatActivity {

    private Button addNewsBtn;
    private TextInputEditText newsNameEdt, newsDescEdt, newsImgEdt, newsLinkEdt,newsUploadEdt;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference, userRef;
    private ProgressBar loadingPB;
    private String newsIDD, userID, uid, newsID,newsDate, uploader, saveCurrentDate, saveCurrentTime, postRndomName, fullName;
    private FirebaseAuth mAuth, user;
    private TextView userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_news);

        Calendar calFordDate = Calendar.getInstance ();
        SimpleDateFormat currentDate = new SimpleDateFormat ("  MMMM-dd-yyyy ");
        saveCurrentDate = currentDate.format (calFordDate.getTime ());

        Calendar calFordTime = Calendar.getInstance ();
        SimpleDateFormat currentTime = new SimpleDateFormat (" HH:mm aaa");
        saveCurrentTime = currentTime.format (calFordDate.getTime ());

        postRndomName = saveCurrentDate + saveCurrentTime;

        mAuth = FirebaseAuth.getInstance ();
        newsIDD = mAuth.getCurrentUser ().getUid ();

        newsNameEdt = findViewById (R.id.idEdtNewsName);
        newsImgEdt = findViewById (R.id.idEdtNewsImageLink);
        newsLinkEdt = findViewById (R.id.idEdtNewsLink);
        newsDescEdt = findViewById (R.id.idEdtNewsDescription);
        //newsUploadEdt = findViewById (R.id.idEdtNewsUploadBy);
        addNewsBtn = findViewById (R.id.idBtnAddNews);
        loadingPB = findViewById (R.id.idPBLoading);

       // userName = findViewById (R.id.idTVUploadBy);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("News");
        //databaseReference = FirebaseDatabase.getInstance ().getReference("News");

        //user method
        user = FirebaseAuth.getInstance ();
        userRef = FirebaseDatabase.getInstance ().getReference ("Users");
        userID = user.getCurrentUser ().getUid ();

        userRef.child (userID).addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue (User.class);

                if(userProfile!=null){

                   fullName = userProfile.fullName;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText (AddNewsActivity.this, "Something wrong", Toast.LENGTH_SHORT).show ();
            }
        });



        addNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insertNewsData();
                loadingPB.setVisibility(View.VISIBLE);
                 String newsName = newsNameEdt.getText().toString();
                String newsDesc = newsDescEdt.getText().toString();
                String newsImg = newsImgEdt.getText().toString();
                String newsLink = newsLinkEdt.getText().toString();
               // String newsUpload = newsUploadEdt.getText().toString();
                newsID = newsName;
                newsDate = postRndomName;
                //uploader = fullName;
                uid = newsIDD;
                NewsRVModal newsRVModal = new NewsRVModal(newsID, newsName, newsDesc, newsImg, newsLink, newsDate, uid );
                databaseReference.addValueEventListener (new ValueEventListener () {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child (newsID).setValue(newsRVModal);
                        Toast.makeText(AddNewsActivity.this, "Post Added ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent (AddNewsActivity.this, MainActivity.class));
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddNewsActivity.this, "Fail to add post", Toast.LENGTH_SHORT).show();
                    }
                });
             }
        });
    }
}