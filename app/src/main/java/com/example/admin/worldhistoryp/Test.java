package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Test extends AppCompatActivity {
    LinearLayout Lineartest1,Lineartest2,Lineartest3;
    Animation lefttoright,righttoleft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Lineartest1 = (LinearLayout) findViewById(R.id.Lineartest1);
        Lineartest2 = (LinearLayout) findViewById(R.id.Lineartest2);
        Lineartest3 = (LinearLayout) findViewById(R.id.Lineartest3);

        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);

        Lineartest1.setAnimation(righttoleft);
        Lineartest2.setAnimation(lefttoright);
        Lineartest3.setAnimation(righttoleft);

        ImageView test1;
        test1 = (ImageView) findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),test1.class);
                startActivity(it);
            }
        });

        ImageView test2;
        test2 = (ImageView) findViewById(R.id.test2);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),test2.class);
                startActivity(it);
            }
        });

        ImageView test3;
        test3 = (ImageView) findViewById(R.id.test3);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),test3.class);
                startActivity(it);
            }
        });
    }
}
