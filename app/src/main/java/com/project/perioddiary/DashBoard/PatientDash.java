package com.project.perioddiary.DashBoard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.project.perioddiary.DoctorRecycler;
import com.project.perioddiary.History.HistoryRecycler;
import com.project.perioddiary.Question;
import com.project.perioddiary.R;
import com.project.perioddiary.calendar.CalendarActivity;
import com.project.perioddiary.profile.DoctorProfile;
import com.project.perioddiary.profile.PatientProfile;

public class PatientDash extends AppCompatActivity {

    ImageView calendar, doctorlist,question,history,profile;
    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dash);

        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);

        profile = findViewById(R.id.profile);
        calendar = findViewById(R.id.calendar);
        doctorlist = findViewById(R.id.doctorlist);
        question = findViewById(R.id.question);
        history = findViewById(R.id.history);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PatientDash.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        doctorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PatientDash.this, DoctorRecycler.class);
                startActivity(intent);
            }
        });

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PatientDash.this, Question.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientDash.this, PatientProfile.class);
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PatientDash.this, HistoryRecycler.class);
                startActivity(intent);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.logout:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}