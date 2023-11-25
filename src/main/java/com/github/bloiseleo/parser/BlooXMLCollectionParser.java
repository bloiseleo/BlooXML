package com.github.bloiseleo.parser;

import java.util.Collection;

class BlooXMLCollectionParser extends BlooXMLParser {
    @Override
    protected String getObjectName(Object data) {
        return "item";
    }

    @Override
    public String parse(Object data, String tagName) {
        StringBuilder tagBuilder = new StringBuilder();
        String start = "<" + tagName + ">";
        String end = "</" + tagName + ">";
        tagBuilder.append(start);

        var collection = (Collection<?>) data;

        for (Object value: collection) {
            BlooXMLParserFactory factory = new BlooXMLParserFactory();
            BlooXMLParser blooXMLParser = factory.get(value);
            String item = blooXMLParser.parse(value, getObjectName(collection));
            tagBuilder.append(item);
        }

        tagBuilder.append(end);
        return tagBuilder.toString();
    }
}
