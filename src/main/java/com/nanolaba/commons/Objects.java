package com.nanolaba.commons;

import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;

public class Objects {

    private Objects() {
    }

    public static boolean eq(Object a, Object b) {
        return a != null && b != null && a.equals(b) || a == null && b == null;
    }

    public static void set(Object object, String fieldName, Object fieldValue) {
        PropertyAccessor myAccessor = PropertyAccessorFactory.forBeanPropertyAccess(object);
        myAccessor.setPropertyValue(fieldName, fieldValue);
    }

    @SuppressWarnings("unchecked")
    public static <V> V get(Object object, String fieldName) {
        PropertyAccessor myAccessor = PropertyAccessorFactory.forBeanPropertyAccess(object);
        return (V) myAccessor.getPropertyValue(fieldName);
    }
}
