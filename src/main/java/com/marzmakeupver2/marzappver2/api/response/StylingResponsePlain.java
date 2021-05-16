package com.marzmakeupver2.marzappver2.api.response;


import java.util.Set;

public class StylingResponsePlain {
    private Long id;
    //  private StylingActorResponse actorId;
    private Long actorId;
    private String makeup;
    private String sfx;
    private String hair;
    private String img_dir;
    private Set<StylingScenarioResponse> scenariosList;

    public StylingResponsePlain(Long id, Long actorId, String makeup, String sfx, String hair, String img_dir, Set<StylingScenarioResponse> scenariosList) {
        this.id = id;
        this.actorId = actorId;
        this.makeup = makeup;
        this.sfx = sfx;
        this.hair = hair;
        this.img_dir = img_dir;
        this.scenariosList = scenariosList;
    }

    public Long getId() {
        return id;
    }

    public Long getActorId() {
        return actorId;
    }

    public String getMakeup() {
        return makeup;
    }

    public String getSfx() {
        return sfx;
    }

    public String getHair() {
        return hair;
    }

    public String getImg_dir() {
        return img_dir;
    }

    public Set<StylingScenarioResponse> getScenariosList() {
        return scenariosList;
    }
}
