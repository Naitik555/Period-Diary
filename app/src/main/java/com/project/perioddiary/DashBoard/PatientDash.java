package com.project.perioddiary.DashBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.perioddiary.DoctorRecycler;
import com.project.perioddiary.Question;
import com.project.perioddiary.R;
import com.project.perioddiary.calendar.CalendarActivity;

public class PatientDash extends AppCompatActivity {

    ImageView calendar, doctorlist,question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dash);

        calendar = findViewById(R.id.calendar);
        doctorlist = findViewById(R.id.doctorlist);
        question = findViewById(R.id.question);

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
    }
}