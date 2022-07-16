package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText nameEdt, userNameEdt, passwordEdt, confirmPwdEdt, numberEdt;
    private TextView loginTV;
    private Button registerBtn;
    private FirebaseAuth mAuth;
    private ProgressBar loadingPB;
    Boolean valid = true;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register);


        nameEdt = findViewById (R.id.idEdtName);
        numberEdt = findViewById (R.id.idEdtNumber);
        userNameEdt = findViewById(R.id.idEdtUserName);
        passwordEdt = findViewById(R.id.idEdtPwd);
        loadingPB = findViewById(R.id.idPBLoading);
        confirmPwdEdt = findViewById(R.id.idedtCnfPwd);
        loginTV = findViewById(R.id.idTVLogin);
        registerBtn = findViewById(R.id.idBtnRegister);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance ();

        getSupportActionBar ().hide ();

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility (View.VISIBLE);
                checkFeild (nameEdt);
                checkFeild (userNameEdt);
                checkFeild (passwordEdt);
                checkFeild (confirmPwdEdt);
                checkFeild (numberEdt);

                String fullName = nameEdt.getText ().toString ();
                String userName = userNameEdt.getText ().toString ();
                String pwd = passwordEdt.getText ().toString ();
                String cnfPwd = confirmPwdEdt.getText ().toString ();
                String number = numberEdt.getText ().toString ();


                if (!pwd.equals(cnfPwd)) {
                    loadingPB.setVisibility (View.GONE);
                    Toast.makeText(RegisterActivity.this, "Please check both having same password", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(pwd) && TextUtils.isEmpty(cnfPwd) && TextUtils.isEmpty (fullName)) {
                    loadingPB.setVisibility (View.GONE);
                    Toast.makeText(RegisterActivity.this, "Please enter your credentials", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword (userName, pwd).addOnSuccessListener (new OnSuccessListener<AuthResult> () {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser users = mAuth.getCurrentUser ();
                            loadingPB.setVisibility (View.GONE);
                            Toast.makeText (RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show ();
                            DocumentReference df = fStore.collection ("Users").document (users.getUid ());
                            Map<String, Object> userInfo = new HashMap<> ();
                            userInfo.put ("FullName", nameEdt.getText ().toString ());
                            userInfo.put ("Email", userNameEdt.getText ().toString ());
                            userInfo.put ("Password", passwordEdt.getText ().toString ());
                            userInfo.put ("Confirm Password", confirmPwdEdt.getText ().toString ());
                            userInfo.put ("Number", numberEdt.getText ().toString ());
                            userInfo.put ("isUser", "1");
                            df.set (userInfo);
                            startActivity (new Intent (getApplicationContext (), LoginActivity.class));
                            finish ();

                            User user = new User (fullName, userName, number);
                            FirebaseDatabase.getInstance ().getReference ("Users")
                                    .child (FirebaseAuth.getInstance ().getCurrentUser ().getUid ())
                                    .setValue (user).addOnCompleteListener (new OnCompleteListener<Void> () {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    loadingPB.setVisibility (View.GONE);
                                    Toast.makeText (RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show ();
                                    Intent i = new Intent (RegisterActivity.this, LoginActivity.class);
                                    startActivity (i);
                                    finish ();
                                }
                            }).addOnFailureListener (new OnFailureListener () {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    loadingPB.setVisibility (View.GONE);
                                    Toast.makeText (RegisterActivity.this, "Failed To Create Account!", Toast.LENGTH_SHORT).show ();
                                }
                            });
                        }
                    });
                }
                        }
                    });
}

    private boolean checkFeild(TextInputEditText nameEdt) {
        if(nameEdt.getText ().toString ().isEmpty ()){
            valid = false;
        }else {
            valid = true;
        }
        return true;
    }}
                  /*  if(valid) {
                        mAuth.createUserWithEmailAndPassword (userName, pwd).addOnSuccessListener (new OnSuccessListener<AuthResult> () {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseUser users = mAuth.getCurrentUser ();
                                loadingPB.setVisibility (View.GONE);
                                Toast.makeText (RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show ();
                                DocumentReference df = fStore.collection ("Users").document (users.getUid ());
                                Map<String, Object> userInfo = new HashMap<> ();
                                userInfo.put ("FullName", nameEdt);
                                userInfo.put ("Email", userNameEdt);
                                userInfo.put ("Password", passwordEdt);
                                userInfo.put ("Confirm Password", confirmPwdEdt);
                                userInfo.put ("isUser", "1");
                                df.set (userInfo);
                                startActivity (new Intent (getApplicationContext (), LoginActivity.class));
                                finish ();
                            }
                        }).addOnFailureListener (new OnFailureListener () {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                loadingPB.setVisibility (View.GONE);
                                Toast.makeText (RegisterActivity.this, "Failed To Create Account!", Toast.LENGTH_SHORT).show ();
                            }
                        });
                    }*/




