package com.example.bhakti1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;

public class C1L1 extends AppCompatActivity {

    private boolean checkPermission = false;
    Uri uri;
    String songName,songUrl;

    JcPlayerView jcPlayerView;
    ArrayList<JcAudio> jcAudios = new ArrayList<>();

    JcAudio jcAudio;
    DrawerLayout drawerLayout;
    ViewPager viewPager;
    TabLayout mtablayout;
    ImageButton l111;
    ImageButton l112;
    MediaPlayer sound;
    AdView mAdView;
    TabItem mon, tue;
    C1L1PagerAdapter c1L1PagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_l1);
        drawerLayout = findViewById(R.id.drawer);
        viewPager = findViewById(R.id.view_pager);
        mtablayout = findViewById(R.id.tablayout);
        mon = findViewById(R.id.monday);
        tue = findViewById(R.id.tuesday);
        l111 = (ImageButton)findViewById(R.id.l111);
        l112 = (ImageButton)findViewById(R.id.l112);

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);

        Log.d("error1", String.valueOf(jcPlayerView));
        jcPlayerView = findViewById(R.id.jcplayer);
        Log.d("error2", String.valueOf(jcPlayerView));
        c1L1PagerAdapter = new C1L1PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mtablayout.getTabCount());
        viewPager.setAdapter(c1L1PagerAdapter);
        l111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(getApplicationContext(),R.raw.bell);
                sound.start();
            }
        });

        l112.setOnClickListener(new View.OnClickListener() {
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
        if (!jcPlayerView.isPlaying()) {

            Log.d("Kush", "1");
            retrieveSongs();
            Log.d("jinita", "2");

        } else
            Log.d("mamu", "banata");
        jcPlayerView.setVisibility(View.VISIBLE);
        jcPlayerView.createNotification();
    }


    private void retrieveSongs(){



        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Songs");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                jcAudios.add(JcAudio.createFromURL("Durga Maa Aarti","https://firebasestorage.googleapis.com/v0/b/musicplayer1-dad03.appspot.com/o/Songs%2Faudio%3A389265?alt=media&token=ae0251a0-ae1b-4c45-89fa-fd5e67e86615"));
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