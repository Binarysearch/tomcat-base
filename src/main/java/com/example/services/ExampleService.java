package com.example.services;

import java.util.List;

import com.example.controllers.ExampleEntity;

public interface ExampleService {

	public void create(String field1, Integer field2);

    public List<ExampleEntity> getAll();

}