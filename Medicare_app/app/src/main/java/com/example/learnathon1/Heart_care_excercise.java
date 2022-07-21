package com.example.learnathon1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Heart_care_excercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_care_excercise);
    }

    public void Heart_excercise(View view) {

            Intent browserIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=gNUq_rCtbxQ"));
            startActivity(browserIntent);
        }

    }
