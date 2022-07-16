package com.cite.newscoopup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsRVAdapter.NewsClickInterface {

    private FloatingActionButton addNewsFAB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private RecyclerView newsRV;
    private FirebaseAuth mAuth;
    private ProgressBar loadingPB;
    private ArrayList<NewsRVModal> newsRVModalArrayList;
    private NewsRVAdapter newsRVAdapter;
    private RelativeLayout homeRL;
    private String newsID,post;
    GoogleSignInClient mGoogleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance ();
       // newsID = mAuth.getCurrentUser ().getUid ();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient (this, gso);


        newsRV = findViewById (R.id.idRVNews);
        homeRL = findViewById (R.id.idRLBSheet);
        loadingPB = findViewById (R.id.idPBLoading);
        addNewsFAB = findViewById (R.id.idFABAddNews);
        firebaseDatabase = FirebaseDatabase.getInstance ();
        newsRVModalArrayList = new ArrayList<> ();

       //databaseReference = FirebaseDatabase.getInstance ().getReference().child ("News");
        databaseReference = firebaseDatabase.getReference ("News");
        addNewsFAB.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, AddNewsActivity.class);
                startActivity (i);
            }
        });

       /* newsRVAdapter =  new NewsRVAdapter (newsRVModalArrayList, this, this :: onNewsClick);
        newsRV.setLayoutManager (new LinearLayoutManager (this));
        newsRV.setAdapter (newsRVAdapter);*/

        //LinearLayoutManager layoutManager = new LinearLayoutManager (this);
       // layoutManager.setReverseLayout(true);
       // layoutManager.setStackFromEnd (true);
        //newsRV.setLayoutManager (layoutManager);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout (true);
        layoutManager.setStackFromEnd (true);
        newsRV.setLayoutManager (layoutManager);

        newsRVAdapter = new NewsRVAdapter (newsRVModalArrayList, this, this :: onNewsClick);
        //newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(newsRVAdapter);
        getNews ();
    }

    private void getNews() {
        newsRVModalArrayList.clear ();
        databaseReference.addChildEventListener (new ChildEventListener () {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loadingPB.setVisibility (View.GONE);
                newsRVModalArrayList.add (snapshot.getValue (NewsRVModal.class));
                newsRVAdapter.notifyDataSetChanged ();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loadingPB.setVisibility (View.GONE);
                newsRVAdapter.notifyDataSetChanged ();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                newsRVAdapter.notifyDataSetChanged ();
                loadingPB.setVisibility (View.GONE);

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                newsRVAdapter.notifyDataSetChanged ();
                loadingPB.setVisibility (View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onNewsClick(int position) {
        displayBottomSheet (newsRVModalArrayList.get (position));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.main, menu);
        return true;
    }

    private void displayBottomSheet(NewsRVModal newsRVModal) {

        final BottomSheetDialog bottomSheetTeachersDialog = new BottomSheetDialog (this);
        View layout = LayoutInflater.from (this).inflate (R.layout.bottom_sheet_layout, homeRL);
        bottomSheetTeachersDialog.setContentView (layout);
        bottomSheetTeachersDialog.setCancelable (false);
        bottomSheetTeachersDialog.setCanceledOnTouchOutside (true);
        bottomSheetTeachersDialog.show ();
        //TextView newsUploadTV = layout.findViewById (R.id.idTVUploadBy);
        TextView newsNameTV = layout.findViewById (R.id.idTVNewsName);
        TextView newsDescTV = layout.findViewById (R.id.idTVNewsDesc);
        ImageView newsIV = layout.findViewById (R.id.idIVNews);
       //newsUploadTV.setText (newsRVModal.getNewsUpload ());
        newsNameTV.setText (newsRVModal.getNewsName ());
        newsDescTV.setText (newsRVModal.getNewsDescription ());
        Picasso.get ().load (newsRVModal.getNewsImg ()).into (newsIV);
        Button viewBtn = layout.findViewById (R.id.idBtnVIewDetails);
        Button editBtn = layout.findViewById (R.id.idBtnEditNews);

        editBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, EditNewsActivity.class);
                i.putExtra ("news", newsRVModal);
                startActivity (i);
            }
        });
        viewBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (Intent.ACTION_VIEW);
                i.setData (Uri.parse (newsRVModal.getNewsLink ()));
                startActivity (i);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId ();
        switch (id) {

            case R.id.idEdtDashboard:
                startActivity (new Intent (MainActivity.this, AdminDashboad.class));
                return true;


                //news headlines
            case R.id.idEdtHeadlines:
                startActivity (new Intent (MainActivity.this, ApiMainActivity.class));
                return true;


            case R.id.idEdtProfile1:
                startActivity (new Intent (MainActivity.this, EditProfileActivity.class));
                return true;



            case R.id.idEdtAbout:
                startActivity (new Intent (MainActivity.this, AboutUsActivity.class));
                return true;


            case R.id.idEdtLogout:
               Toast.makeText (MainActivity.this, "Log out successful", Toast.LENGTH_SHORT).show ();
              mAuth.signOut();
              mGoogleSignInClient.signOut ();
               Intent i = new Intent (MainActivity.this, LoginActivity.class);
               startActivity (i);
               this.finish ();
               return true;
            default:

                return super.onOptionsItemSelected (item);
        }
    }
}