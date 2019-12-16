package com.javapoint.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private Button mLoginBtn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /* toolbar = findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);
        mLoginBtn = findViewById(R.id.login_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                login_account(email, password);

            }
        });

    }

    private void login_account (String email, String password) {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

            if (password.length() >= 6) {

                Intent categoriesIntent = new Intent(LoginActivity.this, EntranceActivity.class);
                startActivity(categoriesIntent);
                finish();

            } else {

                Toast.makeText(LoginActivity.this, "Your password is not long enough", Toast.LENGTH_LONG).show();

            }

        } else {

            Toast.makeText(LoginActivity.this, "Complete your form and try again later", Toast.LENGTH_SHORT).show();

        }

    }
}
