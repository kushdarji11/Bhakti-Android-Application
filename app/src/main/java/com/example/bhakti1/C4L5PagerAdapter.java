package com.example.bhakti1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class C4L5PagerAdapter extends FragmentPagerAdapter {
    int tabnumber;

    public C4L5PagerAdapter(@NonNull FragmentManager fm, int behavior , int tabnumber) {
        super(fm, behavior);
        this.tabnumber = tabnumber;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new C4L5_mon();
            case 1:
                return new C4L5_tue();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
