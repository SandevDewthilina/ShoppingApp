package com.javapoint.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startLoginBtn;
    private Button startRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       startLoginBtn = findViewById(R.id.start_login_btn);
       startRegisterBtn = findViewById(R.id.start_register_btn);

       startLoginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
               startActivity(loginIntent);

           }
       });

       startRegisterBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
               startActivity(registerIntent);

           }
       });

    }
}
