package com.nanolaba.commons;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectionUtilsTest {

    @Test
    public void testRemove() {
        List<String> list = List.of("a", "b", "c");
        List<String> res = CollectionUtils.remove(list, "a", "c");
        assertEquals(1, res.size());
        assertEquals("b", res.get(0));
    }
}