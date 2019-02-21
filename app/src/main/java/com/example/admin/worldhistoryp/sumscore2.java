package com.example.admin.worldhistoryp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sumscore2 extends AppCompatActivity {

    private TextView totalscore;
    Gobal global = Gobal.getInstance();
    int sum = global.getSum();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumscore2);
        totalscore = (TextView)findViewById(R.id.totalscore);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            this.sum = bundle.getInt("sum");
        }
        totalscore.setText(this.sum+ " ");
    }
}
