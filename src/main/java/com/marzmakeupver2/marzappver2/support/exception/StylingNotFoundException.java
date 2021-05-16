package com.marzmakeupver2.marzappver2.support.exception;

public class StylingNotFoundException extends RuntimeException{

    public StylingNotFoundException(Long id) {
        super(String.format("Styling with id %d not found", id));
    }
}
