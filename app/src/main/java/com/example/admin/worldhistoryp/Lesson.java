package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

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
                Intent it = new Intent(getApplicationContext(),TimeAmerica.class);
                startActivity(it);
            }
        });

        ImageView iceurope;
        iceurope = (ImageView) findViewById(R.id.LessonEurope);
        iceurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Time.class);
                startActivity(it);
            }
        });

        ImageView icafrica;
        icafrica = (ImageView) findViewById(R.id.LessonAfrica);
        icafrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),TimeAfrica.class);
                startActivity(it);
            }
        });

        ImageView icasia;
        icasia = (ImageView) findViewById(R.id.LessonAsia);
        icasia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),TimeAsia.class);
                startActivity(it);
            }
        });

        ImageView icaustralia;
        icaustralia = (ImageView) findViewById(R.id.LessonAustralia);
        icaustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),TimeAustralia.class);
                startActivity(it);
            }
        });
    }
}
