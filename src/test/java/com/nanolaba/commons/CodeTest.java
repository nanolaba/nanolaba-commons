package com.nanolaba.commons;

import org.junit.Test;

public class CodeTest {

    @Test(expected = RuntimeException.class)
    public void testRun() {
        Code.run(() -> {
            Long t = null;
            long l = t / 10L;
        });
    }

    @Test(expected = RuntimeException.class)
    public void testRunSupplier() {

        class foo {
            public long bar() {
                return Code.run(() -> {
                    Long t = null;
                    return t / 10L;
                });
            }
        }

        new foo().bar();
    }

    @Test
    public void testRunQuietly() {
        Code.runQuietly(() -> {
            Long t = null;
            long l = t / 10L;
        });
    }

}