package com.marzmakeupver2.marzappver2.support;


import com.marzmakeupver2.marzappver2.api.request.ScenarioRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateScenarioRequest;
import com.marzmakeupver2.marzappver2.api.response.*;
import com.marzmakeupver2.marzappver2.domain.Actor;
import com.marzmakeupver2.marzappver2.domain.Scenario;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ScenarioMapper {

    public ScenarioMapper() {
    }

    public Scenario toScenario(ScenarioRequest scenarioRequest) {
        return new Scenario(scenarioRequest.getId(), scenarioRequest.getDay(), scenarioRequest.getPartOfADay(), scenarioRequest.getLocation(),
                scenarioRequest.getComment());
    }

    public Scenario toScenario(Scenario scenario, UpdateScenarioRequest updateScenarioRequest) {
        scenario.setDay(updateScenarioRequest.getDay());
        scenario.setPartOfADay(updateScenarioRequest.getPartOfADay());
        scenario.setLocation(updateScenarioRequest.getLocation());
        scenario.setComment(updateScenarioRequest.getComment());
        return scenario;
    }


    public ScenarioResponsePlain toScenarioResponsePlain(Scenario scenario) {
        Set<Actor> actorFromStylingList;
        actorFromStylingList = scenario.getStylingsList().stream()
                .map(stylingWithActor -> stylingWithActor.getActorId()).collect(Collectors.toSet());

        Set<ScenarioActorResponse> scenarioActorResponseList;
        scenarioActorResponseList = actorFromStylingList.stream().map(ScenarioActorResponse::new).collect(Collectors.toSet());

        Set<ScenarioStylingResponse> scenarioStylingResponseList;
        scenarioStylingResponseList = scenario.getStylingsList().stream().map(ScenarioStylingResponse::new)
                .collect(Collectors.toSet());
        return new ScenarioResponsePlain(scenario.getId(), scenario.getDay(), scenario.getPartOfADay(), scenario.getLocation()
                , scenario.getComment(), scenarioActorResponseList, scenarioStylingResponseList);
    }
}
