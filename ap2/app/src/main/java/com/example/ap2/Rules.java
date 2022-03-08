package com.example.ap2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Rules extends AppCompatActivity {
TextView TX1,TX2,TX3,TX4,TX5;
    LinearLayout L;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        L=(LinearLayout)findViewById(R.id.L1);
        TX1=(TextView)findViewById(R.id.T1);
        TX2=(TextView)findViewById(R.id.T2);
        TX3=(TextView)findViewById(R.id.T3);
        TX4=(TextView)findViewById(R.id.T4);
        TX5=(TextView)findViewById(R.id.TV5);
        L.setBackgroundColor(Color.WHITE);
        TX1.setText("Rules ");
        TX2.setText("1.This is a single player game.This game contains ten general science questions.");
        TX3.setText("2.Player will be awarded 10 marks for every correct answer and 0 marks for every wrong answer.");
        TX4.setText("3.Click on LOCK after attempting each questions.");
        TX5.setText("4.Player who scores 40 will be rewarded a chocolate.");


    }
}
