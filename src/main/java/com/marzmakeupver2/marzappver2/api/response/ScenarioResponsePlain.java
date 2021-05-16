package com.marzmakeupver2.marzappver2.api.response;


import java.util.Set;

public class ScenarioResponsePlain {
    private Long id;
    private int day;
    private String partOfADay;
    private String location;
    private String comment;
    private Set<ScenarioActorResponse> actorsList;
    private Set<ScenarioStylingResponse> stylingList;

    public ScenarioResponsePlain(Long id, int day, String partOfADay, String location, String comment, Set<ScenarioActorResponse> actorsList, Set<ScenarioStylingResponse> stylingList) {
        this.id = id;
        this.day = day;
        this.partOfADay = partOfADay;
        this.location = location;
        this.comment = comment;
        this.actorsList = actorsList;
        this.stylingList = stylingList;
    }

    public Long getId() {
        return id;
    }

    public int getDay() {
        return day;
    }

    public String getPartOfADay() {
        return partOfADay;
    }

    public String getLocation() {
        return location;
    }

    public String getComment() {
        return comment;
    }

    public Set<ScenarioActorResponse> getActorsList() {
        return actorsList;
    }

    public Set<ScenarioStylingResponse> getStylingList() {
        return stylingList;
    }
}
