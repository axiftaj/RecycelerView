package com.example.recuclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //geting data from adapter
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toast.makeText(this, "name : " +name , Toast.LENGTH_SHORT).show();
    }
}
