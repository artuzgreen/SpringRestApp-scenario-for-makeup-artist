package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.support.exception.ActorNotFoundException;

import java.util.function.Supplier;

public class ActorExceptionSupplier {

    public static Supplier<ActorNotFoundException> actorNotFound(Long id) {
        return () -> new ActorNotFoundException(id);
    }
}
