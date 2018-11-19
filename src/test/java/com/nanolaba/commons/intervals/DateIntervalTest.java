package com.nanolaba.commons.intervals;


import com.nanolaba.commons.TimeUtils;
import org.junit.Assert;
import org.junit.Test;

public class DateIntervalTest {

    @Test
    public void testToString() {

        DateInterval interval = DateInterval.create(TimeUtils.toDate("1.1.2011"), TimeUtils.toDate("10.1.2011"), true, true);
        Assert.assertEquals("с 01.01.2011 00:00 по 10.01.2011 00:00", interval.toString());
    }

    @Test
    public void testSplitByDay() {
        DateInterval interval = DateInterval.create(TimeUtils.toDate("1.1.2011"), TimeUtils.toDate("10.1.2011"), true, true);
        Assert.assertEquals(10, interval.splitByDays().size());

        interval = DateInterval.create(TimeUtils.toDate("1.1.2011"), TimeUtils.toDate("10.1.2011"), true, false);
        Assert.assertEquals(9, interval.splitByDays().size());

        interval = DateInterval.create(TimeUtils.toDate("1.1.2011"), TimeUtils.toDate("10.1.2011"), false, true);
        Assert.assertEquals(9, interval.splitByDays().size());

        interval = DateInterval.create(TimeUtils.toDate("1.1.2011"), TimeUtils.toDate("10.1.2011"), false, false);
        Assert.assertEquals(8, interval.splitByDays().size());

        interval = DateInterval.create(TimeUtils.toDate("1.1.2011"), TimeUtils.toDate("1.1.2011"), true, true);
        Assert.assertEquals(1, interval.splitByDays().size());

        interval = DateInterval.create(TimeUtils.toDate("1.1.2011"), TimeUtils.toDate("1.1.2011"), false, false);
        Assert.assertEquals(0, interval.splitByDays().size());
    }
}
