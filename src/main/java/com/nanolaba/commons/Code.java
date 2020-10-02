package com.nanolaba.commons;

import java.util.function.Supplier;

public class Code {

    private Code() {
    }

    public static void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static <T> T run(Supplier<T> runnable) {
        try {
            return runnable.get();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static void runQuietly(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable t) {/**/}
    }
}
