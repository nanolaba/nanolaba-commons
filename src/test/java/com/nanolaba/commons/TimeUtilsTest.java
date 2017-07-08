package com.nanolaba.commons;


import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.TimeZone;

public class TimeUtilsTest {

    @Test
    public void testDateInWords() {
        Assert.assertNull(TimeUtils.toStringInWords(null));
        Assert.assertEquals("первое января две тысячи тринадцатого года", TimeUtils.toStringInWords(TimeUtils.toDate("01.01.2013")));
        Assert.assertEquals("тринадцатое февраля одна тысяча семьсот двадцать третьего года", TimeUtils.toStringInWords(TimeUtils.toDate("13.02.1723")));
        Assert.assertEquals("тринадцатое февраля двухтысячного года", TimeUtils.toStringInWords(TimeUtils.toDate("13.02.2000")));
    }

    @Test
    public void testConvert() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
        Date date = new Date();
//        Date convert = TimeUtils.convert(date, TimeZone.getTimeZone("Europe/Moscow"));
        Date convert = TimeUtils.convert(date, TimeZone.getTimeZone("Europe/Moscow"), TimeZone.getTimeZone("GMT"));
        Date convert2 = TimeUtils.convert(convert, TimeZone.getTimeZone("GMT"), TimeZone.getTimeZone("Europe/Moscow"));

        System.out.println(date);
        System.out.println(convert);
        System.out.println(convert2);

        Assert.assertNotSame(date.toString(), convert.toString());
        Assert.assertEquals(date.toString(), convert2.toString());
    }

    @Test
    public void testBusinessDays() {
        Assert.assertEquals(0, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("08.07.2017")));
        Assert.assertEquals(0, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("09.07.2017")));
        Assert.assertEquals(1, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("10.07.2017")));
        Assert.assertEquals(2, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("11.07.2017")));
        Assert.assertEquals(3, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("12.07.2017")));
        Assert.assertEquals(4, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("13.07.2017")));
        Assert.assertEquals(5, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("14.07.2017")));
        Assert.assertEquals(5, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("15.07.2017")));
        Assert.assertEquals(5, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("16.07.2017")));
        Assert.assertEquals(6, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("17.07.2017")));
        Assert.assertEquals(7, TimeUtils.getWorkingDaysBetweenTwoDates(TimeUtils.toDate("08.07.2017"), TimeUtils.toDate("18.07.2017")));
    }
}
