package com.example.ap2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView t1,t2,t3;
    EditText e1;
    RadioGroup rg;
    RadioButton r1,r2,r3;
    Spinner s1;
    Button b1,viewall, enter;
    LinearLayout ll1;
    String s;
    FDatabase myDb;
    int id=1;
    String yr;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        if (menuItem.getItemId()==R.id.i1)
        {
            Toast.makeText(this,"Rules SELECTED",Toast.LENGTH_LONG).show();
            Intent  i=new Intent(this,Rules.class);
            startActivity(i);
            return true;
        }
        if(menuItem.getItemId()==R.id.i2)
        {
            Toast.makeText(this,"Creators SELECTED",Toast.LENGTH_LONG).show();
            Intent  i2=new Intent(this,Teamm.class);
            startActivity(i2);
            return true;
        }

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.tv1);
        t2 = (TextView) findViewById(R.id.tv2);
        t3 = (TextView) findViewById(R.id.tv3);
        e1 = (EditText) findViewById(R.id.et1);
        rg = (RadioGroup) findViewById(R.id.rg1);
        r1 = (RadioButton) findViewById(R.id.rb1);
        r2 = (RadioButton) findViewById(R.id.rb2);
        r3 = (RadioButton) findViewById(R.id.rb3);
        s1 = (Spinner) findViewById(R.id.sp1);
        b1 = (Button) findViewById(R.id.bt1);
        ll1 = (LinearLayout) findViewById(R.id.l1);
        b1.setOnClickListener(this);
        viewall = (Button) findViewById(R.id.viewd);
        viewall.setOnClickListener(this);
        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);
        ArrayAdapter ad = ArrayAdapter.createFromResource(this, R.array.Course, android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(ad);
        s1.setOnItemSelectedListener(this);
        myDb = new FDatabase(this);
        AddData();
        viewAll();
        r1.setOnCheckedChangeListener(new Radio_check());
        r2.setOnCheckedChangeListener(new Radio_check());
        r3.setOnCheckedChangeListener(new Radio_check());

    }
    public class Radio_check implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (r1.isChecked()) {
                yr="1";
            }
            if (r2.isChecked()) {
                yr="2";
            }
            if (r3.isChecked()) {
                yr="3";
            }

        }
    }

    public void AddData()
    {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted= (boolean) myDb.insertData(id,e1.getText().toString(),yr,s);
                id++;
                if(isInserted)
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void viewAll()
    {
        viewall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res=myDb.getAllData();
                        if(res.getCount()==0)
                        {
                            //show some message
                            showMessage("Error","No data found");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext())
                        {
                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("NAME :" + res.getString(1) + "\n");
                            buffer.append("YEAR :" + res.getString(2) + "\n");
                            buffer.append("COURSE :" + res.getString(3) + "\n\n");

                            //show aa data
                            showMessage("data", buffer.toString());
                        }
                    }
                }
        );
    }

    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public void onClick(View view) {
        Intent i=new Intent(this,second.class );
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(i==0)
        {
            s= adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();


        }
        if(i==1)
        {
            s= adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

        }
        if(i==2)
        {
            s= adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

        }
        if(i==3)
        {
            s= adapterView.getItemAtPosition(i).toString();
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
