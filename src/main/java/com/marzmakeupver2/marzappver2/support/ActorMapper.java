package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.api.request.ActorRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateActorRequest;
import com.marzmakeupver2.marzappver2.api.response.ActorResponsePlain;
import com.marzmakeupver2.marzappver2.domain.Actor;
import org.springframework.stereotype.Component;


@Component
public class ActorMapper {

    public ActorMapper() {
    }

    public Actor toActor(ActorRequest actorRequest) {
        return new Actor(actorRequest.getName(), actorRequest.getSurname(), actorRequest.getCharacter());
    }

    public Actor toActor(Actor actor, UpdateActorRequest updateActorRequest) {
        actor.setName(updateActorRequest.getName());
        actor.setSurname(updateActorRequest.getSurname());
        actor.setCharacter(updateActorRequest.getCharacter());
        return actor;
    }


    public ActorResponsePlain toActorResponsePlain(Actor actor) {
        return new ActorResponsePlain(actor.getId(), actor.getName(), actor.getSurname(), actor.getCharacter());
    }


}
