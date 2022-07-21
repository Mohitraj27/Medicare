package com.example.learnathon1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_page extends AppCompatActivity {


    ImageView Heart_care,Eye_care,Soul_care,Blood_donation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        //For Notification
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Home_page_channel=new NotificationChannel("HomePage_notification", "HomePage_notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager Home_page_manager =getSystemService(NotificationManager.class);
            Home_page_manager.createNotificationChannel(Home_page_channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"HomePage_notification")
                .setContentTitle("Welcome to our Medicare Application")
                .setSmallIcon(R.drawable.app_logo)
                .setAutoCancel(true)
                .setContentText("We are committed towards your holistic well-being !!\n ");

        NotificationManagerCompat Home_page_manager = NotificationManagerCompat.from(this);
        Home_page_manager.notify(1,builder.build());





        Blood_donation=findViewById(R.id.blood_donation_);
        Blood_donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home_page.this,Blood_service.class);
                startActivity(intent);
            }
        });

        Soul_care=findViewById(R.id.soul_care);
        Soul_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home_page.this,Soul_care.class);
                startActivity(intent);
            }
        });
        Heart_care = findViewById(R.id.heart_Care);
        Heart_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home_page.this,Heart_care_Service.class);
                startActivity(intent);
            }
        });

        Eye_care = findViewById(R.id.eye_care);
        Eye_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Home_page.this,Eye_care_service.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public  void onBackPressed(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        finish();
                        Home_page.super.onBackPressed();
                    }
                })


                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });


        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }
}