package com.marzmakeupver2.marzappver2.support.exception;

public class ScenarioNotFoundException extends RuntimeException{

    public ScenarioNotFoundException(Long id) {
        super(String.format("Scenario with id %d not found", id));
    }
}
