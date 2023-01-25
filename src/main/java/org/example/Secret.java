package org.example;

public class Secret {
    private String name;

    public Secret(String name) {
        this.name = name;
    }

    public String getCurrentSecret() {
        return name;
    }
}
