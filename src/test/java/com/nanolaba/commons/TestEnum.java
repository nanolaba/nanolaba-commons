package com.nanolaba.commons;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public enum TestEnum {

    VALUE_A,
    VALUE_B;

    static {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test_enum.xml");
            context.getBean(EnumInitializer.class).load(TestEnum.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String title;
    private boolean bool;
    private List<String> values;

    public String getTitle() {
        return title;
    }

    public List<String> getValues() {
        return values;
    }

    public boolean isBool() {
        return bool;
    }
}
