package com.marzmakeupver2.marzappver2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

public class StylingRequest {
    private final Long actorId;
    private final String makeup;
    private final String sfx;
    private final String hair;
    private final String img_dir;
    private final Set<StylingScenarioRequest> scenariosList;

    @JsonCreator
    public StylingRequest(Long actorId, String makeup, String sfx, String hair, String img_dir, Set<StylingScenarioRequest> scenariosList) {
        this.actorId = actorId;
        this.makeup = makeup;
        this.sfx = sfx;
        this.hair = hair;
        this.img_dir = img_dir;
        this.scenariosList = scenariosList;
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

    public Set<StylingScenarioRequest> getScenariosList() {
        return scenariosList;
    }
}
