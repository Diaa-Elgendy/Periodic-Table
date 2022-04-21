package com.elgendy.periodictable2020;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class FeedbackActivity extends AppCompatActivity {

    private Switch myswitch;
    SharedPref sharedpref;
    Toolbar toolbar;
    EditText subject, message;
    Button buttonSend;
    Spinner spinner;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if(sharedpref.loadNightModeState())
            setTheme(R.style.DarkTheme);
        else  setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        subject = findViewById(R.id.editText2);
        message = findViewById(R.id.editText3);
        buttonSend = findViewById(R.id.btn_send);
        toolbar = findViewById(R.id.toolbar_feedback);
        spinner = findViewById(R.id.feedback_spinner);

        toolbar.setTitle("Feedback");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Found an issue");
        arrayList.add("Notifications");
        arrayList.add("Advertisement");
        arrayList.add("Design problem");
        arrayList.add("Recommend a new feature");
        arrayList.add("Other");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_color, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_color);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String subS= subject.getText().toString();
                String mesS= message.getText().toString();


                if (subS.isEmpty() || mesS.isEmpty()){
                    //Toast.makeText(getApplicationContext(),"Enter empty field",Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"diaawael77@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, subS);
                    email.putExtra(Intent.EXTRA_TEXT, mesS);

                    email.setType("Message/das56as");
                    startActivity(Intent.createChooser(email, "Choose app"));
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_simple,menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}