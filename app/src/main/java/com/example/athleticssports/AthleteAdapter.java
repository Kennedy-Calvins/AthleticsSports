package com.example.athleticssports;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AthleteAdapter extends RecyclerView.Adapter<AthleteAdapter.AthleteViewHolder> {

    private ArrayList<Athlete> athleteList;
    private TextView tvAthleteName;
    private TextView tvAthleteDescription;
    private ImageView imageView;

    public class AthleteViewHolder extends RecyclerView.ViewHolder{
        public AthleteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAthleteName = (TextView)itemView.findViewById(R.id.athlete_name);
            tvAthleteDescription = (TextView)itemView.findViewById(R.id.descriptionTV);
            imageView = (ImageView) itemView.findViewById(R.id.athlete_photo);
        }

        public void bind(Athlete athlete){
            tvAthleteName.setText(athlete.getAthletename());
            tvAthleteDescription.setText(athlete.getPhoneNumber());
        }
    }

    public AthleteAdapter(ArrayList<Athlete> athleteArrayList){
        athleteList = athleteArrayList;
    }
    @NonNull
    @Override
    public AthleteAdapter.AthleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AthleteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AthleteAdapter.AthleteViewHolder holder, int position) {
        holder.bind(athleteList.get(position));

    }

    @Override
    public int getItemCount() {
        return athleteList.size();
    }
}
