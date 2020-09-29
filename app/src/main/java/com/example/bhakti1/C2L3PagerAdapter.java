package com.example.bhakti1;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class C2L3PagerAdapter extends FragmentPagerAdapter{
    int tabnumber;

    public C2L3PagerAdapter(@NonNull FragmentManager fm, int behavior , int tabnumber) {
        super(fm, behavior);
        this.tabnumber = tabnumber;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            /*case 0:
                return new C2L3_mon();*/
            case 0:
                return new C2L3_tue();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}