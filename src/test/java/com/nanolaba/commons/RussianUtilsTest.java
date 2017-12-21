package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

public class RussianUtilsTest {

    @Test
    public void testFIO() {

        Assert.assertEquals("Иванов Петр Васильевич", RussianUtils.getFIO("Иванов", "Петр", "Васильевич"));
        Assert.assertEquals("Иванов Петр Васильевич", RussianUtils.getFIO("Иванов", "Петр", " Васильевич"));
        Assert.assertEquals("Иванов Петр Васильевич", RussianUtils.getFIO(" Иванов  ", "\tПетр ", " Васильевич"));
        Assert.assertEquals("Иванов Петр Васильевич", RussianUtils.getFIO(" иванов  ", "\tпетр ", " васильевич"));
        Assert.assertEquals("Иванов Петр", RussianUtils.getFIO(" Иванов  ", "\tПетр ", null));
        Assert.assertEquals("Иванов Петр", RussianUtils.getFIO(" Иванов  ", "\tПетр ", ""));
        Assert.assertEquals("Иванов", RussianUtils.getFIO(" Иванов  ", "\t", ""));
        Assert.assertEquals("Иванов", RussianUtils.getFIO(" иванов  ", "\t", ""));

        Assert.assertEquals("Иванов П.В.", RussianUtils.getFIOShort("Иванов", "Петр", "Васильевич"));
        Assert.assertEquals("Иванов П.В.", RussianUtils.getFIOShort("иванов", "петр", "васильевич"));
        Assert.assertEquals("Иванов П.В.", RussianUtils.getFIOShort("Иванов", "Петр", " Васильевич"));
        Assert.assertEquals("Иванов П.В.", RussianUtils.getFIOShort(" Иванов  ", "\tПетр ", " Васильевич"));
        Assert.assertEquals("Иванов П.", RussianUtils.getFIOShort(" Иванов  ", "\tПетр ", null));
        Assert.assertEquals("Иванов П.", RussianUtils.getFIOShort(" Иванов  ", "\tПетр ", ""));
        Assert.assertEquals("Иванов П.В.", RussianUtils.getFIOShort(" Иванов  ", "П", "В"));
        Assert.assertEquals("Иванов П.", RussianUtils.getFIOShort(" Иванов  ", "П", ""));
        Assert.assertEquals("Иванов П.", RussianUtils.getFIOShort(" Иванов  ", "\tП", ""));
        Assert.assertEquals("Иванов", RussianUtils.getFIOShort(" Иванов  ", "\t", ""));
        Assert.assertEquals("Иванов", RussianUtils.getFIOShort(" иванов  ", "\t", ""));


    }
}
