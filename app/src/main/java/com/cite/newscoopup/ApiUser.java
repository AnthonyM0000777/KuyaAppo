package com.cite.newscoopup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cite.newscoopup.modals.NewsApiResponse;
import com.cite.newscoopup.modals.NewsHeadLines;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class ApiUser extends AppCompatActivity implements SelectListener, View.OnClickListener{
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    Button b1, b2, b3, b4, b5, b6, b7;
    SearchView searchView;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_api_user);

        mAuth = FirebaseAuth.getInstance ();

        searchView = findViewById (R.id.searchView1);
        searchView.setOnQueryTextListener (new SearchView.OnQueryTextListener () {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle ("Loading news articles of " + query);
                dialog.show ();
                RequestManager manager = new RequestManager (ApiUser.this);
                manager.getNewsHeadLines (listener, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog = new ProgressDialog (this);
        dialog.setTitle ("Loading news articles..");
        dialog.show ();

        b1 = findViewById (R.id.btn10);
        b1.setOnClickListener (this);
        b2 = findViewById (R.id.btn20);
        b2.setOnClickListener (this);
        b3 = findViewById (R.id.btn30);
        b3.setOnClickListener (this);
        b4 = findViewById (R.id.btn40);
        b4.setOnClickListener (this);
        b5 = findViewById (R.id.btn50);
        b5.setOnClickListener (this);
        b6 = findViewById (R.id.btn60);
        b6.setOnClickListener (this);
        b7 = findViewById (R.id.btn70);
        b7.setOnClickListener (this);

        RequestManager manager = new RequestManager (this);
        manager.getNewsHeadLines (listener, "general", null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse> () {
        @Override
        public void onFetchData(List<NewsHeadLines> list, String message) {
            if(list.isEmpty ()) {
                Toast.makeText (ApiUser.this, "No data found!!", Toast.LENGTH_SHORT).show ();
            }
            else {
                showNews(list);
                dialog.dismiss ();
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText (ApiUser.this, "An Error Occured!!", Toast.LENGTH_SHORT).show ();
        }
    };

    private void showNews(List<NewsHeadLines> list) {
        recyclerView = findViewById (R.id.recycler_main);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new GridLayoutManager (this, 1));
        adapter = new CustomAdapter (this, list, this);
        recyclerView.setAdapter (adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadLines headLines) {
        startActivity (new Intent (ApiUser.this, DetailActivity.class)
                .putExtra ("data", headLines));
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String category = button.getText ().toString ();
        dialog.setTitle ("Loading news articles of " + category);
        dialog.show ();
        RequestManager manager = new RequestManager (this);
        manager.getNewsHeadLines (listener, category, null);
    }
    //menu
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
                startActivity (new Intent (ApiUser.this, User_Dashboard.class));
                return true;

            //news headlines
            case R.id.idEdtUserHeadlines:
                startActivity (new Intent (ApiUser.this, ApiUser.class));
                return true;

            case R.id.idEdtUserProfile1:
                startActivity (new Intent (ApiUser.this, UserProfile.class));
                return true;


            case R.id.idEdtUserAbout:
                startActivity (new Intent (ApiUser.this, UserAbout.class));
                return true;

            case R.id.idEdtUserLogout:
                Toast.makeText (ApiUser.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut();
                Intent i = new Intent (ApiUser.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }
}