//package com.example.athleticssports;
//
//import android.content.ClipData;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class TeamVersionAdapter extends RecyclerView.Adapter<TeamVersionAdapter.TeamVersionViewHolder> {
//
//    private List<TeamDetails> teamVersionList;
//    private Context context;
//    private itemClickListener ItemClickListener;
//
//    public TeamVersionAdapter(List<TeamDetails> teamVersionList, Context context){
//        this.teamVersionList = teamVersionList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//
//    public TeamVersionAdapter.TeamVersionViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i){
//        View itemView = LayoutInflater.from(context).inflate(R.layout.viewteamdetails, viewGroup, false);
//        return new TeamVersionAdapter.TeamVersionViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder (TeamVersionAdapter.TeamVersionViewHolder holder, int position){
//        holder.teamIcon.setImageResource(teamVersionList.get(position).getLogoID());
//        holder.teamName.setText(teamVersionList.get(position).getTeamName());
//        holder.teamManager.setText(teamVersionList.get(position).getTeamManager());
//    }
//
//    @Override
//    public int getItemCount(){
//        return teamVersionList.size();
//    }
//
//    public void setItemClickListener(itemClickListener ItemClickListener){
//        this.ItemClickListener = ItemClickListener;
//    }
//
//
//    public class TeamVersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        ImageView teamIcon;
//        TextView teamName, teamManager;
//
//
//        public TeamVersionViewHolder(View view){
//            super(view);
//            teamIcon = view.findViewById(R.id.teamIcon);
//            teamName = view.findViewById(R.id.team_name);
//            teamManager = view.findViewById(R.id.team_manager);
//        }
//
//        @Override
//        public void onClick(View view){
//            if(ItemClickListener !=null){
//                ItemClickListener.onClick(view, getAdapterPosition());
//
//            }
//        }
//    }
//}
