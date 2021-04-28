package com.project.perioddiary.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.perioddiary.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>
{
    private static final String TAG = "ReccyclerViewAdapter";

    private ArrayList<String> mPatientNames = new ArrayList<>();
    private ArrayList<String> mPatient = new ArrayList<>();
    private Context mContext;

    public HistoryRecyclerViewAdapter(Context mContext, ArrayList<String> mPatientNames, ArrayList<String> mPatient) {
        this.mPatientNames = mPatientNames;
        this.mPatient = mPatient;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.patientname.setText(mPatientNames.get(position));
        holder.patient.setText(mPatient.get(position));

        holder.history_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext, mPatientNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPatientNames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView patientname;
        TextView patient;
        LinearLayout history_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientname = itemView.findViewById(R.id.history1);
            patient = itemView.findViewById(R.id.history2);
            history_layout = itemView.findViewById(R.id.history_layout);
        }
    }
}
