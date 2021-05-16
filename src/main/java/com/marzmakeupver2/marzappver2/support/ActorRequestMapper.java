package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.api.request.*;
import com.marzmakeupver2.marzappver2.domain.Actor;
import com.marzmakeupver2.marzappver2.domain.Styling;
import com.marzmakeupver2.marzappver2.service.ActorRequestService;
import org.springframework.stereotype.Component;

@Component
public class ActorRequestMapper {
    private final ActorRequestService actorRequestService;

    public ActorRequestMapper(ActorRequestService actorRequestService) {
        this.actorRequestService = actorRequestService;
    }

    public Actor toActorFromRequestOnlyWithId(StylingRequest stylingRequest) {
        Actor actor = actorRequestService.findForRequest(stylingRequest.getActorId());
        return actor;
    }

    public Actor toActorFromUpdateRequestOnlyWithId(UpdateStylingRequest updateStylingRequest) {
        Actor actor = actorRequestService.findForRequest(updateStylingRequest.getActorId());
        return actor;
    }

    public Long toActorIdToResponseOnly(Styling styling) {
        Actor actor = styling.getActorId();
        Long actorId = actorRequestService.findForResponse(actor.getId());
        return actorId;
    }

}


