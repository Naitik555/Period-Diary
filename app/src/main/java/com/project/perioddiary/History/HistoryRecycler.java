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

    private ArrayList<String> mPatientNames = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> color = new ArrayList<>();
    private ArrayList<String> bmi = new ArrayList<>();
    private ArrayList<String> stresslevel = new ArrayList<>();
    private ArrayList<String> flowlevel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_recyclerview);

        initImageBitmaps();
    }

    private void initImageBitmaps()
    {
        mPatientNames.add("ABCDEFGH");
        date.add("123456");
        color.add("abcd");
        bmi.add("123");
        stresslevel.add("abcd");
        flowlevel.add("abcd");

        mPatientNames.add("XYZWERAFD");
        date.add("1987654");
        color.add("qwert");
        bmi.add("456");
        stresslevel.add("qwer");
        flowlevel.add("qwer");

        initRecyclerView();
    }
    private void initRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        HistoryRecyclerViewAdapter adapter = new HistoryRecyclerViewAdapter(this,mPatientNames, date,color,bmi,stresslevel,flowlevel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}