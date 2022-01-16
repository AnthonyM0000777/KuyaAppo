package com.cite.newscoopup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class EditNewsActivity extends AppCompatActivity {

    private TextInputEditText newsNameEdt, newsDescEdt,newsImgEdt, newsLinkEdt,newsUploadEdt;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private NewsRVModal newsRVModal;
    private ProgressBar loadingPB;
    private String newsID, saveCurrentDate, saveCurrentTime, postRndomName;
    private Button addNewsBtn, deleteNewsBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_edit_news);

        Calendar calFordDate = Calendar.getInstance ();
        SimpleDateFormat currentDate = new SimpleDateFormat ("  MMMM-DD-yyyy ");
        saveCurrentDate = currentDate.format (calFordDate.getTime ());

        Calendar calFordTime = Calendar.getInstance ();
        SimpleDateFormat currentTime = new SimpleDateFormat (" HH:mm aaa");
        saveCurrentTime = currentTime.format (calFordDate.getTime ());

        postRndomName = saveCurrentDate + saveCurrentTime;

        addNewsBtn= findViewById(R.id.idBtnAddNews1);
        newsNameEdt = findViewById(R.id.idEdtNewsName1);
        newsDescEdt = findViewById(R.id.idEdtNewsDescription1);
        newsImgEdt = findViewById(R.id.idEdtNewsImageLink1);
        newsLinkEdt = findViewById(R.id.idEdtNewsLink1);
        newsUploadEdt = findViewById (R.id.idEdtNewsUploadBy1);
        deleteNewsBtn = findViewById(R.id.idBtnDeleteNews1);
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        newsRVModal = getIntent().getParcelableExtra("news");
       if (newsRVModal != null) {
            newsNameEdt.setText(newsRVModal.getNewsName());
            newsImgEdt.setText(newsRVModal.getNewsImg());
            newsLinkEdt.setText(newsRVModal.getNewsLink());
            newsDescEdt.setText(newsRVModal.getNewsDescription());
            newsUploadEdt.setText(newsRVModal.getNewsUpload());
            newsID = newsRVModal.getNewsID();
        }

       // mAuth = FirebaseAuth.getInstance();
       // newsID = mAuth.getCurrentUser().getUid();

        databaseReference = firebaseDatabase.getReference("News").child(newsID);

        //databaseReference = FirebaseDatabase.getInstance ().getReference("News").child (newsID);
        addNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                String newsName = newsNameEdt.getText().toString();
                String newsDesc = newsDescEdt.getText().toString();
                String newsImg = newsImgEdt.getText().toString();
                String newsLink = newsLinkEdt.getText().toString();
                String newsUpload = newsUploadEdt.getText().toString();

                Map<String, Object> map = new HashMap<> ();
                map.put("newsName", newsName);
                map.put("newsDescription", newsDesc);
                map.put("newsImg", newsImg);
                map.put("newsLink", newsLink);
                map.put("newsUpload", newsUpload);
                map.put("newsID", newsID);

                databaseReference.addValueEventListener(new ValueEventListener () {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        loadingPB.setVisibility(View.GONE);
                        databaseReference.updateChildren(map);
                        Toast.makeText(EditNewsActivity.this, "News Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent (EditNewsActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditNewsActivity.this, "Fail to update News", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        deleteNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNews();
            }
        });

    }

    private void deleteNews() {
       /* databaseReference.removeValue();
        Toast.makeText(this, "News Deleted", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(EditNewsActivity.this, MainActivity.class));*/
        AlertDialog.Builder builder = new AlertDialog.Builder (EditNewsActivity.this);
        builder.setMessage ("Are you sure you want to delete?")
                .setPositiveButton ("Yes", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        databaseReference.removeValue();
                        Toast.makeText(EditNewsActivity.this  , "News Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditNewsActivity.this, MainActivity.class));
                        finish ();
                    }
                }).setNegativeButton ("Cancel", null);
        AlertDialog alert = builder.create ();
        alert.show ();
    }
}
