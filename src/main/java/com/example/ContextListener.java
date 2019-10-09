package com.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.piros.injection.Injector;
import org.piros.injection.ControllerManager;
import org.piros.services.RequestProcessorService;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Injector.init("com.example.services");

        RequestProcessorService rpService = Injector.get(RequestProcessorService.class);
        
        ControllerManager.scanControllers("com.example.controllers", rpService);

        System.out.println("-----------     CONTEXTO INICIALIZADO     --------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener.contextDestroyed()");
    }

}
