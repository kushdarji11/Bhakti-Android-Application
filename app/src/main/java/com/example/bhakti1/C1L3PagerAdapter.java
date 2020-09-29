package com.example.bhakti1;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.bhakti1.C1L2_mon;
import com.example.bhakti1.C1L2_tue;
import com.example.bhakti1.C1L3;

public class C1L3PagerAdapter extends FragmentPagerAdapter{
    int tabnumber;

    public C1L3PagerAdapter(@NonNull FragmentManager fm, int behavior , int tabnumber) {
        super(fm, behavior);
        this.tabnumber = tabnumber;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            /*case 0:
                return new C1L3_mon();*/
            case 0:
                return new C1L3_tue();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}