package com.marzmakeupver2.marzappver2.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@IdClass(StylingId.class)
@Table(name = "stylings")

public class Styling {


    @Id
    @GeneratedValue
    @Column(name = "styling_id")
    private Long stylingId;

    @Id
//   The most common Parent – Child association consists of a one-to-many and a many-to-one relationship,
//   where the cascade being useful for the one-to-many side only:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", referencedColumnName = "id")
    private Actor actorId;

    @Column(name = "makeup")
    private String makeup;
    @Column(name = "sfx")
    private String sfx;
    @Column(name = "hair")
    private String hair;
    @Column(name = "img_dir")
    private String img_dir;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "scenarios_stylings",
            joinColumns = {
                    @JoinColumn(name = "styling_id", referencedColumnName = "styling_id"),
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "scenario_id")}
    )
    private Set<Scenario> scenariosList;

    public Styling() {
    }

    public Styling(Actor actorId, String makeup, String sfx, String hair, String img_dir, Set<Scenario> scenariosList) {
        this.actorId = actorId;
        this.makeup = makeup;
        this.sfx = sfx;
        this.hair = hair;
        this.img_dir = img_dir;
        this.scenariosList = scenariosList;
    }

    public Long getStylingId() {
        return stylingId;
    }

    public void setStylingId(Long stylingId) {
        this.stylingId = stylingId;
    }

    public Actor getActorId() {
        return actorId;
    }

    public void setActorId(Actor actorId) {
        this.actorId = actorId;
    }

    public String getMakeup() {
        return makeup;
    }

    public void setMakeup(String makeup) {
        this.makeup = makeup;
    }

    public String getSfx() {
        return sfx;
    }

    public void setSfx(String sfx) {
        this.sfx = sfx;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getImg_dir() {
        return img_dir;
    }

    public void setImg_dir(String img_dir) {
        this.img_dir = img_dir;
    }

    public Set<Scenario> getScenariosList() {
        return scenariosList;
    }

    public void setScenariosList(Set<Scenario> scenariosList) {
        this.scenariosList = scenariosList;
    }


}
