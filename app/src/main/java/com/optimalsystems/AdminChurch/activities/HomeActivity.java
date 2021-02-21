package com.optimalsystems.AdminChurch.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.optimalsystems.AdminChurch.R;
import com.optimalsystems.AdminChurch.fragments.ChatsFragment;
import com.optimalsystems.AdminChurch.fragments.ChurchFragment;
import com.optimalsystems.AdminChurch.fragments.FiltersFragment;
import com.optimalsystems.AdminChurch.fragments.HomeFragment;
import com.optimalsystems.AdminChurch.fragments.ProfileFragment;
import com.optimalsystems.AdminChurch.providers.AuthProvider;
import com.optimalsystems.AdminChurch.providers.TokenProvider;
import com.optimalsystems.AdminChurch.providers.UsersProvider;
import com.optimalsystems.AdminChurch.utils.ViewedMessageHelper;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    TokenProvider mTokenProvider;
    AuthProvider mAuthProvider;
    UsersProvider mUsersProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        mTokenProvider = new TokenProvider();
        mAuthProvider = new AuthProvider();
        mUsersProvider = new UsersProvider();

        openFragment(new HomeFragment());
        createToken();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewedMessageHelper.updateOnline(true, HomeActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ViewedMessageHelper.updateOnline(false, HomeActivity.this);
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if (item.getItemId() == R.id.itemHome) {
                        // FRAGMENT HOME
                        openFragment(new HomeFragment());
                    }
                    else if (item.getItemId() == R.id.itemChats) {
                        // FRAGMENT CHATS
                        openFragment(new ChatsFragment());

                    }
                    else if (item.getItemId() == R.id.itemFilters) {
                        // FRAGMENT FILTROS
                        openFragment(new FiltersFragment());

                    }
                    else if (item.getItemId() == R.id.itemProfile) {
                        // FRAGMENT PROFILE
                        openFragment(new ProfileFragment());
                    }
                    else if (item.getItemId() == R.id.itemChurch) {
                        // FRAGMENT PROFILE
                        openFragment(new ChurchFragment());
                    }
                    return true;
                }
            };

    private void createToken() {
        mTokenProvider.create(mAuthProvider.getUid());
    }
}
