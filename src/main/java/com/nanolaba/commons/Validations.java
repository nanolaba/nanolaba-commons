package com.nanolaba.commons;

public class Validations {

    private static final String RUSSIAN_ABC = "абвгдеёжзийклмнопрстуфхцчшщэьъыюя";

    public static boolean isValidDomainName(String domain) {
        return domain != null &&
                domain.toLowerCase().matches("^([" + RUSSIAN_ABC + "a-z0-9\\.-]{1,64})?\\.(?:рф|[a-z]{2,64})$");
    }
}
