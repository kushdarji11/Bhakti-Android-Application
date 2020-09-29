package com.example.bhakti1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    CardView c11;
    CardView c12;
    CardView c21;
    CardView c22;
    CardView c31;
    CardView c32;
    CardView c41;
    CardView c42;

    AdView mAdView;

    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        c21 = findViewById(R.id.c21);
        c22 = findViewById(R.id.c22);
        c31 = findViewById(R.id.c31);
        c32 = findViewById(R.id.c32);
        c41 = findViewById(R.id.c41);
        c42 = findViewById(R.id.c42);

        gridLayout = (GridLayout) findViewById(R.id.mainGrid);
        ViewCompat.setNestedScrollingEnabled(gridLayout,true);

        MobileAds.initialize(this,"ca-app-pub-7793149896752698/7994630854");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);



        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List11.class));
            }
        });
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List12.class));
            }
        });
        c21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List21.class));
            }
        });
        c22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List22.class));
            }
        });
        c31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List31.class));
            }
        });
        c32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List32.class));
            }
        });
        c41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List41.class));
            }
        });
        c42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, List42.class));
            }
        });
    }
}