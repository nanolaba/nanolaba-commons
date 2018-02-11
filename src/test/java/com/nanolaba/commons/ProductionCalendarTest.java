package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ProductionCalendarTest {

    @Test
    public void testBusinessDays() {
        Assert.assertEquals(0, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("08.07.2017")));
        Assert.assertEquals(0, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("09.07.2017")));
        Assert.assertEquals(1, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("10.07.2017")));
        Assert.assertEquals(2, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("11.07.2017")));
        Assert.assertEquals(3, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("12.07.2017")));
        Assert.assertEquals(4, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("13.07.2017")));
        Assert.assertEquals(5, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("14.07.2017")));
        Assert.assertEquals(5, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("15.07.2017")));
        Assert.assertEquals(5, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("16.07.2017")));
        Assert.assertEquals(6, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("17.07.2017")));
        Assert.assertEquals(7, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("18.07.2017")));


        Assert.assertEquals(249, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("01.01.2010"), TimeUtils.toDate("31.12.2010")));

        Assert.assertEquals(247, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("01.01.2018"), TimeUtils.toDate("31.12.2018")));
        Assert.assertEquals(21, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("01.12.2018"), TimeUtils.toDate("31.12.2018")));
        Assert.assertEquals(21, ProductionCalendar.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("01.11.2018"), TimeUtils.toDate("30.11.2018")));

    }

    @Test
    public void addWorkingDays() {
        Date date = TimeUtils.toDate("01.06.2017");

        Assert.assertEquals("01.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 0)));

        Assert.assertEquals("02.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 1)));
        Assert.assertEquals("05.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 2)));
        Assert.assertEquals("06.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 3)));
        Assert.assertEquals("07.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 4)));
        Assert.assertEquals("08.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 5)));
        Assert.assertEquals("09.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 6)));
        Assert.assertEquals("13.06.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, 7)));


        Assert.assertEquals("31.05.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, -1)));
        Assert.assertEquals("30.05.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, -2)));
        Assert.assertEquals("29.05.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, -3)));
        Assert.assertEquals("26.05.2017", TimeUtils.toString(ProductionCalendar.addWorkingDays(date, -4)));

    }
}