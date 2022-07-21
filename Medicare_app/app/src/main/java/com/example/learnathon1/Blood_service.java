package com.example.learnathon1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Blood_service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_service);
        //For Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Home_page_channel=new NotificationChannel("HomePage_notification", "HomePage_notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Home_page_manager =getSystemService(NotificationManager.class);
            Home_page_manager.createNotificationChannel(Home_page_channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"HomePage_notification")
                .setContentTitle("Blood Donation Service")
                .setSmallIcon(R.drawable.app_logo)
                .setAutoCancel(true)
                .setContentText("Be the reason for someone's heartbeat..\n ");

        NotificationManagerCompat Home_page_manager = NotificationManagerCompat.from(this);
        Home_page_manager.notify(11111119,builder.build());

    }

    public void Red_cross(View view) {
        Intent browserIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://indianredcross.org/ircs/donatenow"));
        startActivity(browserIntent);
    }
}