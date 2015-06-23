package com.nanolaba.commons;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class EnumInitializer {

    private Map<String, Map<String, Object>> params = new HashMap<String, Map<String, Object>>();

    public Map<String, Map<String, Object>> getParams() {
        return params;
    }

    public void setParams(Map<String, Map<String, Object>> params) {
        this.params = params;
    }

    public void load(Class enumClass) throws IOException, IllegalAccessException {
        if (enumClass.isEnum()) {
            for (Object o : EnumSet.allOf(enumClass)) {
                if (params.containsKey(o.toString())) {
                    fill(o, params.get(o.toString()));
                }
            }
        } else {
            throw new IllegalArgumentException("Only enum class is supported");
        }
    }

    private void fill(Object enumObject, Map<String, Object> params) throws IllegalAccessException {
        for (Map.Entry<String, Object> param : params.entrySet()) {
            for (Field field : enumObject.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getName().equals(param.getKey())) {
                    if (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)) {
                        field.set(enumObject, Boolean.valueOf((String) param.getValue()));
                    } else if (field.getType().equals(int.class)) {
                        field.set(enumObject, Integer.valueOf((String) param.getValue()).intValue());
                    } else if (field.getType().equals(short.class)) {
                        field.set(enumObject, Short.valueOf((String) param.getValue()).shortValue());
                    } else if (field.getType().equals(double.class)) {
                        field.set(enumObject, Double.valueOf((String) param.getValue()).doubleValue());
                    } else if (field.getType().equals(long.class)) {
                        field.set(enumObject, Long.valueOf((String) param.getValue()).longValue());
                    } else if (field.getType().equals(byte.class)) {
                        field.set(enumObject, Byte.valueOf((String) param.getValue()).byteValue());
                    } else if (field.getType().equals(float.class)) {
                        field.set(enumObject, Float.valueOf((String) param.getValue()).floatValue());
                    } else {
                        field.set(enumObject, param.getValue());
                    }
                }
            }
        }
    }
}
