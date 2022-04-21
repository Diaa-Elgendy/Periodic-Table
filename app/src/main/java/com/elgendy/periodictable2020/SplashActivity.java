package com.elgendy.periodictable2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private ImageView mv;
    SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()) {
            setTheme(R.style.DarkTheme);
        } else
            setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        mv = findViewById(R.id.splashLogo);
        if(sharedpref.loadNightModeState()) {
            mv.setImageResource(R.drawable.atom_dark);

        }
        else
            mv.setImageResource(R.drawable.atom_min);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_transition);
        mv.startAnimation(animation);
        final Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(1500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
