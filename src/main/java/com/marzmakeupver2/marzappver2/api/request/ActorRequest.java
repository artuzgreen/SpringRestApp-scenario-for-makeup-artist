package com.marzmakeupver2.marzappver2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ActorRequest {
    private final String name;
    private final String surname;
    private final String character;


    @JsonCreator
    public ActorRequest(String name, String surname, String character) {
        this.name = name;
        this.surname = surname;
        this.character = character;

    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public String getCharacter() {

        return character;
    }


}
