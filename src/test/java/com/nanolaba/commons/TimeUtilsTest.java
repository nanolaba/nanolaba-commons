package com.nanolaba.commons;


import org.junit.Assert;
import org.junit.Test;

public class TimeUtilsTest {

    @Test
    public void testDateInWords() {


        Assert.assertNull(TimeUtils.toStringInWords(null));
        Assert.assertEquals("первое января две тысячи тринадцатого года", TimeUtils.toStringInWords(TimeUtils.toDate("01.01.2013")));
        Assert.assertEquals("тринадцатое февраля одна тысяча семьсот двадцать третьего года", TimeUtils.toStringInWords(TimeUtils.toDate("13.02.1723")));
        Assert.assertEquals("тринадцатое февраля двухтысячного года", TimeUtils.toStringInWords(TimeUtils.toDate("13.02.2000")));

    }

}
