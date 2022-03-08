package com.example.ap2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class fifth extends AppCompatActivity implements View.OnClickListener {
    TextView T;
    RadioGroup R1;
    RadioButton RB1, RB2, RB3, RB4;
    Button B1;
    int cnt=0;
    String score4="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        T = (TextView) findViewById(R.id.q4);
        R1 = (RadioGroup) findViewById(R.id.g4);
        RB1 = (RadioButton) findViewById(R.id.o4a);
        RB2 = (RadioButton) findViewById(R.id.o4b);
        RB3 = (RadioButton) findViewById(R.id.o4c);
        RB4 = (RadioButton) findViewById(R.id.o4d);
        B1 = (Button) findViewById(R.id.bt4);
        B1.setOnClickListener(this);
        RB1.setOnCheckedChangeListener(new Radio_check());
        RB2.setOnCheckedChangeListener(new Radio_check());
        RB3.setOnCheckedChangeListener(new Radio_check());
        RB4.setOnCheckedChangeListener(new Radio_check());
        score4 = getIntent().getExtras().getString("score3");

    }


    public class Radio_check implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (RB1.isChecked()) {
                cnt=0;
            }
            if (RB2.isChecked()) {
                cnt=0;
            }
            if (RB3.isChecked()) {
                cnt=1;
            }
            if (RB4.isChecked()) {
               cnt=0;
            }

        }
    }
    @Override
    public void onClick(View view) {

        if (cnt == 1){
            if (score4.equals("0"))
                score4 = "10";
            else if (score4.equals("10"))
                score4 = "20";
            else if(score4.equals("20"))
                score4="30";
            else if(score4.equals("30"))
                score4="40";
            Toast.makeText(getApplicationContext(), "Correct Answer ", Toast.LENGTH_SHORT).show();
        }
        else if (cnt==0)
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();


        Intent i = new Intent(this, score.class);
        i.putExtra("score4",score4);
        startActivity(i);
    }


}