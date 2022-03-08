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

class fourth extends AppCompatActivity implements View.OnClickListener {
    TextView T;
    RadioGroup R1;
    RadioButton RB1, RB2, RB3, RB4;
    Button B1;
    int cnt=0;
    String score3="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        T = (TextView) findViewById(R.id.q3);
        R1 = (RadioGroup) findViewById(R.id.g3);
        RB1 = (RadioButton) findViewById(R.id.o3a);
        RB2 = (RadioButton) findViewById(R.id.o3b);
        RB3 = (RadioButton) findViewById(R.id.o3c);
        RB4 = (RadioButton) findViewById(R.id.o3d);
        B1 = (Button) findViewById(R.id.bt3);
        B1.setOnClickListener(this);
        RB1.setOnCheckedChangeListener(new Radio_check());
        RB2.setOnCheckedChangeListener(new Radio_check());
        RB3.setOnCheckedChangeListener(new Radio_check());
        RB4.setOnCheckedChangeListener(new Radio_check());
        score3 = getIntent().getExtras().getString("score2");

    }


    public class Radio_check implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (RB1.isChecked()) {
                cnt=0;
            }
            if (RB2.isChecked()) {
                cnt=1;
            }
            if (RB3.isChecked()) {
                cnt=0;
            }
            if (RB4.isChecked()) {
               cnt=0;
            }

        }
    }
    @Override
    public void onClick(View view) {

        if (cnt == 1)
        {
        if (score3.equals("0"))
            score3 = "10";
        else if (score3.equals("10"))
            score3 = "20";
        else if(score3.equals("20"))
            score3="30";
        Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
    }
        else if (cnt==0)
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();


        Intent i = new Intent(this, fifth.class);
        i.putExtra("score3",score3);
        startActivity(i);
    }

}
