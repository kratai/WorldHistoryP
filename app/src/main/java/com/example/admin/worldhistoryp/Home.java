package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {
    LinearLayout LinearLesson,LinearTest,LinearGame;
    Animation lefttoright,righttoleft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LinearLesson = (LinearLayout) findViewById(R.id.LinearLesson);
        LinearTest = (LinearLayout) findViewById(R.id.LinearTest);
        LinearGame = (LinearLayout) findViewById(R.id.LinearGame);

        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);

        LinearLesson.setAnimation(lefttoright);
        LinearTest.setAnimation(righttoleft);
        LinearGame.setAnimation(lefttoright);


        ImageView ICMenuLesson;
        ICMenuLesson = (ImageView) findViewById(R.id.ICMenuLesson);
        ICMenuLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Lesson.class);
                startActivity(it);
            }
        });

        ImageView ICMenuTest;
        ICMenuTest = (ImageView) findViewById(R.id.ICMenuTest);
        ICMenuTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Test.class);
                startActivity(it);
            }
        });

        ImageView ICMenuGame;
        ICMenuGame = (ImageView) findViewById(R.id.ICMenuGame);
        ICMenuGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),Game.class);
                startActivity(it);
            }
        });
    }
}
