package com.nanolaba.commons.intervals;

import com.nanolaba.commons.Validations;
import org.junit.Assert;
import org.junit.Test;

public class ValidationsTest {

    @Test
    public void testDomainNameValidation() {
        Assert.assertFalse(Validations.isValidDomainName("ru"));
        Assert.assertFalse(Validations.isValidDomainName("asda.ляля"));

        Assert.assertTrue(Validations.isValidDomainName("ya.ru"));
        Assert.assertTrue(Validations.isValidDomainName("aaa.ya.ru"));
        Assert.assertTrue(Validations.isValidDomainName("мыло.ru"));
        Assert.assertTrue(Validations.isValidDomainName("мыло.рф"));
        Assert.assertTrue(Validations.isValidDomainName("132213.рф"));
        Assert.assertTrue(Validations.isValidDomainName("132213.com"));
        Assert.assertTrue(Validations.isValidDomainName("ыфвфывю.132213.com"));
        Assert.assertTrue(Validations.isValidDomainName("ы-фвфывю.132213.com"));
        Assert.assertTrue(Validations.isValidDomainName("ы-фв121фывю.13-2213.kz"));

    }

}
