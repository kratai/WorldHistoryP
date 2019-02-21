package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Game extends AppCompatActivity {
    LinearLayout LinearGame1,LinearGame2,LinearGame3;
    Animation lefttoright,righttoleft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        LinearGame1 = (LinearLayout) findViewById(R.id.LinearGame1);
        LinearGame2 = (LinearLayout) findViewById(R.id.LinearGame2);
        LinearGame3 = (LinearLayout) findViewById(R.id.LinearGame3);

        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);

        LinearGame1.setAnimation(righttoleft);
        LinearGame2.setAnimation(lefttoright);
        LinearGame3.setAnimation(righttoleft);
        ImageView game1;
        game1 = (ImageView) findViewById(R.id.game1);
        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),picquiz.class);
                startActivity(it);
            }
        });

        ImageView game2;
        game2 = (ImageView) findViewById(R.id.game2);
        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),RockPaperScissor.class);
                startActivity(it);
            }
        });
        ImageView game3;
        game3 = (ImageView) findViewById(R.id.game3);
        game3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),GameQuiz.class);
                startActivity(it);
            }
        });
    }
}
