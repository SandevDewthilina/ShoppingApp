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

public class RegisterActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword1;
    private EditText mPassword2;
    private Button mLoginBtn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       /* toolbar = findViewById(R.id.register_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        mEmail = findViewById(R.id.register_email);
        mPassword1 = findViewById(R.id.register_password);
        mPassword2 = findViewById(R.id.register_password_confirm);
        mLoginBtn = findViewById(R.id.register_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString();
                String password = mPassword1.getText().toString();
                String password_confirm = mPassword2.getText().toString();

                register_account(email, password, password_confirm);

            }
        });

    }

    private void register_account (String email, String password, String password_confirm) {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(password_confirm)) {

            if (password.equals(password_confirm)) {

                if (password.length() >= 6) {

                    Intent categoriesIntent = new Intent(RegisterActivity.this, EntranceActivity.class);
                    startActivity(categoriesIntent);
                    finish();

                } else {

                    Toast.makeText(RegisterActivity.this, "Your password is not long enough", Toast.LENGTH_LONG).show();

                }
            } else {

                Toast.makeText(RegisterActivity.this, "The two passwords are not equal", Toast.LENGTH_LONG).show();

            }

        } else {

            Toast.makeText(RegisterActivity.this, "Complete your form and try again later", Toast.LENGTH_SHORT).show();

        }

    }
}
