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

public class C8L2 extends AppCompatActivity {

    JcPlayerView jcPlayerView;
    ArrayList<JcAudio> jcAudios = new ArrayList<>();

    DrawerLayout drawerLayout;
    ViewPager viewPager;
    TabLayout mtablayout;
    TabItem mon ,tue;
    AdView mAdView;
    C8L2PagerAdapter c8L2PagerAdapter;
    ImageButton l821;
    ImageButton l822;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c8_l2);
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);
        mtablayout = findViewById(R.id.tablayout);
        mon = findViewById(R.id.ep3);
        tue = findViewById(R.id.ep4);
        l821 = (ImageButton)findViewById(R.id.l821);
        l822 = (ImageButton)findViewById(R.id.l822);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);

        jcPlayerView = findViewById(R.id.jcplayer82);

        c8L2PagerAdapter = new C8L2PagerAdapter(getSupportFragmentManager() , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT , mtablayout.getTabCount());
        viewPager.setAdapter(c8L2PagerAdapter);

        l821.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getApplicationContext(),R.raw.bell);
                sound.start();

            }
        });

        l822.setOnClickListener(new View.OnClickListener() {
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

        retrieveSongs();

        jcPlayerView.setVisibility(View.VISIBLE);
        jcPlayerView.createNotification();

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtablayout));
    }
    private void retrieveSongs(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Songs");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                jcAudios.add(JcAudio.createFromURL("Laxmi Chalisa","https://firebasestorage.googleapis.com/v0/b/musicplayer1-dad03.appspot.com/o/Songs%2Faudio%3A389314?alt=media&token=34d83a67-8077-438f-85f5-81a2e3f397d5"));
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
    }
}