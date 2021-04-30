package com.project.perioddiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project.perioddiary.RecyclerView.ReccyclerViewAdapter;

import java.util.ArrayList;

public class DoctorRecycler extends AppCompatActivity {

    private static final String TAG = "DoctorRecycler";

    private ArrayList<String> mNaames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> number = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorrecyclerview);

        initImageBitmaps();
    }

    private void initImageBitmaps()
    {
         mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/6/6e/Shah_Rukh_Khan_graces_the_launch_of_the_new_Santro.jpg");
         mNaames.add("ShahRukh Khan");
         number.add("+91 9999999999");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/8/86/Salman_Khan_at_Renault_Star_Guild_Awards.jpg");
        mNaames.add("Salman Khan");
        number.add("+91 8888888888");

        mImageUrls.add("https://m.media-amazon.com/images/M/MV5BODI4NDY1NzkyM15BMl5BanBnXkFtZTgwNzM3MDM0OTE@._V1_UY317_CR19,0,214,317_AL_.jpg");
        mNaames.add("Akshay Kumar");
        number.add("+91 7777777777");

        initRecyclerView();
    }
    private void initRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        ReccyclerViewAdapter adapter = new ReccyclerViewAdapter(this,mNaames,mImageUrls,number);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}