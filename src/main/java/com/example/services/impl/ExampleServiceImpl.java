package com.example.services.impl;

import java.util.List;

import com.example.controllers.ExampleEntity;
import com.example.services.ExampleService;

import org.piros.injection.Injectable;
import org.piros.injection.Injected;
import org.piros.services.db.DatabaseService;

@Injectable
public class ExampleServiceImpl implements ExampleService {

    @Injected
    private DatabaseService ds;

    @Override
    public void create(String field1, Integer field2) {
        ds.insert(new ExampleEntity(field1, field2));
    }

    @Override
    public List<ExampleEntity> getAll() {
        return ds.execute("select * from example_table", ExampleEntity.class);
    }
    
}