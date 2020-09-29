package com.example.bhakti1;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class HindiText extends AppCompatTextView {
    public HindiText(Context context) {
        super(context);
        iniTypeFace(context);
    }

    public HindiText(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniTypeFace(context);
    }

    public HindiText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniTypeFace(context);
    }

    private void  iniTypeFace(Context context){

        Typeface typeface = Typeface.createFromAsset(context.getAssets() ,"ak.ttf");
        this.setTypeface(typeface);
    }

}
