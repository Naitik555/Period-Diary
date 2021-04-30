package com.project.perioddiary.patientindoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.perioddiary.R;
import com.project.perioddiary.RecyclerView.ReccyclerViewAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class patientrecyclerviewadapter extends RecyclerView.Adapter<patientrecyclerviewadapter.ViewHolder> {
    private static final String TAG = "ReccyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    //private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public patientrecyclerviewadapter(Context mContext, ArrayList<String> mImageNames) {
        this.mImageNames = mImageNames;
      //  this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public patientrecyclerviewadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        patientrecyclerviewadapter.ViewHolder holder = new patientrecyclerviewadapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull patientrecyclerviewadapter.ViewHolder holder, int position) {

       // Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.image);

        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
