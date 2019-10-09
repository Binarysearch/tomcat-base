package com.example.controllers;

import com.example.services.ExampleService;

import org.piros.injection.Controller;
import org.piros.injection.Injected;
import org.piros.servlet.ApiRequest;

public class ExampleController {

    @Injected
    private ExampleService exampleService;


    @Controller("/example")
    public ExampleDto test(ExampleRequestDto dto, ApiRequest request) {
        return new ExampleDto(dto.getName() + "-" + exampleService.getServiceData("someServiceInput"));
    }
}