package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

public class ImagesUtilsTest {


    @Test
    public void testGetJpegDimension() throws IOException {
        Dimension dimension = ImagesUtils.getJPEGDimension(Thread.currentThread().getContextClassLoader().getResourceAsStream("images/1.jpg"));

        Assert.assertNotNull(dimension);
        Assert.assertEquals(600, dimension.width);
        Assert.assertEquals(450, dimension.height);
    }

    @Test
    public void testGetJpegDimension2() throws IOException {
        Dimension dimension = ImagesUtils.getJPEGDimension(Thread.currentThread().getContextClassLoader().getResourceAsStream("images/2.jpg"));

        Assert.assertNotNull(dimension);
        Assert.assertEquals(600, dimension.width);
        Assert.assertEquals(449, dimension.height);
    }
}