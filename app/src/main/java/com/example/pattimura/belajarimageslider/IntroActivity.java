package com.example.pattimura.belajarimageslider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by wildan on 15/03/17.
 */

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(SampleSlideFragment.newInstance(R.layout.fragment_sample_slide));
        addSlide(SampleSlideFragment.newInstance(R.layout.fragment_sample_slide2));
        addSlide(SampleSlideFragment.newInstance(R.layout.fragment_sample_slide3));
        addSlide(AppIntroFragment.newInstance("ini judul","ini deskripsi",R.drawable.ic_done_white,getResources().getColor(R.color.colorAccent)));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }
}
