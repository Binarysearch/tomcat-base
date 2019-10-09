package com.example.controllers;


public class ExampleRequestDto {

    private String name;

    public ExampleRequestDto() {
    }

    public ExampleRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}