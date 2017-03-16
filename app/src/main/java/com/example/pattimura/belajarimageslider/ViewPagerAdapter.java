package com.example.pattimura.belajarimageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by wildan on 16/03/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private Integer[] images = {R.drawable.androlollipop, R.drawable.cupcake, R.drawable.donut, R.drawable.marshmallow, R.drawable.nougat};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.imageswipe, null);
        ImageView image = (ImageView) v.findViewById(R.id.imageViewswipe);
        image.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(v, 0);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View v = (View) object;
        vp.removeView(v);
    }
}
