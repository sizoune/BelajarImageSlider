package com.example.pattimura.belajarimageslider;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.chabbal.slidingdotsplash.SlidingSplashView;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    ArrayList<TimelineModel> isiTm = new ArrayList<>();
    AdapterTimeline adapter;
    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Lollipop", R.drawable.androlollipop);
        file_maps.put("Cupcake", R.drawable.cupcake);
        file_maps.put("Donut", R.drawable.donut);
        file_maps.put("Marshmallow", R.drawable.marshmallow);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra information here !",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);

        hardcodetimeline();
        ListView lv = (ListView) findViewById(R.id.isiTimeline);
        adapter = new AdapterTimeline(this, isiTm);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void hardcodetimeline() {
        isiTm.add(new TimelineModel("ini judul ya ?", "blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?", "blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?", "blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?", "blablablablablablablablablablablablablablablalablablablabl"));
        isiTm.add(new TimelineModel("ini judul ya ?", "blablablablablablablablablablablablablablablalablablablabl"));
    }

    @Override
    protected void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
