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

public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;

    }


    public  int[] slide_images = {
            R.drawable.numame1,
            R.drawable.numame2,
            R.drawable.numame3,
            R.drawable.numame4,
            R.drawable.numame5,
            R.drawable.numame6,
            R.drawable.numame7,
            R.drawable.numame8,
            R.drawable.numame9
    };

    public  String[] slide_heading= {
            " ",
            " ",
            " ",
            " ",
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
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slieImageview = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slieImageview.setImageResource(slide_images[position]);


        slieImageview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(position == 0) {

                    Intent it = new Intent(context.getApplicationContext(), ame1.class);
                    context.startActivity(it);
                }
                if(position == 1) {

                    Intent it = new Intent(context.getApplicationContext(), ame2.class);
                    context.startActivity(it);
                }
                if(position == 2) {

                    Intent it = new Intent(context.getApplicationContext(), ame3.class);
                    context.startActivity(it);
                }
                if(position == 3) {

                    Intent it = new Intent(context.getApplicationContext(), ame4.class);
                    context.startActivity(it);
                }
                if(position == 4) {

                    Intent it = new Intent(context.getApplicationContext(), ame5.class);
                    context.startActivity(it);
                }
                if(position == 5) {

                    Intent it = new Intent(context.getApplicationContext(), ame6.class);
                    context.startActivity(it);
                }
                if(position == 6) {

                    Intent it = new Intent(context.getApplicationContext(), ame7.class);
                    context.startActivity(it);
                }
                if(position == 7) {

                    Intent it = new Intent(context.getApplicationContext(), ame8.class);
                    context.startActivity(it);
                }
                if(position == 8) {

                    Intent it = new Intent(context.getApplicationContext(), ame9.class);
                    context.startActivity(it);
                }
            }

       });

        slideHeading.setText(slide_heading[position]);

        container.addView(view);



        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

}
