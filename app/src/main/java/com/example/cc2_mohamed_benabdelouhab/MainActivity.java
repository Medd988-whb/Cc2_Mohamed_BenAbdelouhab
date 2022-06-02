package com.example.cc2_mohamed_benabdelouhab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.b1: i=new Intent(MainActivity.this, add_entr.class); break;
            case R.id.b2: i=new Intent(MainActivity.this, Edit_Entr.class); break;
            case R.id.b3: i=new Intent(MainActivity.this, List_Entr.class); break;
        }
        startActivity(i);
    }
}