package com.javapoint.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView previewImage;
    private TextView previewPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        toolbar = findViewById(R.id.preview_titlebar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Your Choice");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        previewImage = findViewById(R.id.preview_image);
        previewPrice = findViewById(R.id.preview_price);

        Intent intent = getIntent();

        previewPrice.setText(intent.getStringExtra("price"));
        previewImage.setImageResource(intent.getIntExtra("image", 0));

    }
}
