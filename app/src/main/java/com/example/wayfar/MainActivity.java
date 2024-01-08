package com.example.wayfar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer_layout;

    NavigationView navigation_view;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_layout = findViewById(R.id.drawer_layout);
        navigation_view = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.container,new dashboardfragment());
        ft.commit();

        fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawer_layout.addDrawerListener(toggle);

        toggle.syncState();
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.dashboard) {
                    toolbar.setTitle("Dashboard");

                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.add(R.id.container,new dashboardfragment());
                    ft.commit();

                    fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);


                    Toast.makeText(MainActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                } else if (id==R.id.basukedar) {
                    toolbar.setTitle("Basukedar Temple");

                    Toast.makeText(MainActivity.this, "Basukedar Temple", Toast.LENGTH_SHORT).show();
                } else if (id==R.id.someshwar) {
                    toolbar.setTitle("Someshwar Temple");
                    Toast.makeText(MainActivity.this, "Someshwar Temple", Toast.LENGTH_SHORT).show();
                } else if (id==R.id.mata_man) {
                    toolbar.setTitle("Mata Man Ichha Devi Temple");
                    Toast.makeText(MainActivity.this, "Mata Man Ichha Devi Temple", Toast.LENGTH_SHORT).show();
                } else if (id==R.id.bansi_narayan) {
                    toolbar.setTitle("Bansi Narayan Temple");
                    Toast.makeText(MainActivity.this, "Bansi Narayan Temple", Toast.LENGTH_SHORT).show();
                } else if (id==R.id.badrinath) {
                    toolbar.setTitle("Badrinath Temple");
                    Toast.makeText(MainActivity.this, "Badrinath Temple", Toast.LENGTH_SHORT).show();

                } else if (id==R.id.kedarnath) {
                    toolbar.setTitle("Kedarnath Temple");
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.container,new kedarnathfragment());
                    ft.commit();
                    Toast.makeText(MainActivity.this, "Kedarnath Temple", Toast.LENGTH_SHORT).show();
                } else if(id==R.id.flower_valley){
                    toolbar.setTitle("Valley of Flowers");
                    Toast.makeText(MainActivity.this, "Flower Valley", Toast.LENGTH_SHORT).show();
                }

                drawer_layout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }



}