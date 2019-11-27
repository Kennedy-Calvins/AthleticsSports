package com.example.athleticssports;

public class TeamsRegistered {
    int id, photo;
    String name, athleteName, TeamName;

    public TeamsRegistered(int id, int photo, String name, String athleteName, String teamName) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.athleteName = athleteName;
        TeamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }
}
