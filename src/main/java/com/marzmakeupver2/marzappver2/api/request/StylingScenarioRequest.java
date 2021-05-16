package com.marzmakeupver2.marzappver2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class StylingScenarioRequest {
    private final Long id;

    @JsonCreator
    public StylingScenarioRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
