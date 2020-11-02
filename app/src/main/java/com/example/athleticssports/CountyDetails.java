package com.example.athleticssports;

public class CountyDetails {
    int countyID;
    String CountyName;

    public CountyDetails(){

    }

    public CountyDetails(int countyID, String countyName) {
        this.countyID = countyID;
        CountyName = countyName;
    }

    public int getCountyID() {
        return countyID;
    }

    public void setCountyID(int countyID) {
        this.countyID = countyID;
    }

    public String getCountyName() {
        return CountyName;
    }

    public void setCountyName(String countyName) {
        CountyName = countyName;
    }
}
