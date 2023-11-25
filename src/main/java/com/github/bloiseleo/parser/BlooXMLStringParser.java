package com.github.bloiseleo.parser;

class BlooXMLStringParser extends BlooXMLParser{
    @Override
    public String parse(Object data, String tagName) {
        StringBuilder tagBuilder = new StringBuilder();
        tagBuilder.append("<" + tagName + ">");
        tagBuilder.append(data.toString());
        tagBuilder.append("</" + tagName + ">");
        return tagBuilder.toString();
    }
}
