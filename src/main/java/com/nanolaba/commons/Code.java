package com.nanolaba.commons;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Supplier;

public class Code {

    private Code() {
    }

    public static <T> T ifEmpty(T t, T defaultObject) {
        return t instanceof CharSequence ?
                (T) StringUtils.defaultIfEmpty((CharSequence) t, (CharSequence) defaultObject) :
                ifNull(t, defaultObject);
    }

    public static <T> T ifEmpty(T t, Supplier<T> defaultObject) {
        return t instanceof CharSequence ?
                (T) StringUtils.defaultIfEmpty((CharSequence) t, (CharSequence) defaultObject.get()) :
                ifNull(t, defaultObject);
    }

    public static <T> T ifBlank(T t, T defaultObject) {
        return t instanceof CharSequence ?
                (T) StringUtils.defaultIfBlank((CharSequence) t, (CharSequence) defaultObject) :
                ifNull(t, defaultObject);
    }

    public static <T> T ifBlank(T t, Supplier<T> defaultObject) {
        return t instanceof CharSequence ?
                (T) StringUtils.defaultIfBlank((CharSequence) t, (CharSequence) defaultObject.get()) :
                ifNull(t, defaultObject);
    }

    public static <T> T ifNull(T t, T defaultObject) {
        return t == null ? defaultObject : t;
    }

    public static <T> T ifNull(T t, Supplier<T> defaultObject) {
        return t == null ? defaultObject.get() : t;
    }

    public static <T> T catchNull(Supplier<T> t, T defaultObject) {
        try {
            return ifNull(t.get(), defaultObject);
        } catch (NullPointerException ex) {
            return defaultObject;
        }
    }

    public static <T> T catchNull(Supplier<T> t) {
        return catchNull(t, (T) null);
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

    public static <T> T runQuietly(CodeSupplier<T> runnable, Supplier<T> defaultObject) {
        try {
            return runnable.get();
        } catch (Exception t) {
            return defaultObject.get();
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
