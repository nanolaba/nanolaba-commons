package com.nanolaba.commons;

public class RussianUtils {

    private RussianUtils() {/**/}

    public static String getFIO(String f, String i, String o) {

        String res = "";

        for (String t : new String[]{f, i, o}) {
            if (t != null && !(t = t.trim()).isEmpty()) {
                res += (res.isEmpty() ? "" : " ") + t;
            }
        }

        return res;
    }

    public static String getFIOShort(String f, String i, String o) {

        return ((f == null ? "" : (f.trim() + ' ')) +
                (i != null && !i.trim().isEmpty() ? i.trim().substring(0, 1) + '.' : "") +
                (o != null && !o.trim().isEmpty() ? o.trim().substring(0, 1) + '.' : "")).trim();
    }

}
