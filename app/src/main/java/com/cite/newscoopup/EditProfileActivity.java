package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfileActivity extends AppCompatActivity {
    private TextView userNameEdt, pwdEdt, nameEdt, postbtn;
    private ProgressBar loadingPB;
    private TextView loginTV;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private DatabaseReference reference, postRef;
    private String userID, newsIDD;
    private int countPost = 0;
    private Button uploadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_edit_profile);

        userNameEdt = findViewById (R.id.idEdtUserName);
        pwdEdt = findViewById (R.id.idEdtPwd);
        nameEdt = findViewById (R.id.idEdtName);
        //logoutBtn = findViewById (R.id.idBtnLogout);
        loadingPB = findViewById (R.id.idPBLoading);
        loginTV = findViewById (R.id.idTVLogin);
        //uploadBtn = findViewById (R.id.ViewUpload);


        //mAuth = FirebaseAuth.getInstance ();

        postbtn = (TextView) findViewById (R.id.post_news);

       // postRef = FirebaseDatabase.getInstance ().getReference ().child ("News");
      //  mAuth = FirebaseAuth.getInstance ();
       // newsIDD = mAuth.getCurrentUser ().getUid ();

        user = FirebaseAuth.getInstance ().getCurrentUser ();
        reference = FirebaseDatabase.getInstance ().getReference ("Users");
        userID = user.getUid ();

       // postRef.orderByChild ("uid").startAt (newsIDD)
         //       .endAt (newsIDD + "\uf8ff").addValueEventListener (new ValueEventListener () {
         //   @Override
           // public void onDataChange(@NonNull DataSnapshot snapshot) {
            //    if(snapshot.exists ()){
             //      countPost = (int) snapshot.getChildrenCount ();
               //     postbtn.setText("You have" +Integer.toString(countPost)+ " news uploads.");
              //  }else {
                //    postbtn.setText("0 Upload");
              //  }
          //  }

           // @Override
            //public void onCancelled(@NonNull DatabaseError error) {

         //   }
       // });

        reference.child (userID).addListenerForSingleValueEvent (new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue (User.class);

                if(userProfile!=null){
                    String userName = userProfile.userName;

                    String fullName = userProfile.fullName;

                    userNameEdt.setText (userName);
                    nameEdt.setText (fullName);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText (EditProfileActivity.this, "Something wrong", Toast.LENGTH_SHORT).show ();
            }
        });

       // uploadBtn.setOnClickListener (new View.OnClickListener () {
         //   @Override
          //  public void onClick(View v) {
           //     Intent i = new Intent (EditProfileActivity.this, ViewUpload.class);
            //    startActivity (i);
          //  }
       // });
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
                startActivity (new Intent (EditProfileActivity.this, MainActivity.class));
                this.finish ();
                return true;

            //news headlines
            case R.id.idEdtHeadlines:
                startActivity (new Intent (EditProfileActivity.this, ApiMainActivity.class));
                this.finish ();
                return true;

            case R.id.idEdtProfile1:
                //  Toast.makeText (this, "", Toast.LENGTH_SHORT).show ();
                //startActivity (new Intent (MainActivity.this, EditProfileActivity.class));
                ///this.finish ();
                return true;

            case R.id.idEdtProfile:
                startActivity (new Intent (EditProfileActivity.this, EditProfileActivity.class));
                this.finish ();
                return true;

            case R.id.idEdtSorting:
                //  Toast.makeText (this, "", Toast.LENGTH_SHORT).show ();
                //startActivity (new Intent (MainActivity.this, EditProfileActivity.class));
                ///this.finish ();
                return true;

            //view upload
            case R.id.idEdtView:
                startActivity (new Intent (EditProfileActivity.this, ViewUpload.class));
                this.finish ();
                return true;


            case R.id.idEdtAbout:
                startActivity (new Intent (EditProfileActivity.this, AboutUsActivity.class));
                this.finish ();
                return true;


            case R.id.idEdtLogout:
                Toast.makeText (EditProfileActivity.this, "Log out successful", Toast.LENGTH_SHORT).show ();
                mAuth.signOut();
                Intent i = new Intent (EditProfileActivity.this, LoginActivity.class);
                startActivity (i);
                this.finish ();
                return true;
            default:

                return super.onOptionsItemSelected (item);
        }

    }
}