package com.cite.newscoopup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class EditNewsActivity extends AppCompatActivity {

    private TextInputEditText newsNameEdt, newsDescEdt,newsImgEdt, newsLinkEdt;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    NewsRVModal newsRVModal;
    private ProgressBar loadingPB;
    private String newsID;
    private Button addNewsBtn, deleteNewsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_edit_news);

        addNewsBtn= findViewById(R.id.idBtnAddNews);
        newsNameEdt = findViewById(R.id.idEdtNewsName);
        newsDescEdt = findViewById(R.id.idEdtNewsDescription);
        newsImgEdt = findViewById(R.id.idEdtNewsImageLink);
        newsLinkEdt = findViewById(R.id.idEdtNewsLink);
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        newsRVModal = getIntent().getParcelableExtra("news");
        deleteNewsBtn = findViewById(R.id.idBtnDeleteNews);

        if (newsRVModal != null) {
            newsNameEdt.setText(newsRVModal.getNewsName());
            newsImgEdt.setText(newsRVModal.getNewsImg());
            newsLinkEdt.setText(newsRVModal.getNewsLink());
            newsDescEdt.setText(newsRVModal.getNewsDescription());
            newsID = newsRVModal.getNewsID();
        }

        databaseReference = firebaseDatabase.getReference("News").child(newsID);
        addNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                String newsName = newsNameEdt.getText().toString();
                String newsDesc = newsDescEdt.getText().toString();
                String newsImg = newsImgEdt.getText().toString();
                String newsLink = newsLinkEdt.getText().toString();

                Map<String, Object> map = new HashMap<> ();
                map.put("newsName", newsName);
                map.put("newsDescription", newsDesc);
                map.put("newsImg", newsImg);
                map.put("newsLink", newsLink);
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
        databaseReference.removeValue();
        Toast.makeText(this, "News Deleted", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(EditNewsActivity.this, MainActivity.class));
    }
}
