package com.project.perioddiary.DashBoard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.project.perioddiary.DoctorRecycler;
import com.project.perioddiary.R;
import com.project.perioddiary.patientindoctor.PatientRecycler;
import com.project.perioddiary.profile.DoctorProfile;

public class DoctorDash extends AppCompatActivity {

    ImageView patienthistory,profile;
    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dash);

        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);

        profile = (ImageView)findViewById(R.id.profile);
        patienthistory = (ImageView)findViewById(R.id.pateinthistory);

        patienthistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DoctorDash.this, PatientRecycler.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorDash.this, DoctorProfile.class);
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