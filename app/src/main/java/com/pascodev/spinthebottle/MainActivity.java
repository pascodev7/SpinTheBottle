package com.pascodev.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.bottle);
    }

    public void spinTheBottle(View v){
        int newDir = random.nextInt(1800);
        float pivotX = bottle.getWidth()/2;
        float pivotY = bottle.getHeight()/2;

        Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);

        rotate.setDuration(2500);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                spinning = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                spinning = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //spinning = true;
            }
        });

        lastDir = newDir;
        bottle.startAnimation(rotate);
    }

}
