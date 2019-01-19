package com.infoshare.reflections;

import com.infoshare.reflections.utils.IocUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedIoc {

    public static void main(String[] args) throws Exception {
        List<Class> classes = IocUtils.findClassesInPackage("com.infoshare.reflections.components");

        List<Class> myComponents = classes.stream()
                                          .filter(clazz -> {
                                              for (Annotation annotation : clazz.getAnnotations()) {
                                                  if(annotation.annotationType().equals(MyComponent.class)) {
                                                      return true;
                                                  }
                                              }
                                              return false;
                                          })
                                          .collect(Collectors.toList());

        Class printComponentClass = IocUtils.findBeansWithConstructorCount(myComponents, 0);
        Class helloWorldComponentClass = IocUtils.findBeansWithConstructorCount(myComponents, 1);

        Object printComponent = printComponentClass.getConstructors()[0].newInstance();
        Object helloWorldComponent = helloWorldComponentClass.getConstructors()[0].newInstance(printComponent);

    }
}
