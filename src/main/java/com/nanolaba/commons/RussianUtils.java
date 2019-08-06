package com.nanolaba.commons;

public class RussianUtils {

    private RussianUtils() {/**/}

    public static boolean isNameCorrect(String name) {
        return name != null
                && name.trim().length() > 1
                && name.matches("[А-ЯЁ][-А-яЁё]+");
    }

    public static String getFIO(String f, String i, String o) {

        String res = "";

        for (String t : new String[]{f, i, o}) {
            if (t != null && !(t = t.trim()).isEmpty()) {
                res += (res.isEmpty() ? "" : " ") + capitalizeName(t.toLowerCase());
            }
        }

        return res;
    }

    private static String capitalizeName(String name) {
        name = name.toLowerCase();
        char[] chars = new char[name.length()];
        for (int i = 0; i < name.length(); ++i) {
            if (i == 0 || (name.charAt(i - 1) == '-') || (name.charAt(i - 1) == '(')) {
                chars[i] = Character.toTitleCase(name.charAt(i));
            } else {
                chars[i] = name.charAt(i);
            }
        }
        return new String(chars);
    }

    public static String getFIOShort(String f, String i, String o) {

        return ((f == null ? "" : (capitalizeName(f.trim().toLowerCase()) + ' ')) +
                (i != null && !i.trim().isEmpty() ? i.trim().substring(0, 1).toUpperCase() + '.' : "") +
                (o != null && !o.trim().isEmpty() ? o.trim().substring(0, 1).toUpperCase() + '.' : "")).trim();
    }


    /**
     * Метод транслитерирует русский текст
     *
     * @param text текст на русском языке
     * @return транслитерированный текст
     */
    public static String translit(String text) {

        StringBuilder res = new StringBuilder();
        if (text != null) {
            for (char ch : text.toCharArray()) {
                res.append(translit(ch));
            }
        }
        return res.toString();
    }


    /**
     * Метод транслитерирует русский символ
     *
     * @param ch символ на русском языке
     * @return транслитерированный текст
     */
    public static String translit(char ch) {
        // ГОСТ 16876-71
        switch (ch) {
            case 'А':
                return "A";
            case 'Б':
                return "B";
            case 'В':
                return "V";
            case 'Г':
                return "G";
            case 'Д':
                return "D";
            case 'Е':
                return "E";
            case 'Ё':
                return "E";
            case 'Ж':
                return "ZH";
            case 'З':
                return "Z";
            case 'И':
                return "I";
            case 'Й':
                return "J";
            case 'К':
                return "K";
            case 'Л':
                return "L";
            case 'М':
                return "M";
            case 'Н':
                return "N";
            case 'О':
                return "O";
            case 'П':
                return "P";
            case 'Р':
                return "R";
            case 'С':
                return "S";
            case 'Т':
                return "T";
            case 'У':
                return "U";
            case 'Ф':
                return "F";
            case 'Х':
                return "H";
            case 'Ц':
                return "C";
            case 'Ч':
                return "CH";
            case 'Ш':
                return "SH";
            case 'Щ':
                return "SCH";
            case 'Ъ':
                return "\"";
            case 'Ы':
                return "Y";
            case 'Ь':
                return "'";
            case 'Э':
                return "E";
            case 'Ю':
                return "JU";
            case 'Я':
                return "JA";
            case '`':
                return "*";
            case 'а':
                return "a";
            case 'б':
                return "b";
            case 'в':
                return "v";
            case 'г':
                return "g";
            case 'д':
                return "d";
            case 'е':
                return "e";
            case 'ё':
                return "e";
            case 'ж':
                return "zh";
            case 'з':
                return "z";
            case 'и':
                return "i";
            case 'й':
                return "j";
            case 'к':
                return "k";
            case 'л':
                return "l";
            case 'м':
                return "m";
            case 'н':
                return "n";
            case 'о':
                return "o";
            case 'п':
                return "p";
            case 'р':
                return "r";
            case 'с':
                return "s";
            case 'т':
                return "t";
            case 'у':
                return "u";
            case 'ф':
                return "f";
            case 'х':
                return "h";
            case 'ц':
                return "c";
            case 'ч':
                return "ch";
            case 'ш':
                return "sh";
            case 'щ':
                return "sch";
            case 'ъ':
                return "\"";
            case 'ы':
                return "y";
            case 'ь':
                return "'";
            case 'э':
                return "e";
            case 'ю':
                return "ju";
            case 'я':
                return "ja";
            default:
                return String.valueOf(ch);
        }
    }

    public static String replaceRussianLettersWithEnglish(String text) {
        StringBuilder res = new StringBuilder();
        if (text != null) {
            for (char ch : text.toCharArray()) {
                res.append(replaceRussianLettersWithEnglish(ch));
            }
        }
        return res.toString();
    }

    public static String replaceRussianLettersWithEnglish(char ch) {
        // ГОСТ 16876-71
        switch (ch) {
            case 'А':
                return "A";
            case 'В':
                return "B";
            case 'Е':
                return "E";
            case 'К':
                return "K";
            case 'М':
                return "M";
            case 'Н':
                return "H";
            case 'О':
                return "O";
            case 'Р':
                return "P";
            case 'С':
                return "C";
            case 'Т':
                return "T";
            case 'У':
                return "Y";
            case 'Х':
                return "X";
            case 'а':
                return "a";
            case 'е':
                return "e";
            case 'к':
                return "k";
            case 'о':
                return "o";
            case 'р':
                return "p";
            case 'с':
                return "c";
            case 'у':
                return "y";
            case 'х':
                return "x";
            default:
                return String.valueOf(ch);
        }
    }
}
