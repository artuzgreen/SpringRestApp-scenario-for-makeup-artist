package com.marzmakeupver2.marzappver2.api.response;

import com.marzmakeupver2.marzappver2.domain.Actor;


public class ScenarioActorResponse {

    private Long id;
    private String character;


    public ScenarioActorResponse(Actor actor) {

        this.id = actor.getId();
        this.character = actor.getCharacter();
    }

    public Long getId() {
        return id;
    }

    public String getCharacter() {
        return character;
    }
}


