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
import android.widget.Button;

public class Soul_care extends AppCompatActivity {
Button doctors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul_care);

        //For Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Home_page_channel=new NotificationChannel("HomePage_notification", "HomePage_notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Home_page_manager =getSystemService(NotificationManager.class);
            Home_page_manager.createNotificationChannel(Home_page_channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"HomePage_notification")
                .setContentTitle("Soul Care Service")
                .setSmallIcon(R.drawable.app_logo)
                .setAutoCancel(true)
                .setContentText("We believe in the purposeful care of one’s mind.\n ");

        NotificationManagerCompat Home_page_manager = NotificationManagerCompat.from(this);
        Home_page_manager.notify(1111111111,builder.build());



        doctors=findViewById(R.id.Doctors);
        doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Soul_care.this,doctor_consulation.class);
                startActivity(intent);
            }
        });
    }


}