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

public class Heart_care_Service extends AppCompatActivity {
Button Heart_excercise;
Button Doctors_consulation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_care_service);


        //For Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Home_page_channel=new NotificationChannel("HomePage_notification", "HomePage_notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Home_page_manager =getSystemService(NotificationManager.class);
            Home_page_manager.createNotificationChannel(Home_page_channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"HomePage_notification")
                .setContentTitle("Welcome to our Heart Care Service")
                .setSmallIcon(R.drawable.app_logo)
                .setAutoCancel(true)
                .setContentText("We have heart care Exercises for your Healthy Heart !!\n ");

        NotificationManagerCompat Home_page_manager = NotificationManagerCompat.from(this);
        Home_page_manager.notify(11,builder.build());

        Heart_excercise=findViewById(R.id.heart_Care_excercise);
Heart_excercise.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Heart_care_Service.this,Heart_care_excercise.class);
        startActivity(intent);
    }
});
        Doctors_consulation=findViewById(R.id.Doctors);
        Doctors_consulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Heart_care_Service.this,doctor_consulation.class);
                startActivity(intent);
            }
        });
    }


}