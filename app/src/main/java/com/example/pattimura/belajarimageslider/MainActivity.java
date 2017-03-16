package com.example.pattimura.belajarimageslider;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.chabbal.slidingdotsplash.SlidingSplashView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    ViewPager viewpager;
    ArrayList<TimelineModel> isiTm = new ArrayList<>();
    AdapterTimeline adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,IntroActivity.class));
        SlidingSplashView splashview = (SlidingSplashView) findViewById(R.id.splash);
        splashview.addOnPageChangeListener(this);
        hardcodetimeline();
        ListView lv = (ListView) findViewById(R.id.isiTimeline);
        adapter = new AdapterTimeline(this,isiTm);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void hardcodetimeline() {
        isiTm.add(new TimelineModel("ini judul ya ?","blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?","blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?","blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?","blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?","blablablablablablablablablablablablablablablalablablablabl"));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("OnPageScrolled", String.valueOf(position));
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("OnPageSelected", String.valueOf(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d("PageScrollStateChanged", String.valueOf(state));
    }
}
