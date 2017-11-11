package com.nanolaba.commons;

public class ObjectUtils {

    private ObjectUtils() {
    }

    public static boolean eq(Object a, Object b) {
        return a != null && b != null && a.equals(b) || a == null && b == null;
    }
}
