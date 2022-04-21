package com.elgendy.periodictable2020;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    SharedPref sharedpref;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.DarkTheme);
        }
        else  setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        toolbar = findViewById(R.id.toolbar_about);
        toolbar.setTitle("About");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_simple,menu);
        return true;
    }

    public void OnContactUs(View view) {
        Intent contactUs= new Intent(getApplicationContext(),FeedbackActivity.class);
        startActivity(contactUs);
    }

    public void OnFacebook(View view) {
        Intent facebook= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/diaa.elgendy.5"));
        startActivity(facebook);
    }

    public void OnInstagram(View view) {
        Intent instagram= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/diaa.elgendy.5"));
        startActivity(instagram);
    }

    public void OnPlayStore(View view) {
        Intent playStore= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/diaa.elgendy.5"));
        startActivity(playStore);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}