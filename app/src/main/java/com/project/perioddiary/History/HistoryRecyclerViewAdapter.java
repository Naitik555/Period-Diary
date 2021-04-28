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
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> color = new ArrayList<>();
    private ArrayList<String> bmi = new ArrayList<>();
    private ArrayList<String> stresslevel = new ArrayList<>();
    private ArrayList<String> flowlevel = new ArrayList<>();

    private Context mContext;

    public HistoryRecyclerViewAdapter(Context mContext, ArrayList<String> mPatientNames, ArrayList<String> date,ArrayList<String> color,ArrayList<String> bmi,ArrayList<String> stresslevel,ArrayList<String> flowlevel) {
        this.mPatientNames = mPatientNames;
        this.date = date;
        this.color = color;
        this.bmi = bmi;
        this.stresslevel = stresslevel;
        this.flowlevel = flowlevel;
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
        holder.date.setText(date.get(position));
        holder.color.setText(color.get(position));
        holder.bmi.setText(bmi.get(position));
        holder.stresslevel.setText(stresslevel.get(position));
        holder.flowlevel.setText(flowlevel.get(position));


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
        TextView date;
        TextView color;
        TextView bmi;
        TextView stresslevel;
        TextView flowlevel;
        LinearLayout history_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientname = itemView.findViewById(R.id.history1);
            date = itemView.findViewById(R.id.history2);
            color = itemView.findViewById(R.id.history3);
            bmi = itemView.findViewById(R.id.history4);
            stresslevel = itemView.findViewById(R.id.history5);
            flowlevel = itemView.findViewById(R.id.history6);
            history_layout = itemView.findViewById(R.id.history_layout);
        }
    }
}
