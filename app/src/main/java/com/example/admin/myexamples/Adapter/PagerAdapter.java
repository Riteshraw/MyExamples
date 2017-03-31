package com.example.admin.myexamples.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.myexamples.Fragment.GameFragment;
import com.example.admin.myexamples.Fragment.MovieFragment;
import com.example.admin.myexamples.Fragment.StudyFragment;

/**
 * Created by kundan on 10/16/2015.
 */
public class PagerAdapter  extends FragmentStatePagerAdapter{
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;

        switch (position){
            case 0:
                frag=new GameFragment();
//                frag.getView().setRotation(-90);
                break;
            case 1:
                frag=new MovieFragment();
//                frag.getView().setRotation(-90);
                break;
            case 2:
                frag=new StudyFragment();
//                frag.getView().setRotation(-90);
                break;
        }
//        frag.getView().setRotation(-90);
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Game";
                break;
            case 1:
                title="Movie";
                break;
            case 2:
                title="Study";
                break;
        }

        return title;
    }



}
