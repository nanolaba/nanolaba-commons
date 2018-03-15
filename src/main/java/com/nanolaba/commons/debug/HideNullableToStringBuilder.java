package com.nanolaba.commons.debug;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Field;

public class HideNullableToStringBuilder extends ReflectionToStringBuilder {

    public HideNullableToStringBuilder(Object object) {
        super(object);
    }

    public HideNullableToStringBuilder(Object object, ToStringStyle style) {
        super(object, style);
    }

    public HideNullableToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer) {
        super(object, style, buffer);
    }

    public <T> HideNullableToStringBuilder(T object, ToStringStyle style, StringBuffer buffer, Class<? super T> reflectUpToClass, boolean outputTransients, boolean outputStatics) {
        super(object, style, buffer, reflectUpToClass, outputTransients, outputStatics);
    }

    @Override
    protected boolean accept(Field field) {
        boolean accept = super.accept(field);
        if (accept) {
            try {
                accept = field.get(this.getObject()) != null;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return accept;
    }
}