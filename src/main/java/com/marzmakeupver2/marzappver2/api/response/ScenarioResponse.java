package com.marzmakeupver2.marzappver2.api.response;


import com.marzmakeupver2.marzappver2.domain.Styling;

import java.util.Set;

public class ScenarioResponse {
    private Long id;
    private int day;
    private String partOfADay;
    private String location;
    private String comment;
    private Set<Styling> stylingList;

    public ScenarioResponse(Long id, int day, String partOfADay, String location, String comment, Set<Styling> stylingList) {
        this.id = id;
        this.day = day;
        this.partOfADay = partOfADay;
        this.location = location;
        this.comment = comment;
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

    public Set<Styling> getStylingList() {
        return stylingList;
    }
}
