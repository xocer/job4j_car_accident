package ru.job4j.accident.model;

import lombok.Data;

import java.util.Set;

@Data
public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;
    private Set<Rule> rules;

    public Accident(String name, String text, String address) {
        this.name = name;
        this.text = text;
        this.address = address;
    }
}
