package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TimeAsia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_asia);

        ImageView lesstime1;
        lesstime1 = (ImageView) findViewById(R.id.lesstime1);
        lesstime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAsia1.class);
                startActivity(it);
            }
        });

        ImageView lesstime2;
        lesstime2 = (ImageView) findViewById(R.id.lesstime2);
        lesstime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAsia2.class);
                startActivity(it);
            }
        });

        ImageView lesstime3;
        lesstime3 = (ImageView) findViewById(R.id.lesstime3);
        lesstime3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAsia3.class);
                startActivity(it);
            }
        });
        ImageView lesstime4;
        lesstime4 = (ImageView) findViewById(R.id.lesstime4);
        lesstime4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAsia4.class);
                startActivity(it);
            }
        });

        ImageView lesstime5;
        lesstime5 = (ImageView) findViewById(R.id.lesstime5);
        lesstime5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAsia5.class);
                startActivity(it);
            }
        });
    }
}


