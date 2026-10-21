package com.ajdk.fragment_navigasi;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.ajdk.fragment_navigasi.fragment.CallFragment;
import com.ajdk.fragment_navigasi.fragment.ChatFragment;
import com.ajdk.fragment_navigasi.fragment.GroupFragment;
import com.ajdk.fragment_navigasi.fragment.RefreshFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_navigasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


        btn_navigasi = findViewById(R.id.tombol_navigasi);

        btn_navigasi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;

        int id = menuItem.getItemId();
            if (id == R.id.chat_navigasi){
                selectedFragment = new ChatFragment();
            } else if (id == R.id.call_navigasi){
                selectedFragment = new CallFragment();
            } else if (id == R.id.group_navigasi){
                selectedFragment = new GroupFragment();
            } else if (id == R.id.refresh_navigasi) {
                selectedFragment = new RefreshFragment();
            }
            getSupportFragmentManager(). beginTransaction(). replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
        }
    });
        btn_navigasi.setSelectedItemId(R.id.chat_navigasi);
    }

    }
