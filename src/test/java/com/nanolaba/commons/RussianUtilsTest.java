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


        Assert.assertEquals("Козлова-Афанасьевна Л П", RussianUtils.getFIO(" козлова-афанасьевна  ", "л", "п"));


    }

    @Test
    public void testCorrection() {
        Assert.assertTrue(RussianUtils.isNameCorrect("Ваня"));
        Assert.assertTrue(RussianUtils.isNameCorrect("Саша"));
        Assert.assertTrue(RussianUtils.isNameCorrect("Анотолий"));
        Assert.assertTrue(RussianUtils.isNameCorrect("Виктор-Мария"));
        Assert.assertTrue(RussianUtils.isNameCorrect("Мамин-Сибиряк"));

        Assert.assertFalse(RussianUtils.isNameCorrect("саша"));
        Assert.assertFalse(RussianUtils.isNameCorrect("ваня"));
        Assert.assertFalse(RussianUtils.isNameCorrect("Мамин-Сибиряк."));
        Assert.assertFalse(RussianUtils.isNameCorrect("Мамин Сибиряк"));
        Assert.assertFalse(RussianUtils.isNameCorrect("т.б."));
        Assert.assertFalse(RussianUtils.isNameCorrect("sasha"));
        Assert.assertFalse(RussianUtils.isNameCorrect(""));
        Assert.assertFalse(RussianUtils.isNameCorrect("1231"));
        Assert.assertFalse(RussianUtils.isNameCorrect("саша1"));
    }

}
