package com.github.bloiseleo.parser;

public class BlooXML extends BlooXMLParser {
    public String parse(Object data) {
        BlooXMLObjectParser blooXMLObjectParser = new BlooXMLObjectParser();
        return blooXMLObjectParser.parse(data, getObjectName(data));
    }
    @Override
    public String parse(Object data, String tagName) {
        if (tagName == null) {
            return parse(data);
        }
        BlooXMLObjectParser blooXMLObjectParser = new BlooXMLObjectParser();
        return blooXMLObjectParser.parse(data, tagName);
    }
}
