package com.elgendy.periodictable2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SettingActivity extends AppCompatActivity {

    private Switch myswitch;
    SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.DarkTheme);
        }
        else  setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar=findViewById(R.id.toolbar_setting);
        toolbar.setTitle("Setting");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myswitch = findViewById(R.id.myswitch);
        if (sharedpref.loadNightModeState()) {
            myswitch.setChecked(true);
        }

        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedpref.setNightModeState(true);
                    restartApp();
                } else {
                    sharedpref.setNightModeState(false);
                    restartApp();
                }
            }
        });


    }
    public void restartApp() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        //overridePendingTransition(R.anim.fade_in,R.anim.fade_in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_simple,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}