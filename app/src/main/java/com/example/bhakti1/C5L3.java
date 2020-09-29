package com.example.bhakti1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class C5L3 extends AppCompatActivity {

//    JcPlayerView jcPlayerView;
//    ArrayList<JcAudio> jcAudios = new ArrayList<>();

    DrawerLayout drawerLayout;
    ViewPager viewPager;
    TabLayout mtablayout;
    TabItem mon ,tue;
    C5L3PagerAdapter c5L3PagerAdapter;
    ImageButton l531;
    ImageButton l532;
    AdView mAdView;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c5_l3);
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);
        mtablayout = findViewById(R.id.tablayout);
        //mon = findViewById(R.id.u);
        tue = findViewById(R.id.v);
        l531 = (ImageButton)findViewById(R.id.l531);
        l532 = (ImageButton)findViewById(R.id.l532);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);
      //  jcPlayerView = findViewById(R.id.jcplayer53);

        c5L3PagerAdapter = new C5L3PagerAdapter(getSupportFragmentManager() , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT , mtablayout.getTabCount());
        viewPager.setAdapter(c5L3PagerAdapter);
        l531.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getApplicationContext(),R.raw.bell);
                sound.start();

            }
        });

        l532.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getApplicationContext(),R.raw.shell);
                sound.start();

            }
        });
        mtablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

       /* retrieveSongs();

        jcPlayerView.setVisibility(View.VISIBLE);
        jcPlayerView.createNotification();*/

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtablayout));
    }
   /* private void retrieveSongs(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Songs");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                jcAudios.add(JcAudio.createFromURL("Sukh Karta Dukh Harta","https://firebasestorage.googleapis.com/v0/b/musicplayer1-dad03.appspot.com/o/Songs%2Faudio%3A389307?alt=media&token=be167bf5-0c01-42c3-9b08-8c367b787869"));
                jcPlayerView.initPlaylist(jcAudios,null);;
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        //jcPlayerView.pause();
        jcPlayerView.kill();
    }*/
}
