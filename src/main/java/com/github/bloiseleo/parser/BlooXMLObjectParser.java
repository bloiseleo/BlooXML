package com.github.bloiseleo.parser;

import com.github.bloiseleo.parser.annotation.TagName;

import java.lang.reflect.Field;

class BlooXMLObjectParser extends BlooXMLParser {
    @Override
    public String parse(Object data, String tagName) {
        StringBuilder stringBuilder = new StringBuilder();
        String tagStart = "<" + tagName + ">";
        String endTag = "</" + tagName + ">";
        Class<?> objectClass = getClass(data);

        stringBuilder.append(tagStart);

        for (Field field: objectClass.getFields()) {
            BlooXMLFieldParser blooXMLFieldParser = new BlooXMLFieldParser(data);
            if (field.getAnnotation(TagName.class) != null) {
                stringBuilder.append(blooXMLFieldParser.parse(field));
                continue;
            }
            stringBuilder.append(blooXMLFieldParser.parse(field, field.getName()));
        }

        stringBuilder.append(endTag);

        return stringBuilder.toString();
    }
}
