package com.example.ap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class score extends AppCompatActivity {

    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        String ss=getIntent().getExtras().getString("score4");
        t1=(TextView)findViewById(R.id.wow);
        t2=(TextView)findViewById(R.id.sc);
        t1.setText("CONGRATULATIONS!!\n You did great!!\n You are awesome!!!!!!!!!!");
        t2.setText("YOUR SCORE IS "+ss+"/40");
    }
}
