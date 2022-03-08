package com.example.ap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class second extends AppCompatActivity implements View.OnClickListener {
    TextView Q1;
    RadioGroup R1;
    RadioButton RB11, RB12, RB13, RB14;
    Button B1;
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Q1 = (TextView) findViewById(R.id.q1);
        R1 = (RadioGroup) findViewById(R.id.g1);
        RB11 = (RadioButton) findViewById(R.id.o1a);
        RB12 = (RadioButton) findViewById(R.id.o1b);
        RB13 = (RadioButton) findViewById(R.id.o1c);
        RB14 = (RadioButton) findViewById(R.id.o1d);
        B1 = (Button) findViewById(R.id.bt1);
        B1.setOnClickListener(this);
        RB11.setOnCheckedChangeListener(new Radio_check());
        RB12.setOnCheckedChangeListener(new Radio_check());
        RB13.setOnCheckedChangeListener(new Radio_check());
        RB14.setOnCheckedChangeListener(new Radio_check());

    }


    public class Radio_check implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (RB11.isChecked()) {
                cnt=1;
            }
            if (RB12.isChecked()) {
             cnt=0;
            }
            if (RB13.isChecked()) {
                cnt=0;
            }
            if (RB14.isChecked()) {
                cnt=0;
            }

        }
    }
    @Override
    public void onClick(View view) {

        String score="0";
        if (cnt == 1) {
            Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
            score="10";
        }
        else if (cnt==0) {
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
            score="0";
        }

        Intent i = new Intent(this, third.class);
        i.putExtra("score",score);
        startActivity(i);
    }


}
