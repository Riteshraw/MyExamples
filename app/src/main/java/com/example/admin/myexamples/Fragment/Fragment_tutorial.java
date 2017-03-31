package com.example.admin.myexamples.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.admin.myexamples.R;

import java.util.ArrayList;

public class Fragment_tutorial extends AppCompatActivity {
    FrameLayout frame_container;
    FragmentManager fm;
    FragmentTransaction ft;
    boolean doubleBackToExitPressedOnce = false;
    String arr[];
    int postion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_tutorial);

        initialiseControls();

        ((findViewById(R.id.txt_game))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new First());
            }
        });

        ((findViewById(R.id.txt_movie))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new Second());
            }
        });

        ((findViewById(R.id.txt_study))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new Third());
            }
        });

        ((findViewById(R.id.txt_4))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new Fourth());
            }
        });
    }

    private void changeFragment(Fragment fragment) {
        fm = getFragmentManager();
        Fragment currentFrag = fm.findFragmentById(R.id.frame_container);
        FragmentTransaction ft = fm.beginTransaction();
        String tag = fragment.getClass().getSimpleName();
        ArrayList<String> remBackStack = new ArrayList<>();
        ft.setCustomAnimations(R.animator.fragment_slide_left_enter,
                R.animator.fragment_slide_left_exit,
                R.animator.fragment_slide_right_enter,
                R.animator.fragment_slide_right_exit);

        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {

            if (fm.getBackStackEntryAt(i).getName().equals((fragment).getClass().getSimpleName())) {
                int position = i + 1;
                for (int j = 0; position < fm.getBackStackEntryCount(); position++, j++)
                    remBackStack.add(fm.getBackStackEntryAt(position).getName());

                fm.popBackStackImmediate(fm.getBackStackEntryAt(i).getId(), fm.POP_BACK_STACK_INCLUSIVE);

                for (int k = 0; k < remBackStack.size(); k++)
                    fm.beginTransaction().addToBackStack(remBackStack.get(k)).commit();

                break;
            }
        }

        ft.replace(R.id.frame_container, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();

    }

    public void replaceFragment(Fragment frag) {
        if (fm != null) {
            FragmentTransaction t = fm.beginTransaction();
            Fragment currentFrag = fm.findFragmentById(R.id.frame_container);

            //Check if the new Fragment is the same
            //If it is, don't add to the back stack
            if (currentFrag != null && currentFrag.getClass().equals(frag.getClass())) {
                t.replace(R.id.frame_container, frag).commit();
            } else {
                t.replace(R.id.frame_container, frag).addToBackStack(null).commit();
            }
        }
    }

    private void initialiseControls() {
        frame_container = (FrameLayout) findViewById(R.id.frame_container);
        changeFragment(new First());
    }

//    @Override
//    public void onBackPressed() {
//
//        if (fm.findFragmentById(R.id.frame_container) instanceof First) {
//            if (doubleBackToExitPressedOnce)
//                finish();
//            else {
////                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                this.doubleBackToExitPressedOnce = true;
//                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        doubleBackToExitPressedOnce = false;
//                    }
//                }, 2000);
//            }
//        } else {
////            FragmentTransaction ft = fm.beginTransaction();
//            fm.popBackStack();
////            ft.remove(fm.findFragmentById(R.id.frame_container));
////            ft.remove(fm.findFragmentByTag(fm.getBackStackEntryAt(fm.getBackStackEntryCount()-1).getName()));
////            ft.commit();
//        }
//    }
}
