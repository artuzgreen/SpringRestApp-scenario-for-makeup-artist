package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.support.exception.ScenarioNotFoundException;

import java.util.function.Supplier;

public class ScenarioExceptionSupplier {
    public static Supplier<ScenarioNotFoundException> scenarioNotFound(Long id) {
        return () -> new ScenarioNotFoundException(id);
    }
}
