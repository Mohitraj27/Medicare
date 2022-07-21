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

public class doctor_consulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_consulation);
        //For Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Home_page_channel=new NotificationChannel("HomePage_notification", "HomePage_notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Home_page_manager =getSystemService(NotificationManager.class);
            Home_page_manager.createNotificationChannel(Home_page_channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"HomePage_notification")
                .setContentTitle("Doctors Consulation")
                .setSmallIcon(R.drawable.app_logo)
                .setAutoCancel(true)
                .setContentText("Get an expert Medical Opinion.\n ");

        NotificationManagerCompat Home_page_manager = NotificationManagerCompat.from(this);
        Home_page_manager.notify(111111,builder.build());


    }

    public void Google_form(View view) {

        Intent browserIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/Bjdn1Mraj1sv4Dwz6"));
        startActivity(browserIntent);
    }

    public void Get_in_touch_with_us(View view) {
        Intent browserIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/1Qu-pcGHetpdtO8yOdaujTSDW3kPOJCIiKMyDIblc7Do/edit"));
        startActivity(browserIntent);
    }
}