package com.marzmakeupver2.marzappver2.support.exception;

public class ActorNotFoundException extends RuntimeException{
    public ActorNotFoundException(Long id) {
        super(String.format("Actor with id %d not found", id));
    }
}
