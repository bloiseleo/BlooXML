package com.github.bloiseleo;

import com.github.bloiseleo.parser.annotation.TagName;

import java.util.Arrays;
import java.util.List;

@TagName("user")
public class User {
    public long version = 1L;
    public String nome;
    public int age;
    public List<String> roles = Arrays.asList("ADMIN", "ROLE");
    public User(String nome, int age) {
        this.nome = nome;
        this.age = age;
    }
}
