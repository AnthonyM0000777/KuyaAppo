package com.cite.newscoopup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;

public class SendNotificationToAllDevice extends AppCompatActivity {

    private TextInputEditText title, message;
    private Button sentBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_send_notification_to_all_device);

        FirebaseMessaging.getInstance().subscribeToTopic("all");
        title = findViewById (R.id.idTitle1);
        message = findViewById (R.id.idMessage1);
        sentBTN = findViewById (R.id.idSentBTN);

        sentBTN.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(!title.getText ().toString ().isEmpty () && !message.getText ().toString ().isEmpty ()){
                    FcmNotificationsSender notificationsSender = new FcmNotificationsSender ("/topics/all",title.getText ().toString (),message.getText ().toString ()
                            ,getApplicationContext (), SendNotificationToAllDevice.this);

                    Toast.makeText (SendNotificationToAllDevice.this, "Sent Successful", Toast.LENGTH_SHORT).show ();
                    notificationsSender.SendNotifications ();

                    startActivity (new Intent (SendNotificationToAllDevice.this, AdminDashboad.class));
                }else {
                    Toast.makeText (SendNotificationToAllDevice.this, "Please write your message.", Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }
}