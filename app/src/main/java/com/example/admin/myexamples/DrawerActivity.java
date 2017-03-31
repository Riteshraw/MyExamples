package com.example.admin.myexamples;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.myexamples.Adapter.DrawerAdapter;
import com.example.admin.myexamples.Dao.Drawer;
import com.example.admin.myexamples.Fragment.GameFragment;
import com.example.admin.myexamples.Fragment.MovieFragment;
import com.example.admin.myexamples.Fragment.StudyFragment;

public class DrawerActivity extends AppCompatActivity {
    private String[] drawerItemTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private SharedPreferences sharedPreferences;
    private DrawerAdapter drawerAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private TextView toolbar_title;
    private ImageView toolbar_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        initialiseControls();

        Drawer[] drawerItem = new Drawer[3];
        drawerItem[0] = new Drawer(R.mipmap.minus, "Wallet");
        drawerItem[1] = new Drawer(R.mipmap.minus_selected, "Banl");
        drawerItem[2] = new Drawer(R.mipmap.plus_selected, "Bag");

        drawerAdapter = new DrawerAdapter(this, R.layout.item_drawer_list, drawerItem);
        drawerList.setAdapter(drawerAdapter);

        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        toolbar_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void initialiseControls() {
        drawerLayout = (DrawerLayout) findViewById(R.id.layout_drawer);
        drawerList = (ListView) findViewById(R.id.list_drawer);
        drawerItemTitles = getResources().getStringArray(R.array.array_drawer_items);

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_img = (ImageView) findViewById(R.id.toolbar_img);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        mTitle = mDrawerTitle = getTitle();

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {

            //Called when a drawer has settled in a completely closed state.
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                /*getSupportActionBar().setTitle(mTitle);*/
                toolbar_title.setText(mTitle);
            }

            //Called when a drawer has settled in a completely open state.
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                /*getSupportActionBar().setTitle(mDrawerTitle);*/
                toolbar_title.setText(mDrawerTitle);
            }
        };

        drawerLayout.setDrawerListener(mDrawerToggle);

/*        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        /*getSupportActionBar().setTitle(mTitle);*/
        toolbar_title.setText(mTitle);
    }

    private void selectItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new GameFragment();
                break;
            case 1:
                fragment = new MovieFragment();
                break;
            case 2:
                fragment = new StudyFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_frame, fragment).commit();
            drawerList.setItemChecked(position, true);
            drawerList.setSelection(position);
            setTitle(drawerItemTitles[position]);
            drawerLayout.closeDrawer(drawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

}

