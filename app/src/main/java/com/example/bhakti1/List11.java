package com.example.bhakti1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

public class List11 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    AdView mAdView;

    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list11);

        drawerLayout = findViewById(R.id.mine);
        navigationView = (NavigationView)findViewById(R.id.nav);

        Integer[] imgs = {R.drawable.durgalist,R.drawable.durgalist,R.drawable.durgalist,R.drawable.durgalist,R.drawable.durgalist};

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_mine);
        setSupportActionBar(toolbar);

        String[]  material = {"आरती","आनंद गरबा","108 नाम","चालीसा", "पुष्पांजलि"};
        ListView listView = (ListView)findViewById(R.id.listView);

        getSupportActionBar().setTitle("Durga");
        //getSupportActionBar().setIcon(getDrawable(R.drawable.au));

        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest  = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);

        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this,drawerLayout , toolbar , R.string.open , R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburger);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.ambe);


        MyListAdapter myadapter = new MyListAdapter(this,material,imgs);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position==0){
                    Log.e("CLICKED_KK", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C1L1.class);
                    startActivity(intent);
                }
                if (position==1){
                    Log.e("CLICKED_2", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C1L2.class);
                    startActivity(intent);
                }
                if (position==2){
                    Log.e("CLICKED_3", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C1L3.class);
                    startActivity(intent);
                }
                if (position==3){
                    Log.e("CLICKED_3", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C1L4.class);
                    startActivity(intent);
                }
                if (position==4){
                    Log.e("CLICKED_3", "HERE");
                    Intent intent = new Intent(getApplicationContext(),C1L5.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
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
                break;
            case R.id.gayatri:
                intent = new Intent(getBaseContext(),List12.class);
                startActivity(intent);
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
