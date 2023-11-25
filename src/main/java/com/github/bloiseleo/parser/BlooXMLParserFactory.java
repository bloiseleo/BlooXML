package com.github.bloiseleo.parser;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Map;

class BlooXMLParserFactory {
    private Map<String, BlooXMLParser> parserMap = new HashMap();
    public BlooXMLParserFactory() {
        parserMap.put(String.class.getName(), new BlooXMLStringParser());
        parserMap.put(Integer.class.getName(), new BlooXMLStringParser());
        parserMap.put(Double.class.getName(), new BlooXMLStringParser());
        parserMap.put(Float.class.getName(), new BlooXMLStringParser());
        parserMap.put(Character.class.getName(), new BlooXMLStringParser());
        parserMap.put(Long.class.getName(), new BlooXMLStringParser());
        parserMap.put(AbstractCollection.class.getName(), new BlooXMLCollectionParser());
    }
    public BlooXMLParser get(Object object) {
        Class<?> objectClass = object.getClass();
        while (objectClass != null) {
            String className = objectClass.getName();
            if (!parserMap.containsKey(className)) {
                objectClass = objectClass.getSuperclass();
                continue;
            }
            return parserMap.get(className);
        }
        return new BlooXMLObjectParser();
    }
}
