package com.project.perioddiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class patientlogin extends AppCompatActivity {
    TabLayout tabLayout1;
    ViewPager viewPager1;
    float v=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientlogin);
        tabLayout1 = findViewById(R.id.tab_layout1);
        viewPager1 = findViewById(R.id.view_pager1);

        tabLayout1.addTab(tabLayout1.newTab().setText("Login"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Signup"));
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginpatientAdapter loginpatientAdapter = new LoginpatientAdapter(getSupportFragmentManager() , this,tabLayout1.getTabCount());
        viewPager1.setAdapter(loginpatientAdapter);

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.setTranslationY(300);
        tabLayout1.setAlpha(v);
        tabLayout1.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

    }
}