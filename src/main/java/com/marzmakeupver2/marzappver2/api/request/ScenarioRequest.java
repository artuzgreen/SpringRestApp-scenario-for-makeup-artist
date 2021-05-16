package com.marzmakeupver2.marzappver2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

public class ScenarioRequest {
    private final Long id;
    private final int day;
    private final String partOfADay;
    private final String location;
    private final String comment;
//  private final Set<ScenarioStylingRequest> stylingList;

    @JsonCreator
    public ScenarioRequest(Long id, int day, String partOfADay, String location, String comment) {
        this.id = id;
        this.day = day;
        this.partOfADay = partOfADay;
        this.location = location;
        this.comment = comment;
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


}