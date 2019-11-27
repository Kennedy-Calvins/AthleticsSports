package com.example.athleticssports;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView mImaeView;
    TextView mAthleteName,mDes;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImaeView =itemView.findViewById(R.id.imageIv);
        this.mAthleteName = itemView.findViewById(R.id.athlete_name);
        this.mDes = itemView.findViewById(R.id.descriptionTV);
    }
}
