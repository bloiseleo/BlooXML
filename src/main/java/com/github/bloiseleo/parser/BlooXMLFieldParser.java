package com.github.bloiseleo.parser;

import com.github.bloiseleo.parser.annotation.TagName;

import java.lang.reflect.Field;

class BlooXMLFieldParser extends BlooXMLParser{
    private Object object;
    public BlooXMLFieldParser(Object object) {
        this.object = object;
    }

    @Override
    protected String getObjectName(Object data) {
        var field = (Field) data;
        var annotation = field.getAnnotation(TagName.class);
        if (annotation == null) {
            return field.getName();
        }
        return annotation.value();
    }

    @Override
    public String parse(Object data) {
        try {
            var field = (Field) data;
            var value = field.get(object);
            BlooXMLParserFactory blooXMLParserFactory = new BlooXMLParserFactory();
            BlooXMLParser blooXMLParser = blooXMLParserFactory.get(value);
            return blooXMLParser.parse(value, getObjectName(field));
        } catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public String parse(Object data, String tagName) {
        try {
            var field = (Field) data;
            var value = field.get(object);
            BlooXMLParserFactory blooXMLParserFactory = new BlooXMLParserFactory();
            BlooXMLParser blooXMLParser = blooXMLParserFactory.get(value);
            return blooXMLParser.parse(value, tagName);
        } catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }
}
