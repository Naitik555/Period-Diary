package com.project.perioddiary.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.project.perioddiary.Question;
import com.project.perioddiary.R;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;

    TextView myDate;

    Button question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);
        question = findViewById(R.id.question);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                String date = (i1 + 1) + "/" + i2 + "/" + i;
                myDate.setText(date);

            }
        });

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CalendarActivity.this, Question.class);
                startActivity(intent);
            }
        });
    }
}