package com.infoshare.reflections;

import com.infoshare.reflections.components.HelloWorldComponent;
import com.infoshare.reflections.components.PrintComponent;

import java.lang.reflect.Constructor;

public class SimpleIoc {

    public static void main(String[] args) throws Exception {
        Class<?> printComponentClass = Class.forName("com.infoshare.reflections.components.PrintComponent");
        PrintComponent printComponent = (PrintComponent) printComponentClass.getConstructor().newInstance();

        Class<?> helloWorldComponentClass = Class.forName("com.infoshare.reflections.components.HelloWorldComponent");
        Constructor<?> helloWorldComponentConstructor = helloWorldComponentClass.getConstructor(PrintComponent.class);
        HelloWorldComponent helloWorldComponent = (HelloWorldComponent) helloWorldComponentConstructor.newInstance(printComponent);
    }
}
