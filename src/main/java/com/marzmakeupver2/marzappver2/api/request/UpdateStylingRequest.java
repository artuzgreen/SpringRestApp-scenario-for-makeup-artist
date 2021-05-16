package com.marzmakeupver2.marzappver2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Set;

public class UpdateStylingRequest extends StylingRequest {
    private final Long id;

    @JsonCreator
    public UpdateStylingRequest(Long actorId, String makeup, String sfx, String hair, String img_dir, Set<StylingScenarioRequest> scenariosList, Long id) {
        super(actorId, makeup, sfx, hair, img_dir, scenariosList);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
