package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.support.exception.StylingNotFoundException;

import java.util.function.Supplier;

public class StylingExceptionSupplier {
    public static Supplier<StylingNotFoundException> stylingNotFound(Long id) {
        return () -> new StylingNotFoundException(id);
    }
}
