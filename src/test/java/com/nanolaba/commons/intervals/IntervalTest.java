package com.nanolaba.commons.intervals;


import org.junit.Assert;
import org.junit.Test;

public class IntervalTest {

    @Test
    public void testIntersections() {

        Assert.assertTrue(Interval.create(0, 100, true, true).hasIntersections(Interval.create(0, 100, true, true)));
        Assert.assertTrue(Interval.create(0, 100, true, true).hasIntersections(Interval.create(0, 1000, true, true)));
        Assert.assertTrue(Interval.create(0, 100, true, true).hasIntersections(Interval.create(0, 10, true, true)));
        Assert.assertTrue(Interval.create(0, 100, true, true).hasIntersections(Interval.create(-10, 10, true, true)));

        Assert.assertFalse(Interval.create(0, 100, true, true).hasIntersections(Interval.create(-10, -1, true, false)));
        Assert.assertFalse(Interval.create(0, 100, true, true).hasIntersections(Interval.create(-10, 0, true, false)));
        Assert.assertFalse(Interval.create(0, 100, true, true).hasIntersections(Interval.create(100, 1000, false, false)));
        Assert.assertFalse(Interval.create(0, 100, true, true).hasIntersections(Interval.create(200, 1000, false, false)));
    }

    @Test
    public void testContainsInterval() {

        Assert.assertTrue(Interval.create(0, 100, true, true).contains(Interval.create(0, 100, true, true)));
        Assert.assertTrue(Interval.create(0, 100, true, true).contains(Interval.create(0, 100, false, false)));
        Assert.assertTrue(Interval.create(0, 100, true, true).contains(Interval.create(1, 50, false, false)));
        Assert.assertTrue(Interval.create(0, 100, false, false).contains(Interval.create(1, 100, false, false)));

        Assert.assertFalse(Interval.create(0, 100, true, true).contains(Interval.create(0, 101, false, false)));
        Assert.assertFalse(Interval.create(0, 100, false, false).contains(Interval.create(0, 100, true, false)));
        Assert.assertFalse(Interval.create(0, 100, false, false).contains(Interval.create(0, 100, false, true)));
        Assert.assertFalse(Interval.create(0, 100, false, false).contains(Interval.create(0, 1000, false, true)));

        Assert.assertTrue(Interval.create(null, 100, false, false).contains(Interval.create(0, 10, false, true)));
        Assert.assertTrue(Interval.create(null, 100, false, false).contains(Interval.create(-100, 10, false, true)));

        Assert.assertFalse(Interval.create(null, 100, false, false).contains(Interval.create(-100, 100, false, true)));

        Assert.assertTrue(Interval.create(null, null, false, false).contains(Interval.create(-100, 100, false, true)));
    }

    @Test
    public void testContainsValue() {

        Assert.assertTrue(Interval.create(0, 100, true, true).contains(0));
        Assert.assertTrue(Interval.create(0, 100, true, true).contains(100));
        Assert.assertTrue(Interval.create(0, 100, true, true).contains(50));

        Assert.assertTrue(Interval.create(0, null, true, true).contains(0));
        Assert.assertTrue(Interval.create(0, null, true, true).contains(50));
        Assert.assertTrue(Interval.create(0, null, true, true).contains(5000));

        Assert.assertTrue(Interval.create(null, 100, true, true).contains(0));
        Assert.assertTrue(Interval.create(null, 100, true, true).contains(-100));
        Assert.assertTrue(Interval.create(null, 100, true, true).contains(50));

        Assert.assertFalse(Interval.create(null, 100, true, true).contains(500));

        Assert.assertFalse(Interval.create(0, 100, true, true).contains(500));
        Assert.assertFalse(Interval.create(0, 100, true, true).contains(-1));
        Assert.assertFalse(Interval.create(0, 100, false, false).contains(0));
        Assert.assertFalse(Interval.create(0, 100, false, false).contains(100));
    }

    @Test
    public void testToString() {
        Assert.assertEquals("[0; 100)", Interval.create(0, 100, true, false).toString());
    }
}
