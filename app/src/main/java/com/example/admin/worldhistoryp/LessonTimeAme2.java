package com.example.admin.worldhistoryp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LessonTimeAme2 extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;

    private SliderAdapterAme2 sliderAdapterAme2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_time_ame2);
        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotlayout);

        sliderAdapterAme2 = new SliderAdapterAme2(this);
        mSlideViewPager.setAdapter(sliderAdapterAme2);

        addDotsIndicator();

    }
    public void addDotsIndicator(){
        mDots = new TextView[7];

        for (int i = 0; i<mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorShape));

            mDotLayout.addView(mDots[i]);

        }
    }
}

