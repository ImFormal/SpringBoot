package com.adrar.hello.service;

import com.adrar.hello.model.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

    //Methode
    public HelloWorld getHelloWorld() {
        HelloWorld hello = new HelloWorld();
        hello.setValue("Hello World");
        return hello;
    }
}