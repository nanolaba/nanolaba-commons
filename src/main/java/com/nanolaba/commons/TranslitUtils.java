package com.nanolaba.commons;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TranslitUtils {


    private TranslitUtils() {/**/}

    public static String translit(String text, InputStream translitRules) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(translitRules, "UTF-8"));
        String s;
        while ((s = in.readLine()) != null) {
            s = s.trim();
            if (!s.startsWith("#") && s.contains("=")) {
                String[] split = s.split("=");
                String key = split[0];
                String value = split[1];

                text = text.replace(key, value);
            }
        }

        return text;
    }

    public static String translitRuEn(String text) {
        try {
            return translit(text, Thread.currentThread().getContextClassLoader().getResourceAsStream("translit/translit-ru.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String translitEnRu(String text) {
        try {
            return translit(text, Thread.currentThread().getContextClassLoader().getResourceAsStream("translit/translit-en.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
