package com.example.controllers;


public class ExampleDto {

    private String data;

    public ExampleDto(String data) {
        this.setData(data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}