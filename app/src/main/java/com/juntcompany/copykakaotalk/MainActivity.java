package com.juntcompany.copykakaotalk;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity { //탭페이저 액티비티

    TabLayout tabLayout;
    ViewPager pager;
    MyViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);



        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        pager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(mAdapter);

        tabLayout.setupWithViewPager(pager);

        tabLayout.removeAllTabs(); // 이걸 없애야 처음부터 이름이 재설정됨


       tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.friend_tab));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.talk_tab));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.news_tab));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.more_tab));
    }
}
