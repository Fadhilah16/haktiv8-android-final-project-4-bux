package com.hacktiv.bux.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.hacktiv.bux.R;
import com.hacktiv.bux.activities.fragments.ListFragment;
import com.hacktiv.bux.activities.fragments.NotificationFragment;
import com.hacktiv.bux.activities.fragments.ProfileFragment;
import com.hacktiv.bux.activities.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    SearchFragment searchFragment = new SearchFragment();
    ListFragment listFragment = new ListFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.navigation_search);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,searchFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,searchFragment).commit();
                        return true;
                    case R.id.navigation_list:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,listFragment).commit();
                        return true;
                    case R.id.navigation_notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                        return true;
                    case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                        return true;
                }

                return false;
            }
        });

    }
}