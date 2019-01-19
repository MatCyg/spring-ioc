package com.infoshare.reflections.utils;


import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class IocUtils {

    /*
     * finds all classes with a constructor with specified number of parameters
     */
    public static Class findBeansWithConstructorCount(List<Class> myComponents, int constructorParametersCount) {
        return myComponents.stream()
                           .filter(clazz -> clazz.getConstructors()[0].getParameterCount() == constructorParametersCount)
                           .findFirst()
                           .get();
    }

    /*
     * finds all classes in a given package name, i.e. com.example.reflection.component
     */
    public static List<Class> findClassesInPackage(String packageName) throws IOException {
        return ClassPath.from(IocUtils.class.getClassLoader())
                        .getTopLevelClasses(packageName)
                        .stream()
                        .map(ClassPath.ClassInfo::load)
                        .collect(Collectors.toList());
    }

}