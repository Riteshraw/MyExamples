package com.example.admin.myexamples.Fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.admin.myexamples.R;
import com.example.admin.myexamples.Service.TouchImageView;

/**
 * Created by admin on 28-Nov-16.
 */

public class DialogImageFragment extends DialogFragment {
    private Dialog dialog;
    private int rotation = 0;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, R.style.AppTheme_NoActionBar);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_img_dialog, container);

        final TouchImageView touch = (TouchImageView) view.findViewById(R.id.img_zoom);
        touch.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.colerd_thank_you));

        ((Button) view.findViewById(R.id.btn_rotLeft)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotation = rotation + 90;
                touch.setRotation(rotation);
            }
        });

        ((Button) view.findViewById(R.id.btn_rotRight)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotation = rotation - 90;
                touch.setRotation(rotation);
            }
        });

        ((Button) view.findViewById(R.id.btn_zoomIn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.zoomIn();
            }
        });

        ((Button) view.findViewById(R.id.btn_zoomOut)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.zoomOut();
            }
        });

        return view;
    }

}
