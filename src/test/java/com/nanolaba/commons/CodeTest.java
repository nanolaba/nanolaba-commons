package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

public class CodeTest {

    @Test
    public void testIfBlank() {
        Assert.assertEquals("1", Code.ifBlank(null, "1"));
        Assert.assertEquals("2", Code.ifBlank("2", "1"));
        Assert.assertEquals("1", Code.ifBlank(null, () -> "1"));
        Assert.assertEquals("2", Code.ifBlank("2", () -> "1"));
        Assert.assertEquals("1", Code.ifBlank("", () -> "1"));
        Assert.assertEquals("1", Code.ifBlank(" ", () -> "1"));
    }

    @Test
    public void testIfEmpty() {
        Assert.assertEquals("1", Code.ifEmpty(null, "1"));
        Assert.assertEquals("2", Code.ifEmpty("2", "1"));
        Assert.assertEquals("1", Code.ifEmpty(null, () -> "1"));
        Assert.assertEquals("2", Code.ifEmpty("2", () -> "1"));
        Assert.assertEquals("1", Code.ifEmpty("", () -> "1"));
        Assert.assertEquals(" ", Code.ifEmpty(" ", () -> "1"));
    }

    @Test
    public void testIfNull() {
        Assert.assertEquals("1", Code.ifNull(null, "1"));
        Assert.assertEquals("2", Code.ifNull("2", "1"));
        Assert.assertEquals("1", Code.ifNull(null, () -> "1"));
        Assert.assertEquals("2", Code.ifNull("2", () -> "1"));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void testCatchNull() {

        Object nullObject = null;
        Object noNullObject = "abc";

        Assert.assertEquals("1", Code.catchNull(() -> "1", "2"));
        Assert.assertEquals("2", Code.catchNull(() -> null, "2"));
        Assert.assertEquals("2", Code.catchNull(() -> nullObject.toString(), "2"));
        Assert.assertEquals("abc", Code.catchNull(() -> noNullObject.toString(), "2"));

        Assert.assertNull(Code.catchNull(() -> nullObject.toString()));
    }

    @Test(expected = RuntimeException.class)
    public void testRun() {
        Code.run(() -> {
            Long t = null;
            long l = t / 10L;
        });
    }

    @Test(expected = InternalError.class)
    public void testRun2() {
        Code.run(() -> {
            throw new InternalError();
        });
    }

    @Test(expected = RuntimeException.class)
    public void testRun3() {
        Code.run(() -> {
            throw new Exception();
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