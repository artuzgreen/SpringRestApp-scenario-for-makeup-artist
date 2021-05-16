package com.marzmakeupver2.marzappver2.api.response;

import com.marzmakeupver2.marzappver2.domain.Scenario;

public class StylingScenarioResponse {
    private Long id;
    private int day;

    public StylingScenarioResponse(Scenario scenario) {
        this.id = scenario.getId();
        this.day = scenario.getDay();
    }

    public Long getId() {
        return id;
    }

    public int getDay() {
        return day;
    }
}
