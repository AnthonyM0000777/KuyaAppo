package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    HistoryAdapter adapter;
    ArrayList<LocationHelper> arrayList;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_history);

        mAuth = FirebaseAuth.getInstance ();

        recyclerView = findViewById (R.id.locationList);
        databaseReference = FirebaseDatabase.getInstance ().getReference ("Location List");
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));

        arrayList = new ArrayList<> ();
        adapter = new HistoryAdapter (this, arrayList);
        recyclerView.setAdapter (adapter);

        databaseReference.addValueEventListener (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for ( DataSnapshot dataSnapshot : snapshot.getChildren ()){
                    LocationHelper helper = dataSnapshot.getValue (LocationHelper.class);
                    arrayList.add (helper);
                }
                adapter.notifyDataSetChanged ();
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
                startActivity (new Intent (History.this, AdminDashboad.class));
                return true;


            //news headlines
            case R.id.idEdtHeadlines:
                startActivity (new Intent (History.this, ApiMainActivity.class));
                return true;

            case R.id.idEdtProfile1:
                startActivity (new Intent (History.this, EditProfileActivity.class));
                return true;


            case R.id.idEdtAbout:
                startActivity (new Intent (History.this, AboutUsActivity.class));
                return true;

            case R.id.idEdtLogout:
                Toast.makeText (History.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut ();
                Intent i = new Intent (History.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }
}