package com.neptune.dive.errors;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(String exception) {
        super(exception);
    }
}
