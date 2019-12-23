package com.nanolaba.commons;

public class PhoneUtils {

    private PhoneUtils() {/**/ }


    public static String normalize(String phone) {
        if (phone == null) {
            return "";
        }

        String p = toDigits(phone);

        if (p.length() % 11 != 0) {
            return phone;
        } else {
            StringBuilder builder = new StringBuilder();
            char[] c = p.toCharArray();
            for (int i = 0; i < c.length; i += 11) {
                if (i > 0) {
                    builder.append(", ");
                }
                builder.append("8 (" + c[i + 1] + c[i + 2] + c[i + 3] + ") " + c[i + 4] + c[i + 5] + c[i + 6] + "-" + c[i + 7] + c[i + 8] + "-" + c[i + 9] + c[i + 10]);
            }
            return builder.toString();
        }

    }

    public static boolean isRussianNumber(String phone) {
        return phone.replaceAll("[^0-9]", "").length() == 11;
    }

    public static String toDigits(String phone) {
        return phone == null ? "" : phone.replaceAll("[^0-9]", "");
    }
}
