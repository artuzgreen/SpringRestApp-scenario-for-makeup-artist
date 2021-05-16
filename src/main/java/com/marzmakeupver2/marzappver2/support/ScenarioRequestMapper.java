package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.api.request.StylingScenarioRequest;
import com.marzmakeupver2.marzappver2.domain.Scenario;
import com.marzmakeupver2.marzappver2.service.ScenarioRequestService;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class  ScenarioRequestMapper {
    private final ScenarioRequestService scenarioRequestService;

    public ScenarioRequestMapper(ScenarioRequestService scenarioRequestService) {
        this.scenarioRequestService = scenarioRequestService;
    }

    public Set<Scenario> toScenariosFromStylingRequestOnlyWithId (Set<StylingScenarioRequest> stylingScenarioRequestsList){
        Set<Scenario> scenarios = stylingScenarioRequestsList.stream()
                .map(stySceRequest -> scenarioRequestService.findForRequest(stySceRequest.getId()))
                .collect(Collectors.toSet());
        return scenarios;
    }
}
