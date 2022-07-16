package com.cite.newscoopup;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cite.newscoopup.modals.NewsHeadLines;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    NewsHeadLines headLines;
    TextView title, author, time, detail, content;
    ImageView imgNews;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detail);

        title = findViewById (R.id.detailsTitle);
        author = findViewById (R.id.detailsAuthor);
        time = findViewById (R.id.detailsTime);
        detail = findViewById (R.id.detailsDetails);
        content = findViewById (R.id.detailsContent);
        imgNews = findViewById (R.id.imgNews);

        headLines =  (NewsHeadLines) getIntent ().getSerializableExtra ("data");

        title.setText (headLines.getTitle ());
        author.setText (headLines.getAuthor ());
        time.setText (headLines.getPublishedAt ());
        detail.setText (headLines.getDescription ());
        content.setText (headLines.getContent ());
        Picasso.get ().load (headLines.getUrlToImage ()).into (imgNews);
    }
}