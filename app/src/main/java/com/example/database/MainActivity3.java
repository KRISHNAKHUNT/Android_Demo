package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    public connection obj1=new connection(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void funstore(View view) {
        EditText v1=(EditText)findViewById(R.id.e1);
        EditText v2=(EditText)findViewById(R.id.e2);
        EditText v3=(EditText)findViewById(R.id.e3);
        String s1=v1.getText().toString();
        String s2=v2.getText().toString();
        Integer m=Integer.parseInt(v3.getText().toString());
        if((!s1.equals(""))&&(!s2.equals(""))){
            if(obj1.storedata(s1,s2,m)){
                Toast.makeText(this,"Data Added",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Data Error",Toast.LENGTH_LONG).show();
            }

        }
        else{
            Toast.makeText(this,"Fields can't be empty ",Toast.LENGTH_LONG).show();
        }
    }

    public void funget(View view) {
        TextView t1=(TextView)findViewById(R.id.t1);
        Cursor c1=obj1.fetchData();
        String str1="";
        if(c1 != null && c1.getCount()>1){
            c1.moveToFirst();
            do{
                String c2=c1.getString(0);
                String c3=c1.getString(1);
                String c4=c1.getString(2);
                String c5=c1.getString(3);
                str1 += c2+" "+c3+" "+c4+" "+c5+"\n";
            }while(c1.moveToNext());
            t1.setText(str1);
        }
        else{
            Toast.makeText(this,"Fetch Error",Toast.LENGTH_LONG).show();
        }
    }
}