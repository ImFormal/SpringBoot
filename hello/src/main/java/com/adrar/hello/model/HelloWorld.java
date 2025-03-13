package com.adrar.hello.model;

public class HelloWorld {

    //Attribut
    private String value;

    //Getter et Setter
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //Methode
    @Override
    public String toString() {
        return this.value;
    }
}