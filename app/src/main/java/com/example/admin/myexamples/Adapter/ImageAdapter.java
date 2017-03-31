package com.example.admin.myexamples.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.admin.myexamples.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.lock_9_view_node_highlighted);
            }
        });


        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.lock_9_view_node_normal,R.drawable.lock_9_view_node_normal,R.drawable.lock_9_view_node_normal,
            R.drawable.lock_9_view_node_normal,R.drawable.lock_9_view_node_normal,R.drawable.lock_9_view_node_normal,
            R.drawable.lock_9_view_node_normal,R.drawable.lock_9_view_node_normal,R.drawable.lock_9_view_node_normal,
    };
}