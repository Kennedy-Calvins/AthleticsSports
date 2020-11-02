

package com.example.athleticssports;



public class TeamDetails {



    int TeamID;

    String TeamName;

    String TeamManager;

    String county;

    String category;

    String MarathonType;



    public TeamDetails(){

    }



    public TeamDetails(int teamID, String teamName, String teamManager, String county, String category, String marathonType) {

        TeamID = teamID;

        TeamName = teamName;

        TeamManager = teamManager;

        this.county = county;

        this.category = category;

        MarathonType = marathonType;

    }



    public int getTeamID() {

        return TeamID;

    }



    public void setTeamID(int teamID) {

        TeamID = teamID;

    }



    public String getTeamName() {

        return TeamName;

    }



    public void setTeamName(String teamName) {

        TeamName = teamName;

    }



    public String getTeamManager() {

        return TeamManager;

    }



    public void setTeamManager(String teamManager) {

        TeamManager = teamManager;

    }



    public String getCounty() {

        return county;

    }



    public void setCounty(String county) {

        this.county = county;

    }



    public String getCategory() {

        return category;

    }



    public void setCategory(String category) {

        this.category = category;

    }



    public String getMarathonType() {

        return MarathonType;

    }



    public void setMarathonType(String marathonType) {

        MarathonType = marathonType;

    }

}