package com.example.athleticssports;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {

    ArrayList<AthleteDetails> list;
    public AdapterClass(ArrayList<AthleteDetails> list){

        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder, viewGroup, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.a_name.setText(list.get(position).getAthleteName());
        myViewHolder.a_phone.setText(list.get(position).getAthletePhoneNo());


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView a_name, a_phone;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            a_name = itemView.findViewById(R.id.athlete_name);
            a_phone = itemView.findViewById(R.id.athlete_phone_no);

        }
    }

}
