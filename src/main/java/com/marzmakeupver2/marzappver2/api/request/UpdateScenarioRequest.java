package com.marzmakeupver2.marzappver2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UpdateScenarioRequest extends ScenarioRequest {

    @JsonCreator
    public UpdateScenarioRequest(Long id, int day, String partOfADay, String location, String comment) {
        super(id, day, partOfADay, location, comment);
    }
}
