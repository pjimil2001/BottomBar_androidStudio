package com.example.bottom_bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragment.HomeFr;
import fragment.PersonFr;
import fragment.SettingFr;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView  navigationView =findViewById(R.id.nav_view);

        openFragment(PersonFr.newInstance("",""));

        navigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.person:
                        openFragment(PersonFr.newInstance("",""));
                       return;
                    case R.id.home:
                        openFragment(HomeFr.newInstance("",""));
                        return ;
                    case R.id.setting:
                        openFragment(SettingFr.newInstance("",""));
                        return ;



                }
                return;
                }

        });

    }




    public void openFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.flmain, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
}}