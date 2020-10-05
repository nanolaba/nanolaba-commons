package com.nanolaba.commons;

import java.util.function.Supplier;

public class Code {

    private Code() {
    }

    public static <T> T ifNull(T t, T defaultObject) {
        return t == null ? defaultObject : t;
    }

    public static <T> T ifNull(T t, Supplier<T> defaultObject) {
        return t == null ? defaultObject.get() : t;
    }

    public static void run(CodeAction runnable) {
        try {
            runnable.run();
        } catch (Exception t) {
            throw new RuntimeException(t);
        }
    }

    public static <T> T run(CodeSupplier<T> runnable) {
        try {
            return runnable.get();
        } catch (Exception t) {
            throw new RuntimeException(t);
        }
    }

    public static void runQuietly(CodeAction runnable) {
        try {
            runnable.run();
        } catch (Exception t) {/**/}
    }

    @FunctionalInterface
    public interface CodeAction {
        void run() throws Exception;
    }

    @FunctionalInterface
    public interface CodeSupplier<T> {
        T get() throws Exception;
    }
}
