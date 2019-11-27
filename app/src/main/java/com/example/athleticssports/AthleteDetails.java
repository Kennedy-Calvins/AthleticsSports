package com.example.athleticssports;

public class AthleteDetails {

    int athleteID;
    String athleteName;
    String athleteTeam;
    String county;
    Long athletePhoneNo;


    public AthleteDetails(){

    }

    public AthleteDetails(int athleteID, String athleteName, Long athletePhoneNo) {
        this.athleteID = athleteID;
        this.athleteName = athleteName;
        this.athletePhoneNo = athletePhoneNo;
    }

    public int getAthleteID() {
        return athleteID;
    }

    public void setAthleteID(int athleteID) {
        this.athleteID = athleteID;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getAthleteTeam() {
        return athleteTeam;
    }

//    public void setAthleteTeam(String athleteTeam) {
//        this.athleteTeam = athleteTeam;
//    }

//    public String getCounty() {
//        return county;
//    }
//
//    public void setCounty(String county) {
//        this.county = county;
//    }

    public Long getAthletePhoneNo() {
        return athletePhoneNo;
    }

    public void setAthletePhoneNo(Long athletePhoneNo) {
        this.athletePhoneNo = athletePhoneNo;
    }
}
