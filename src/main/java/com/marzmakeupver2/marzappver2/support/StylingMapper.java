package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.api.request.StylingRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateStylingRequest;
import com.marzmakeupver2.marzappver2.api.response.StylingResponsePlain;
import com.marzmakeupver2.marzappver2.api.response.StylingScenarioResponse;
import com.marzmakeupver2.marzappver2.domain.Styling;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StylingMapper {
    private final ActorRequestMapper actorRequestMapper;
    private final ScenarioRequestMapper scenarioRequestMapper;

    public StylingMapper(ActorRequestMapper actorRequestMapper, ScenarioRequestMapper scenarioRequestMapper) {
        this.actorRequestMapper = actorRequestMapper;
        this.scenarioRequestMapper = scenarioRequestMapper;
    }

    public Styling toStyling(StylingRequest stylingRequest) {
        return new Styling(actorRequestMapper.toActorFromRequestOnlyWithId(stylingRequest), stylingRequest.getMakeup(), stylingRequest.getSfx(),
                stylingRequest.getHair(), stylingRequest.getImg_dir(), scenarioRequestMapper.toScenariosFromStylingRequestOnlyWithId(stylingRequest.getScenariosList()));
    }

    public Styling toStyling(Styling styling, UpdateStylingRequest updateStylingRequest) {
        styling.setActorId(actorRequestMapper.toActorFromUpdateRequestOnlyWithId(updateStylingRequest));
        styling.setMakeup(updateStylingRequest.getMakeup());
        styling.setSfx(updateStylingRequest.getSfx());
        styling.setHair(updateStylingRequest.getHair());
        styling.setImg_dir(updateStylingRequest.getImg_dir());
        styling.setScenariosList(scenarioRequestMapper.toScenariosFromStylingRequestOnlyWithId(updateStylingRequest.getScenariosList()));
        return styling;
    }

    public StylingResponsePlain toStylingResponsePlain(Styling styling) {
        Set<StylingScenarioResponse> stylingScenarioResponseSet;
        stylingScenarioResponseSet = styling.getScenariosList().stream().map(StylingScenarioResponse::new).collect(Collectors.toSet());
        return new StylingResponsePlain(styling.getStylingId(), actorRequestMapper.toActorIdToResponseOnly(styling), styling.getMakeup(), styling.getSfx(),
                styling.getHair(), styling.getImg_dir(), stylingScenarioResponseSet);
    }
}
