package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;

import com.epam.edu.spring.core.template.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        ApplicationContext applicationContext;
        applicationContext = context;
        applicationContext.getBean(ItemService.class);

        context.close();
    }
}
