package com.nanolaba.commons;


import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TimeUtilsTest {
    @Test
    public void getDateWithoutTime() throws Exception {
        Date date = new Date();
        Date convert = TimeUtils.getDateWithoutTime(date);

        System.out.println(date);
        System.out.println(convert);

    }

    @Test
    public void getDateWithoutMilliseconds() throws Exception {
        Date date = new Date();
        Date convert = TimeUtils.getDateWithoutMilliseconds(date);

        System.out.println(date);
        System.out.println(convert);
    }

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
    public void testDiff() {
        Assert.assertEquals(0, TimeUtils.getDifference(new Date(), new Date(), TimeUnit.DAYS));
        Assert.assertEquals(0, TimeUtils.getDifference(TimeUtils.toDate("01.01.2011"), TimeUtils.toDate("01.01.2011"), TimeUnit.DAYS));
        Assert.assertEquals(1, TimeUtils.getDifference(TimeUtils.toDate("01.01.2011"), TimeUtils.toDate("02.01.2011"), TimeUnit.DAYS));
    }

    @Test
    public void testGetMonthAndYear() {
        Assert.assertEquals("Январь 2011 года", TimeUtils.getMonthAndYear(TimeUtils.toDate("01.01.2011")));
        Assert.assertEquals("Ноябрь 2021 года", TimeUtils.getMonthAndYear(TimeUtils.toDate("11.11.2021")));
    }
}
