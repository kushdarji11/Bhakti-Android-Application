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


public class C1L5 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ViewPager viewPager;
    TabLayout mtablayout;
    AdView mAdView;
    TabItem mon ,tue;
    C1L5PagerAdapter c1L5PagerAdapter;
    ImageButton l151;
    ImageButton l152;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_l5);
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);
        mtablayout = findViewById(R.id.tablayout);
        //mon = findViewById(R.id.three);
        tue = findViewById(R.id.four);
        l151 = (ImageButton)findViewById(R.id.l151);
        l152 = (ImageButton)findViewById(R.id.l152);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);
        c1L5PagerAdapter = new C1L5PagerAdapter(getSupportFragmentManager() , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT , mtablayout.getTabCount());
        viewPager.setAdapter(c1L5PagerAdapter);
        l151.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getApplicationContext(),R.raw.bell);
                sound.start();

            }
        });

        l152.setOnClickListener(new View.OnClickListener() {
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
