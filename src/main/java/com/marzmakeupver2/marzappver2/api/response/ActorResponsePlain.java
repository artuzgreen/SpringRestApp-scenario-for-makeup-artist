package com.marzmakeupver2.marzappver2.api.response;


import java.util.Set;

public class ActorResponsePlain {
    private Long id;
    private String name;
    private String surname;
    private String character;
//  private Set<ActorScenarioResponse> scenarioList;


    public ActorResponsePlain(Long id, String name, String surname, String character) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.character = character;
    }

    public Long getId() {
        return id;
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
