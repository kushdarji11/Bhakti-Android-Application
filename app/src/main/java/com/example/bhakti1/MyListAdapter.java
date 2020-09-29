package com.example.bhakti1;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.bhakti1.R.layout.activity_image_view_list;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] material;
    private final Integer[] imgs;

    public MyListAdapter(Activity context, String[] material, Integer[] imgs)
    {
        super(context, activity_image_view_list,material );
        this.context = context;
        this.material = material;
        this.imgs = imgs;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(activity_image_view_list,null,true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.myTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1);

        txtTitle.setText(material[position]);
        imageView.setImageResource(imgs[position]);

        return rowView;
    }
}
