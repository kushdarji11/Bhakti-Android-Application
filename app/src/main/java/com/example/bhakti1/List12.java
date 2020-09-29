package com.example.bhakti1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

public class List12 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    AdView mAdView;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list12);

        Integer[] imgs = {R.drawable.gayatrlist,R.drawable.gayatrlist,R.drawable.gayatrlist,R.drawable.gayatrlist,R.drawable.gayatrlist};

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_mine);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.mine);
        navigationView = (NavigationView)findViewById(R.id.nav);

        String[]  material = {"आरती","चालीसा","शक्तिपिट","मंत्र","स्तोत्रम्"};
        ListView listView = (ListView)findViewById(R.id.listView);

        getSupportActionBar().setTitle("Gayatri");

        MobileAds.initialize(this,"ca-app-pub-7793149896752698/7994630854");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);

        //navigationView.bringToFront();
        toggle    = new ActionBarDrawerToggle(this,drawerLayout , toolbar , R.string.open , R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburger);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.gayatri);

        MyListAdapter myadapter = new MyListAdapter(this,material,imgs);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position==0){
                    Log.e("CLICKED_KK", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C2L1.class);
                    startActivity(intent);
                }
                if (position==1){
                    Log.e("CLICKED_2", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C2L2.class);
                    startActivity(intent);
                }
                if (position==2){
                    Log.e("CLICKED_3", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C2L3.class);
                    startActivity(intent);
                }
                if (position==3){
                    Log.e("CLICKED_3", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C2L4.class);
                    startActivity(intent);
                }
                if (position==4){
                    Log.e("CLICKED_3", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C2L5.class);
                    startActivity(intent);
                }
            }
        });
    }
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (menuItem.getItemId()){
            case R.id.home:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.ambe:
                intent = new Intent(getBaseContext(),List11.class);
                startActivity(intent);
            case R.id.gayatri:
                break;
            case R.id.hanuman:
                intent = new Intent(getBaseContext(),List21.class);
                startActivity(intent);
                break;
            case R.id.krishna:
                intent = new Intent(getBaseContext(),List22.class);
                startActivity(intent);
                break;
            case R.id.ganesha:
                intent = new Intent(getBaseContext(),List31.class);
                startActivity(intent);
                break;
            case R.id.shani:
                intent = new Intent(getBaseContext(),List32.class);
                startActivity(intent);
                break;
            case R.id.mahadev:
                intent = new Intent(getBaseContext(),List41.class);
                startActivity(intent);
                break;
            case R.id.laxmi:
                intent = new Intent(getBaseContext(),List42.class);
                startActivity(intent);
                break;
            case R.id.share:
                if(id == R.id.share){
                    ApplicationInfo api = getApplicationContext().getApplicationInfo();
                    String apkpath = api.sourceDir;
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("application/vnd.android.package-archive");
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
                    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                    StrictMode.setVmPolicy(builder.build());
                    startActivity(Intent.createChooser(intent, "ShareVia"));
                }
                return true;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
