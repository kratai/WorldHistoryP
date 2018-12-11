package com.example.admin.worldhistoryp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TimeAustralia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_australia);
        ImageView lesstime4;
        lesstime4 = (ImageView) findViewById(R.id.lesstime4);
        lesstime4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),LessonTimeAus1.class);
                startActivity(it);
            }
        });


    }
}
