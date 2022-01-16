package com.cite.newscoopup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    private DatabaseReference databaseReference;
    private ProgressBar loadingPB;
    private String newsIDD, uid, newsID,newsDate, uploadBy, saveCurrentDate, saveCurrentTime, postRndomName;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_news);

       Calendar calFordDate = Calendar.getInstance ();
        SimpleDateFormat currentDate = new SimpleDateFormat ("  MMMM-DD-yyyy ");
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
        newsUploadEdt = findViewById (R.id.idEdtNewsUploadBy);
        addNewsBtn = findViewById (R.id.idBtnAddNews);
        loadingPB = findViewById (R.id.idPBLoading);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("News");
       // databaseReference = FirebaseDatabase.getInstance ().getReference("News");

        addNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insertNewsData();
                loadingPB.setVisibility(View.VISIBLE);
                String newsName = newsNameEdt.getText().toString();
                String newsDesc = newsDescEdt.getText().toString();
                String newsImg = newsImgEdt.getText().toString();
                String newsLink = newsLinkEdt.getText().toString();
                String newsUpload = newsUploadEdt.getText().toString();
                newsID = newsName;
                newsDate = postRndomName;
                uid = newsIDD;
                NewsRVModal newsRVModal = new NewsRVModal(newsID, newsName, newsDesc, newsImg, newsLink, newsUpload, newsDate, uid);
                databaseReference.addValueEventListener (new ValueEventListener () {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child (newsID).setValue(newsRVModal);
                        Toast.makeText(AddNewsActivity.this, "News Added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent (AddNewsActivity.this, MainActivity.class));
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddNewsActivity.this, "Fail to add News", Toast.LENGTH_SHORT).show();
                    }
                });
             }
        });
    }
}