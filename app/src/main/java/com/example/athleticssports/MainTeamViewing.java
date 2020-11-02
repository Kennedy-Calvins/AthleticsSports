//package com.example.athleticssports;
//
//import android.os.Bundle;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainTeamViewing extends AppCompatActivity implements itemClickListener {
//
//
//    String[] nameList = {"Mandera East","Makini Nairobi","Siaya nn","Kisumu central","Magadi team","Iten lexus","Mombasa nn"};
//    String[] TeamList = {"Sam Oyugi","Emmie Rose","Kenchase Gael","Clifford Odiwuor","Borny Adala","Alvin Onyango","Allan Musyoka"};
//
//    RecyclerView recyclerView;
//    TeamVersionAdapter teamVersionAdapter;
//    List<TeamDetails> teamVersionList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.mainteamviewing);
//
//        recyclerView = findViewById(R.id.recyclerViewTeams);
//
//
//        teamVersionAdapter = new TeamVersionAdapter(teamVersionList, MainTeamViewing.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(teamVersionAdapter);
//        teamVersionAdapter.setItemClickListener(this);
//
//        //filling the recycler view list
//        for (int i = 0; i<nameList.length; i ++){
//            String name = nameList [i];
//            String team = TeamList [i];
//
//            TeamDetails teamDetails = new TeamDetails(i,name,team);
//            teamVersionList.add(teamDetails);
//
//        }
//
//    }
//
//    @Override
//    void onClick(View view, int position) {
//        int id = teamVersionList.get(position).getTeamID();
//        String name = teamVersionList.get(position).getTeamName();
//
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
//
//    }
//}
