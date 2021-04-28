package com.project.perioddiary.History;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.perioddiary.R;
import com.project.perioddiary.RecyclerView.ReccyclerViewAdapter;

import java.util.ArrayList;

public class HistoryRecycler extends AppCompatActivity {

    private static final String TAG = "HistoryRecycler";

    private ArrayList<String> mPatient = new ArrayList<>();
    private ArrayList<String> mPatientNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_recyclerview);

        initImageBitmaps();
    }

    private void initImageBitmaps()
    {
        mPatientNames.add("123456");
        mPatient.add("ABCDEFGH");

        mPatientNames.add("178932654");
        mPatient.add("QWERTYUIOP");

        mPatientNames.add("129873654");
        mPatient.add("ZXCVBNM");

        initRecyclerView();
    }
    private void initRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        HistoryRecyclerViewAdapter adapter = new HistoryRecyclerViewAdapter(this,mPatient,mPatientNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}