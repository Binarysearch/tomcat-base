package com.example.services.impl;

import com.example.services.ExampleService;

import org.piros.injection.Injectable;

@Injectable
public class ExampleServiceImpl implements ExampleService {
    
    public String getServiceData(String serviceInput){
        return "serviceInput:" + serviceInput;
    }
}