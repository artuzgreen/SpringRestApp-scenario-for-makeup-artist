package com.marzmakeupver2.marzappver2.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "scenarios")
public class Scenario {

    @Id
    @Column(name = "scenarioId")
    private Long id;
    @Column(name = "day")
    private int day;
    @Column(name = "partOfADay")
    private String partOfADay;
    @Column(name = "location")
    private String location;
    @Column(name = "comment")
    private String comment;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "scenarios_stylings",
            joinColumns = {@JoinColumn(name = "scenario_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "styling_id", referencedColumnName = "styling_id"),
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")})
    private Set<Styling> stylingsList;

    public Scenario() {
    }

    public Scenario(Long id) {
        this.id = id;
    }

    public Scenario(int day, String partOfADay, String location, String comment, Set<Styling> stylingsList) {
        this.day = day;
        this.partOfADay = partOfADay;
        this.location = location;
        this.comment = comment;
        this.stylingsList = stylingsList;
    }

    public Scenario(Long id, int day, String partOfADay, String location, String comment) {
        this.id = id;
        this.day = day;
        this.partOfADay = partOfADay;
        this.location = location;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getPartOfADay() {
        return partOfADay;
    }

    public void setPartOfADay(String partOfADay) {
        this.partOfADay = partOfADay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Styling> getStylingsList() {
        return stylingsList;
    }

    public void setStylingsList(Set<Styling> stylingsList) {
        this.stylingsList = stylingsList;
    }
}
