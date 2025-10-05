package org.axzarian.footballtestapp.core.exception;

public class EntityDoesNotExist extends RuntimeException {
    public EntityDoesNotExist(String message) {
        super(message);
    }
}
