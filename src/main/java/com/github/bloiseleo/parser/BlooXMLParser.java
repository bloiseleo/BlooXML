package com.github.bloiseleo.parser;

import com.github.bloiseleo.parser.annotation.TagName;

abstract class BlooXMLParser {
    protected String getObjectName(Object data) {
        Class<?> objectClass = data.getClass();
        var annotation = objectClass.getAnnotation(TagName.class);
        if (annotation == null) {
            return objectClass.getName();
        }
        return annotation.value();
    }
    protected Class<?> getClass(Object data) {
        return data.getClass();
    }
    public String parse(Object data) {
        BlooXMLObjectParser blooXMLObjectParser = new BlooXMLObjectParser();
        return blooXMLObjectParser.parse(data, getObjectName(data));
    }
    public String parse(Object data, String tagName) {
        if (tagName == null) {
            return parse(data);
        }
        BlooXMLObjectParser blooXMLObjectParser = new BlooXMLObjectParser();
        return blooXMLObjectParser.parse(data, tagName);
    }
}
