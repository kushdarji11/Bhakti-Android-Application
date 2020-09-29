package com.example.bhakti1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class C4L6 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ViewPager viewPager;
    TabLayout mtablayout;
    TabItem mon ,tue;
    AdView mAdView;
    C4L6PagerAdapter c4L6PagerAdapter;
    ImageButton l461;
    ImageButton l462;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c4_l6);
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);
        mtablayout = findViewById(R.id.tablayout);
       // mon = findViewById(R.id.tp);
        tue = findViewById(R.id.rp);
        l461 = (ImageButton)findViewById(R.id.l461);
        l462 = (ImageButton)findViewById(R.id.l462);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);

        c4L6PagerAdapter = new C4L6PagerAdapter(getSupportFragmentManager() , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT , mtablayout.getTabCount());
        viewPager.setAdapter(c4L6PagerAdapter);
        l461.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getApplicationContext(),R.raw.bell);
                sound.start();

            }
        });

        l462.setOnClickListener(new View.OnClickListener() {
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


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtablayout));
    }
}
