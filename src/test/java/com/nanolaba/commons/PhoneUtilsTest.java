package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

public class PhoneUtilsTest {


    @Test
    public void testNormalize() {


        Assert.assertEquals("8 (123) 123-12-12", PhoneUtils.normalize("8 (123) 123-12-12"));
        Assert.assertEquals("8 (123) 123-12-12", PhoneUtils.normalize("8 123 123-12-12"));
        Assert.assertEquals("8 (123) 123-12-12", PhoneUtils.normalize("81231231212"));
        Assert.assertEquals("8 (123) 123-12-12", PhoneUtils.normalize("8 123 1231212"));
        Assert.assertEquals("8 (123) 123-12-12", PhoneUtils.normalize("+7 123 1231212"));
        Assert.assertEquals("8 (123) 123-12-12", PhoneUtils.normalize("+7 (123) 1231212"));
        Assert.assertEquals("8 (123) 123-12-12", PhoneUtils.normalize("7 (123) 1231212"));
        Assert.assertEquals("", PhoneUtils.normalize("нет номера"));
        Assert.assertEquals("", PhoneUtils.normalize("б/н"));
        Assert.assertEquals("", PhoneUtils.normalize(""));
        Assert.assertEquals("", PhoneUtils.normalize(null));

        Assert.assertEquals("8 (123) 123-12-12, 8 (915) 123-11-11", PhoneUtils.normalize("7 (123) 1231212; 89151231111"));

    }
}
