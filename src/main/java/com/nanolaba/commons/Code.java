package com.nanolaba.commons;

public class Code {

    private Code() {
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
