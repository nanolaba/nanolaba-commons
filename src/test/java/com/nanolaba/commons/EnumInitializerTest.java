package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnumInitializerTest {

    @Test
    public void testInit() {

        Assert.assertEquals("titleA", TestEnum.VALUE_A.getTitle());
        Assert.assertEquals("1", TestEnum.VALUE_A.getValues().get(0));
        assertTrue(TestEnum.VALUE_A.isBool());
        Assert.assertEquals("titleB", TestEnum.VALUE_B.getTitle());
        Assert.assertEquals("a", TestEnum.VALUE_B.getValues().get(0));
        assertFalse(TestEnum.VALUE_B.isBool());

    }
}
