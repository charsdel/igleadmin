package com.example.igleadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import com.example.igleadmin.ui.login.*;

public class MainActivity extends Activity {

    private static  int SPLASH_SCREEN = 1000;

    Animation topAnim, bottomanim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks

        image = findViewById(R.id.image);
        logo = findViewById(R.id.logo);
        slogan = findViewById(R.id.slogan);



        image.setAnimation(topAnim);

        logo.setAnimation(bottomanim);
        slogan.setAnimation(bottomanim);




        //method 1 to create delay
        /*
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity((intent));
                finish();
            }
        };

        Timer tiempo = new Timer();

        tiempo.schedule(tarea, 1000);*/

        //method 2 to crate delay


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                //para hacer que la animacion del logo image y el logo texto hagan la trasicion con los elementos de login
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image, "logo_image");
                pairs[1] = new Pair<View,String>(logo, "logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent,options.toBundle());

                /* intent sin transiciones
                startActivity(intent);
                finish();*/
            }
        },SPLASH_SCREEN);





    }
}