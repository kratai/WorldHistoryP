package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Lesson extends AppCompatActivity {
    LinearLayout linearamerica,lineareurasia,linearafricaaustralia;
    Animation lefttoright,righttoleft,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        linearamerica = (LinearLayout) findViewById(R.id.linearamerica);
        lineareurasia = (LinearLayout) findViewById(R.id.lineareurasia);
        linearafricaaustralia = (LinearLayout) findViewById(R.id.linearafricaaustralia);

        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

        linearamerica.setAnimation(lefttoright);
        lineareurasia.setAnimation(righttoleft);
        linearafricaaustralia.setAnimation(downtoup);

        ImageView icamerica;
        icamerica = (ImageView) findViewById(R.id.LessonAmerica);
        icamerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),America.class);
                startActivity(it);
            }
        });

        ImageView iceurope;
        iceurope = (ImageView) findViewById(R.id.LessonEurope);
        iceurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Europe.class);
                startActivity(it);
            }
        });

        ImageView icafrica;
        icafrica = (ImageView) findViewById(R.id.LessonAfrica);
        icafrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Africa.class);
                startActivity(it);
            }
        });

        ImageView icasia;
        icasia = (ImageView) findViewById(R.id.LessonAsia);
        icasia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Asia.class);
                startActivity(it);
            }
        });

        ImageView icaustralia;
        icaustralia = (ImageView) findViewById(R.id.LessonAustralia);
        icaustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Australia.class);
                startActivity(it);
            }
        });
    }
}
