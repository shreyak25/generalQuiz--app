
package com.example.ap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Teamm extends AppCompatActivity {
    TextView TX1,TX2,TX3,TX4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamm);
        TX1=(TextView)findViewById(R.id.tv1);
        TX2=(TextView)findViewById(R.id.tv2);
        TX3=(TextView)findViewById(R.id.tv3);
        TX4=(TextView)findViewById(R.id.tv4);
        TX1.setText("This app is created by:");
        TX2.setText("1.SHREYA KUMAWAT");
        TX3.setText("2.NIDHI MITTAL");
        TX4.setText("3.ITIKA BHATTACHARJEE");
    }
}
