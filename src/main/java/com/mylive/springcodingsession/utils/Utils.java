package com.mylive.springcodingsession.utils;

import java.lang.reflect.Field;

public class Utils {

    private Utils(){}

    public static void updateNonNullProperties(Object source, Object target) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        for (Field sourceField : sourceClass.getDeclaredFields()) {
            try {
                sourceField.setAccessible(true);
                Object value = sourceField.get(source);
                if (value != null) {
                    Field targetField = targetClass.getDeclaredField(sourceField.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
