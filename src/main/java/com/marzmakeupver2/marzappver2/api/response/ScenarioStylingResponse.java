package com.marzmakeupver2.marzappver2.api.response;

import com.marzmakeupver2.marzappver2.domain.Styling;

public class ScenarioStylingResponse {
    private Long id;

    public ScenarioStylingResponse(Styling styling) {
        this.id = styling.getStylingId();
    }

    public Long getId() {
        return id;
    }
}
