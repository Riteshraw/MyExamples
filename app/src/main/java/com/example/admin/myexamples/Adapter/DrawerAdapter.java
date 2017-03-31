package com.example.admin.myexamples.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myexamples.Dao.Drawer;
import com.example.admin.myexamples.R;

public class DrawerAdapter extends ArrayAdapter<Drawer> {


    public DrawerAdapter(Context context, int resource, Drawer[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_drawer_list, parent, false);

        ((TextView) convertView.findViewById(R.id.textViewName)).setText(getItem(position).getName());
        ((ImageView) convertView.findViewById(R.id.imageViewIcon)).setImageResource(getItem(position).getIcon());

        return convertView;
    }
}
