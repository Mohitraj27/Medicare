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

public class Eye_care_service extends AppCompatActivity {
Button EYe_care_excercise;
Button Doctors_consulation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_care_service);


//For Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Home_page_channel=new NotificationChannel("HomePage_notification", "HomePage_notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Home_page_manager =getSystemService(NotificationManager.class);
            Home_page_manager.createNotificationChannel(Home_page_channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"HomePage_notification")
                .setContentTitle("Eye Care Service")
                .setSmallIcon(R.drawable.app_logo)
                .setAutoCancel(true)
                .setContentText("We make our every effort to enhance your vision.\n ");

        NotificationManagerCompat Home_page_manager = NotificationManagerCompat.from(this);
        Home_page_manager.notify(1111,builder.build());


        Doctors_consulation=findViewById(R.id.Doctors);
        Doctors_consulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Eye_care_service.this,doctor_consulation.class);
                startActivity(intent);
            }
        });

   EYe_care_excercise=findViewById(R.id.eye_Care_excercise);
   EYe_care_excercise.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           Intent intent=new Intent(Eye_care_service.this,Eye_care_excercise.class);
           startActivity(intent);
       }
   });

    }


}