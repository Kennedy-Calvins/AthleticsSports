package com.example.athleticssports;

public class MarathonDetails {
    int marathonID;
    String MarathonType;

    public  MarathonDetails(){

    }

    public MarathonDetails(int marathonID, String marathonType) {
        this.marathonID = marathonID;
        MarathonType = marathonType;
    }

    public int getMarathonID() {
        return marathonID;
    }

    public void setMarathonID(int marathonID) {
        this.marathonID = marathonID;
    }

    public String getMarathonType() {
        return MarathonType;
    }

    public void setMarathonType(String marathonType) {
        MarathonType = marathonType;
    }
}
