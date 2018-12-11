package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TimeAmerica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_america);
        ImageView lesstime3;
        lesstime3 = (ImageView) findViewById(R.id.lesstime3);
        lesstime3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAme1.class);
                startActivity(it);
            }
        });

        ImageView lesstime4;
        lesstime4 = (ImageView) findViewById(R.id.lesstime4);
        lesstime4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAme2.class);
                startActivity(it);
            }
        });

        ImageView lesstime5;
        lesstime5 = (ImageView) findViewById(R.id.lesstime5);
        lesstime5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAme3.class);
                startActivity(it);
            }
        });

    }
}
