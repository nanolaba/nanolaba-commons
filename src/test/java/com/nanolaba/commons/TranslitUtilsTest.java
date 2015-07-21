package com.nanolaba.commons;


import junit.framework.Assert;
import org.junit.Test;

public class TranslitUtilsTest {

    @Test
    public void testEmptyTranslit() {
        Assert.assertEquals("", TranslitUtils.translitRuEn(""));
        Assert.assertEquals("123", TranslitUtils.translitRuEn("123"));
    }

    @Test
    public void testTranslit() {
        Assert.assertEquals("Mama", TranslitUtils.translitRuEn("Мама"));
    }

    @Test
    public void testTranslit2() {
        Assert.assertEquals("Popast` na zavod po proizvodstvu Pue`ra -- d`iavol`ski slozhno. Keitai`tcy` ne puskaiut na svoi chai`ny`e manufaktury` postoronnikh. Poe`tomu ochen` malo kto iz evropei`tcev by`val na podobny`kh proizvodstvakh", TranslitUtils.translitRuEn("Попасть на завод по производству Пуэра -- дьявольски сложно. Китайцы не пускают на свои чайные мануфактуры посторонних. Поэтому очень мало кто из европейцев бывал на подобных производствах"));
    }
}
