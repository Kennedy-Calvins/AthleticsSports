package com.example.athleticssports;

public class GenderDetails {
    int genderID;
    String GenderType;

    public GenderDetails(){}

    public GenderDetails(int genderID, String genderType) {
        this.genderID = genderID;
        GenderType = genderType;
    }

    public int getGenderID() {
        return genderID;
    }

    public void setGenderID(int genderID) {
        this.genderID = genderID;
    }

    public String getGenderType() {
        return GenderType;
    }

    public void setGenderType(String genderType) {
        GenderType = genderType;
    }
}
