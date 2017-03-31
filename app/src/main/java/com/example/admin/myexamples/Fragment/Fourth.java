package com.example.admin.myexamples.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.myexamples.R;

/**
 * Created by admin on 7/28/2016.
 */
public class Fourth extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_tutorial, container, false);
        rootview.setBackgroundResource(R.color.colorYellow);
        ((TextView) rootview.findViewById(R.id.txt_text)).setText("This is FOURTH");
        return rootview;
    }
}
