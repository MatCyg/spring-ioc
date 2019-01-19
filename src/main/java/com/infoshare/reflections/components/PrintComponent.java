package com.infoshare.reflections.components;

import com.infoshare.reflections.MyComponent;
import org.springframework.stereotype.Component;

@Component
@MyComponent
public class PrintComponent {

    public PrintComponent() {
        System.out.println("Print component");
    }
}
