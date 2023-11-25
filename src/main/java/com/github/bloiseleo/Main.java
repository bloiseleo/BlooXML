package com.github.bloiseleo;

import com.github.bloiseleo.parser.BlooXML;


public class Main {
    public static void main(String[] args) {
        BlooXML blooXML = new BlooXML();
        User user = new User("Leo", 12);
        String xml = blooXML.parse(user);
        System.out.println(xml);
    }
}
