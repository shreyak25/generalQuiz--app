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

public class third extends AppCompatActivity implements View.OnClickListener {
    TextView Q2;
    RadioGroup R2;
    RadioButton RB21, RB22, RB23, RB24;
    Button B2;
    int cnt2 = 0;
    String score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Q2 = (TextView) findViewById(R.id.q2);
        R2 = (RadioGroup) findViewById(R.id.g2);
        RB21 = (RadioButton) findViewById(R.id.o2a);
        RB22 = (RadioButton) findViewById(R.id.o2b);
        RB23 = (RadioButton) findViewById(R.id.o2c);
        RB24 = (RadioButton) findViewById(R.id.o2d);
        B2 = (Button) findViewById(R.id.bt2);
        B2.setOnClickListener(this);
        RB21.setOnCheckedChangeListener(new Radio_check());
        RB22.setOnCheckedChangeListener(new Radio_check());
        RB23.setOnCheckedChangeListener(new Radio_check());
        RB24.setOnCheckedChangeListener(new Radio_check());
        score2 = getIntent().getExtras().getString("score");

    }


    public class Radio_check implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (RB21.isChecked()) {
                cnt2 =0;
            }
            if (RB22.isChecked()) {
                cnt2 = 0;
            }
            if (RB23.isChecked()) {
                cnt2 = 0;
            }
            if (RB24.isChecked()) {
                cnt2 = 1;
            }

        }
    }

    @Override
    public void onClick(View view) {


        if (cnt2 == 1) {
            {
                if (score2.equals("10"))
                    score2 = "20";
                if (score2.equals("0"))
                    score2 = "10";
                Toast.makeText(getApplicationContext(), "Correct Answer " , Toast.LENGTH_SHORT).show();
            }
        } else if (cnt2 == 0) {
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(this, fourth.class);
        i.putExtra("score2", score2);
        startActivity(i);
    }
}


