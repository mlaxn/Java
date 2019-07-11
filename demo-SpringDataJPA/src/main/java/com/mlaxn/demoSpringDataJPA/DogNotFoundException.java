package com.mlaxn.demoSpringDataJPA;

public class DogNotFoundException extends RuntimeException {
    public DogNotFoundException(String message) {
        super(message);
    }
}