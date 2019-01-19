package com.infoshare.reflections.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldComponent {

    private final PrintComponent printComponent;

    @Autowired
    public HelloWorldComponent(PrintComponent printComponent) {
        this.printComponent = printComponent;
        System.out.println("Hello world");
    }
}
