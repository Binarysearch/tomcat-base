package com.example.controllers;


public class ExampleDto {

    private String field1;
    private Integer field2;

    public ExampleDto() {
    }

    public ExampleDto(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    
}