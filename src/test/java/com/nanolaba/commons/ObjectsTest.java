package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

public class ObjectsTest {

    @Test
    public void testGetAndSet() {

        Foo foo = new Foo();
        Objects.set(foo, "bar", "123");

        Assert.assertEquals("123", foo.getBar());

        Objects.set(foo, "bar", "ABC");

        Assert.assertEquals("ABC", foo.getBar());
        Assert.assertEquals("ABC", Objects.get(foo, "bar"));


    }

    private static class Foo {

        private String bar;

        public String getBar() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }
    }

}