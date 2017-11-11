package com.nanolaba.commons;

public class Objects {

    private Objects() {
    }

    public static boolean eq(Object a, Object b) {
        return a != null && b != null && a.equals(b) || a == null && b == null;
    }
}
