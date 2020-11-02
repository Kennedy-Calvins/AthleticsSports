package com.example.athleticssports;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class AthleteDetails {

    int athleteID;
    String Imageid;
    String athleteName;
    String athleteTeam;
    String county;
    Long athletePhoneNo;


    public AthleteDetails(){

    }

    public AthleteDetails(int athleteID, String Imageid, String athleteName, Long athletePhoneNo) {
        this.athleteID = athleteID;
        this.Imageid = Imageid;
        this.athleteName = athleteName;
        this.athletePhoneNo = athletePhoneNo;
    }

    public int getAthleteID() {
        return athleteID;
    }

    public void setAthleteID(int athleteID) {
        this.athleteID = athleteID;
    }

    public String getImageid() {
        return Imageid;
    }

    public void setImageid(String imageid) {
        Imageid = imageid;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int getAthletePhoneNo() {
        return Math.toIntExact(athletePhoneNo);
    }

    public void setAthletePhoneNo(Long athletePhoneNo) {
        this.athletePhoneNo = athletePhoneNo;
    }
}
