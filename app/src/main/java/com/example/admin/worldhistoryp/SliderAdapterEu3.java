package com.example.admin.worldhistoryp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapterEu3 extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapterEu3(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.lesseurope6,
            R.drawable.lesseurope7,
            R.drawable.lesseurope8,
            R.drawable.lesseurope9,
            R.drawable.lesseurope10
    };
    public String[] slide_heading = {
            " ",
            " ",
            " ",
            " ",
            " "
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout2, container, false);

        ImageView slieImageview = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slieImageview.setImageResource(slide_images[position]);


//        slieImageview.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (position == 0) {
//
//                    Intent it = new Intent(context.getApplicationContext(), europe6.class);
//                    context.startActivity(it);
//                }
//                if (position == 1) {
//
//                    Intent it = new Intent(context.getApplicationContext(), europe7.class);
//                    context.startActivity(it);
//                }
//                if (position == 2) {
//
//                    Intent it = new Intent(context.getApplicationContext(), europe8.class);
//                    context.startActivity(it);
//                }
//                if (position == 3) {
//
//                    Intent it = new Intent(context.getApplicationContext(), europe9.class);
//                    context.startActivity(it);
//                }
//                if (position == 4) {
//
//                    Intent it = new Intent(context.getApplicationContext(), europe10.class);
//                    context.startActivity(it);
//                }
//
//            }
//
//        });

        slideHeading.setText(slide_heading[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}

