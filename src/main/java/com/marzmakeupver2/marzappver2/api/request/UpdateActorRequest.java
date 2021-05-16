package com.marzmakeupver2.marzappver2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UpdateActorRequest extends ActorRequest {
    private final Long id;

    @JsonCreator
    public UpdateActorRequest(String name, String surname, String character, Long id) {
        super(name, surname, character);
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
