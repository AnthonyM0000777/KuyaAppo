package com.cite.newscoopup;


import static android.Manifest.permission.SEND_SMS;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class UserLocation extends AppCompatActivity {

    ImageView Sendbut, Sendbut1, Sendbut2, Sendbut3, Sendbut4, Sendbut5, Sendbut6;
    TextView mdrRmo, pnp, rhu, bfp, tarelco, balibago, ambulance;
    private static final int REQUEST_SMS = 0;
    final int send_sms_permission = 1;


    private String lat, lon, add, loc, city, loca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_user_location);


        Sendbut = findViewById (R.id.SendButton);
        Sendbut1 = findViewById (R.id.SendButton1);
        Sendbut2 = findViewById (R.id.SendButton2);
        Sendbut3 = findViewById (R.id.SendButton3);
        Sendbut4 = findViewById (R.id.SendButton4);
        Sendbut5 = findViewById (R.id.SendButton5);
        Sendbut6 = findViewById (R.id.SendButton6);
        mdrRmo = findViewById (R.id.mdrRmo);
        pnp = findViewById (R.id.pnp);
        rhu = findViewById (R.id.rhu);
        bfp = findViewById (R.id.bfp);
        tarelco = findViewById (R.id.tarelco);
        balibago = findViewById (R.id.balibago);
        ambulance = findViewById (R.id.ambulance);

        //loca = getIntent().getStringExtra("Location");

        //apply intent with getExtra
        Intent intent = getIntent ();
        lat = intent.getStringExtra ("Latitude");
        lon = intent.getStringExtra ("Longitude");
        add = intent.getStringExtra ("Address");
        loc = intent.getStringExtra ("Location");
        city = intent.getStringExtra ("City");

        Sendbut6.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendVerify ();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendMySMS6 ();
                    } else {
                        requestPermission (new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
                int hasSMSpermission = checkSelfPermission (SEND_SMS);
                if(hasSMSpermission != PackageManager.PERMISSION_GRANTED) {

                    if(!shouldShowRequestPermissionRationale (SEND_SMS)) {

                        showMessageOKCancel ("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener () {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions (new String[]{SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions (new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }
            }
        });


        Sendbut5.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendVerify ();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendMySMS5 ();
                    } else {
                        requestPermission (new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
                int hasSMSpermission = checkSelfPermission (SEND_SMS);
                if(hasSMSpermission != PackageManager.PERMISSION_GRANTED) {

                    if(!shouldShowRequestPermissionRationale (SEND_SMS)) {

                        showMessageOKCancel ("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener () {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions (new String[]{SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions (new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }
            }
        });
        Sendbut4.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendVerify ();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendMySMS4 ();
                    } else {
                        requestPermission (new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
                int hasSMSpermission = checkSelfPermission (SEND_SMS);
                if(hasSMSpermission != PackageManager.PERMISSION_GRANTED) {

                    if(!shouldShowRequestPermissionRationale (SEND_SMS)) {

                        showMessageOKCancel ("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener () {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions (new String[]{SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions (new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }
            }
        });

        Sendbut3.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendVerify ();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendMySMS3 ();
                    } else {
                        requestPermission (new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
                int hasSMSpermission = checkSelfPermission (SEND_SMS);
                if(hasSMSpermission != PackageManager.PERMISSION_GRANTED) {

                    if(!shouldShowRequestPermissionRationale (SEND_SMS)) {

                        showMessageOKCancel ("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener () {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions (new String[]{SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions (new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }
            }
        });

        Sendbut2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendVerify ();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendMySMS2 ();
                    } else {
                        requestPermission (new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
                int hasSMSpermission = checkSelfPermission (SEND_SMS);
                if(hasSMSpermission != PackageManager.PERMISSION_GRANTED) {

                    if(!shouldShowRequestPermissionRationale (SEND_SMS)) {

                        showMessageOKCancel ("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener () {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions (new String[]{SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions (new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }

            }

        });


        Sendbut1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendVerify ();
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendMySMS1 ();
                    } else {
                        requestPermission (new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
                int hasSMSpermission = checkSelfPermission (SEND_SMS);
                if(hasSMSpermission != PackageManager.PERMISSION_GRANTED) {

                    if(!shouldShowRequestPermissionRationale (SEND_SMS)) {

                        showMessageOKCancel ("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener () {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions (new String[]{SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions (new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }

            }
        });

        Sendbut.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendVerify ();

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if(checkSelfPermission (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendMySMS ();
                    } else {
                        requestPermission (new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }

                int hasSMSpermission = checkSelfPermission (SEND_SMS);
                if(hasSMSpermission != PackageManager.PERMISSION_GRANTED) {

                    if(!shouldShowRequestPermissionRationale (SEND_SMS)) {

                        showMessageOKCancel ("You need to allow access to Send SMS",
                                new DialogInterface.OnClickListener () {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                            requestPermissions (new String[]{SEND_SMS},
                                                    REQUEST_SMS);
                                        }
                                    }
                                });
                        return;

                    }
                    requestPermissions (new String[]{SEND_SMS}, REQUEST_SMS);
                    return;
                }


            }
        });

    }

    private void sendMySMS6() {
        String ambulanceTv = ambulance.getText ().toString ();
        if(ambulanceTv.trim ().length () > 0) {
            if(ContextCompat.checkSelfPermission (UserLocation.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions (UserLocation.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS);
            } else {
                String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q=" + lat + "," + lon;
                SmsManager smsManager = SmsManager.getDefault ();
                smsManager.sendTextMessage (ambulanceTv, null, sms, null, null);
            }
        }
    }

    private void sendMySMS5() {
        String balibagoTv = balibago.getText ().toString ();
        if(balibagoTv.trim ().length () > 0) {
            if(ContextCompat.checkSelfPermission (UserLocation.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions (UserLocation.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS);
            } else {
                String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q=" + lat + "," + lon;
                SmsManager smsManager = SmsManager.getDefault ();
                smsManager.sendTextMessage (balibagoTv, null, sms, null, null);
            }
        }
    }

    private void sendMySMS4() {
        String tarelcoTv = tarelco.getText ().toString ();
        if(tarelcoTv.trim ().length () > 0) {
            if(ContextCompat.checkSelfPermission (UserLocation.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions (UserLocation.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS);
            } else {
                String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q=" + lat + "," + lon;
                SmsManager smsManager = SmsManager.getDefault ();
                smsManager.sendTextMessage (tarelcoTv, null, sms, null, null);
            }
        }
    }

    private void sendMySMS3() {
        String bfpTv = bfp.getText ().toString ();
        if(bfpTv.trim ().length () > 0) {
            if(ContextCompat.checkSelfPermission (UserLocation.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions (UserLocation.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS);
            } else {
                String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q=" + lat + "," + lon;
                SmsManager smsManager = SmsManager.getDefault ();
                smsManager.sendTextMessage (bfpTv, null, sms, null, null);
            }
        }
    }

    private void sendMySMS2() {
        String rhuTv = rhu.getText ().toString ();
        if(rhuTv.trim ().length () > 0) {
            if(ContextCompat.checkSelfPermission (UserLocation.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions (UserLocation.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS);
            } else {
                String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q=" + lat + "," + lon;
                SmsManager smsManager = SmsManager.getDefault ();
                smsManager.sendTextMessage (rhuTv, null, sms, null, null);
            }
        }
    }

    private void sendMySMS1() {
        String pnpTv = pnp.getText ().toString ();
        if(pnpTv.trim ().length () > 0) {
            if(ContextCompat.checkSelfPermission (UserLocation.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions (UserLocation.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS);
            } else {
                String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q=" + lat + "," + lon;
                SmsManager smsManager = SmsManager.getDefault ();
                smsManager.sendTextMessage (pnpTv, null, sms, null, null);
            }
        }
    }


    private void sendVerify() {
        AlertDialog.Builder builder = new AlertDialog.Builder (UserLocation.this);
        builder.setMessage ("Share your location?")
                .setPositiveButton ("Ok", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (UserLocation.this, "Message sent.", Toast.LENGTH_SHORT).show ();
                        startActivity (new Intent (UserLocation.this, User_Dashboard.class));
                        finish ();
                    }
                }).setNegativeButton ("Cancel", null);
        AlertDialog alert = builder.create ();
        alert.show ();
    }


    public void sendMySMS() {
        String mdrrmo = mdrRmo.getText ().toString ();
        if(mdrrmo.trim ().length () > 0) {
            if(ContextCompat.checkSelfPermission (UserLocation.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions (UserLocation.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS);
            } else {
                String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q=" + lat + "," + lon;
                SmsManager smsManager = SmsManager.getDefault ();
                smsManager.sendTextMessage (mdrrmo, null, sms, null, null);
            }
        }
        /*String smsNumber = phonenmbr.getText().toString().trim ();
        phonenmbr.setText(smsNumber);

        String sms = "I am stranded here -" + '\n' + "http://maps.google.com/?q="+ lat +"," + lon;
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(smsNumber, null, sms, null, null);*/
       /* try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(smsNumber, null, sms, null, null);
            Toast.makeText (this, "Message sent", Toast.LENGTH_SHORT).show ();
        }catch (Exception e){
            e.printStackTrace ();
            Toast.makeText (this, "Failed to sent message!", Toast.LENGTH_SHORT).show ();
        }*/
    }

    private boolean checkPermission() {
        return (ContextCompat.checkSelfPermission (getApplicationContext (), SEND_SMS) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission(String[] strings, int i) {
        ActivityCompat.requestPermissions (this, new String[]{SEND_SMS}, REQUEST_SMS);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_SMS:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText (getApplicationContext (), "Permission Granted, Now you can access sms", Toast.LENGTH_SHORT).show ();
                    sendMySMS ();

                } else {
                    Toast.makeText (getApplicationContext (), "Permission Denied, You cannot access and sms", Toast.LENGTH_SHORT).show ();
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if(shouldShowRequestPermissionRationale (SEND_SMS)) {
                            showMessageOKCancel ("You need to allow access to both the permissions",
                                    new DialogInterface.OnClickListener () {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions (new String[]{SEND_SMS},
                                                        REQUEST_SMS);
                                            }
                                        }
                                    });
                            return;
                        }
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult (requestCode, permissions, grantResults);
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder (UserLocation.this).setMessage (message);
        builder.setPositiveButton ("OK", okListener)
                .setNegativeButton ("Cancel", null);
        AlertDialog alert = builder.create ();
        alert.show ();
    }
}