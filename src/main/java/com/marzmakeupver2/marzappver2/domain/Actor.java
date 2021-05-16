package com.marzmakeupver2.marzappver2.domain;

import javax.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "movieCharacter")
    private String character;


    public Actor() {
    }

    public Actor(String name, String surname, String character) {
        this.name = name;
        this.surname = surname;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

}