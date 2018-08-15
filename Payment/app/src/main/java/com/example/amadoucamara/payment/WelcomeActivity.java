package com.example.amadoucamara.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class WelcomeActivity extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        viewFlipper = this.findViewById(R.id.bckgrndViewFlipper);
        fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
//        TextView tx = (TextView)findViewById(R.id.textView2);
//        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/funkydori.ttf");
//        tx.setTypeface(custom_font);

        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.startFlipping();
    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }
}
