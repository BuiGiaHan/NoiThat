package com.example.noithat;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nongsan.R;
import com.example.noithat.ui.fragment.FavouriteFragment;
import com.example.noithat.ui.fragment.HomeFragment;
import com.example.noithat.ui.fragment.OrderFragment;
import com.example.noithat.ui.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment = new HomeFragment();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();
        textView = (TextView) findViewById(R.id.tv_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ControlButton();
            }
        });

    }
    private void ControlButton(){
        Intent i = new Intent(this , LoginActivity.class);
        startActivity(i);
    }
    private void initGUI(){
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                    return true;
                case R.id.order:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new OrderFragment()).commit();
                    return true;
                case R.id.favourite:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavouriteFragment()).commit();
                    return true;
                case R.id.user:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new UserFragment()).commit();
                    return true;
            }
            return false;
        });
    }
}