package com.cite.newscoopup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText nameEdt, userNameEdt, passwordEdt;
    private Button loginBtn;
    private TextView newUserTV;
    private FirebaseAuth mAuth;
    private ProgressBar loadingPB;
    private ImageView idSign;
    private String fullName, userName,  number;
    private FirebaseDatabase database;
    boolean valid = true;
    FirebaseFirestore fStore;

    GoogleSignInClient mGoogleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
       mGoogleSignInClient = GoogleSignIn.getClient (this, gso);

        getSupportActionBar ().hide ();

        fStore = FirebaseFirestore.getInstance ();
        database = FirebaseDatabase.getInstance ();
        nameEdt = findViewById (R.id.idEdtName);
        userNameEdt = findViewById(R.id.idEdtUserName);
        passwordEdt = findViewById(R.id.idEdtPwd);
        loginBtn = findViewById(R.id.idBtnLogin);
        newUserTV = findViewById(R.id.idTVRegister);
        mAuth = FirebaseAuth.getInstance();
        loadingPB = findViewById(R.id.idPBLoading);
        idSign = findViewById(R.id.idSignIn);

        newUserTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        //google sgn n
        idSign.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                signIn ();
            }
        });

        signOut();
        //end


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                checkFeild(userNameEdt);
                checkFeild(passwordEdt);
                Log.d ("TAG", "onClick" + userNameEdt.getText ().toString ());

                String email = userNameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    loadingPB.setVisibility (View.GONE);
                    Toast.makeText(LoginActivity.this, "Please enter your credentials", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword (email, password).addOnSuccessListener (new OnSuccessListener<AuthResult> () {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        loadingPB.setVisibility (View.GONE);
                        Toast.makeText (LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show ();
                        checkUserAcessLevel(authResult.getUser ().getUid ());
                    }
                }).addOnFailureListener (new OnFailureListener () {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        loadingPB.setVisibility (View.GONE);
                        Toast.makeText (LoginActivity.this, e.getMessage (), Toast.LENGTH_SHORT).show ();
                    }
                });
              /* mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            loadingPB.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            loadingPB.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Please enter valid user credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/
            }
        });
    }

    private void checkUserAcessLevel(String uid) {
        DocumentReference df = fStore.collection ("Users").document (uid);
        df.get ().addOnSuccessListener (new OnSuccessListener<DocumentSnapshot> () {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d ("TAG", "onSuccess: " + documentSnapshot.getData ());
                //identify user access level
                if(documentSnapshot.getString ("isAdmin") != null) {

                    //user is admin
                    startActivity (new Intent (getApplicationContext (), AdminDashboad.class));
                    finish ();
                }
                if(documentSnapshot.getString ("isUser") != null){
                    startActivity (new Intent (getApplicationContext (), User_Dashboard.class));
                    finish ();
                }
            }
        });
    }

    private boolean checkFeild(TextInputEditText userNameEdt) {
        if(userNameEdt.getText ().toString ().isEmpty ()){
            valid = false;
        }else {
            valid = true;
        }
        return true;
    }


    private void signOut() {
        mGoogleSignInClient.signOut ().addOnCompleteListener (this, new OnCompleteListener<Void> () {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //Toast.makeText (LoginActivity.this, "Log out successful", Toast.LENGTH_SHORT).show ();
            }
        });
    }

    //start google sgn n
    int RC_SIGN_IN = 65;
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("TAG", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);

            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);

                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            User users = new User ();
                            users.setFullName (user.getDisplayName ());
                            users.setUserName (user.getEmail ());
                            database.getReference ().child ("Users").child (user.getUid ()).setValue (users);
                          //  updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Please enter valid user credentials", Toast.LENGTH_SHORT).show();

                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                           // updateUI(null);
                        }
                    }
                });
        //end
    }


    /*@Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            startActivity (new Intent (getApplicationContext (), NewsEvent.class));
            finish ();
           /* Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
            this.finish();
        }
    }*/
}