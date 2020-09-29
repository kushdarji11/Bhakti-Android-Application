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

public class C6L3 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ViewPager viewPager;
    TabLayout mtablayout;
    TabItem mon ,tue;
    AdView mAdView;
    C6L3PagerAdapter c6L3PagerAdapter;
    ImageButton l631;
    ImageButton l632;
    MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c6_l3);

        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);
        mtablayout = findViewById(R.id.tablayout);
       // mon = findViewById(R.id.yt);
        tue = findViewById(R.id.jr);
        l631 = (ImageButton)findViewById(R.id.l631);
        l632 = (ImageButton)findViewById(R.id.l632);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);

        c6L3PagerAdapter = new C6L3PagerAdapter(getSupportFragmentManager() , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT , mtablayout.getTabCount());
        viewPager.setAdapter(c6L3PagerAdapter);
        l631.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getApplicationContext(),R.raw.bell);
                sound.start();

            }
        });

        l632.setOnClickListener(new View.OnClickListener() {
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
