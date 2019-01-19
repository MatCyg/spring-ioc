package com.infoshare.reflections.components;

import org.springframework.stereotype.Component;

@Component
public class PrintComponent {

    public PrintComponent() {
        System.out.println("Print component");
    }
}
