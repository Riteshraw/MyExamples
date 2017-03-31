package com.example.admin.myexamples.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.myexamples.R;

public class First extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_tutorial, container, false);
        rootview.setBackgroundResource(R.color.colorPrimaryDark);
        ((TextView) rootview.findViewById(R.id.txt_text)).setText("This is ONE");
        return rootview;

    }
}
