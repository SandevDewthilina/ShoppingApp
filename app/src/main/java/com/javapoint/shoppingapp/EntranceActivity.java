package com.javapoint.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class EntranceActivity extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);

        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);

        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);

        //sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();

        Button all_category_btn = findViewById(R.id.all_category_btn);

        all_category_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent allIntent = new Intent(EntranceActivity.this, CollectionActivity.class);
                startActivity(allIntent);

            }
        });

    }
}
