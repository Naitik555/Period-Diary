package com.project.perioddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class doctorpatient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorpatient);

        ImageView img = (ImageView) findViewById(R.id.doctor);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your code here
                Intent intent = new Intent(doctorpatient.this, doctorlogin.class);
                startActivity(intent);
            }
            });

            ImageView img1 = (ImageView) findViewById(R.id.patient);
        img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your code here
                Intent intent = new Intent(doctorpatient.this, patientlogin.class);
                startActivity(intent);
            }
        });


            }

}
