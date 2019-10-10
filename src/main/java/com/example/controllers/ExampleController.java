package com.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.services.ExampleService;

import org.piros.injection.Controller;
import org.piros.injection.Injected;
import org.piros.servlet.ApiRequest;

public class ExampleController {

    @Injected
    private ExampleService exampleService;


    @Controller("/example")
    public List<ExampleDto> test(ExampleRequestDto dto, ApiRequest request) {

        exampleService.create(dto.getField1(), dto.getField2());

        return exampleService.getAll().stream().map(
            e -> new ExampleDto(e.getField1(), e.getField2())
        ).collect(Collectors.toList());
        
    }
}